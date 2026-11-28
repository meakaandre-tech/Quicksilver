#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 11 (pixel art look): one pass at the small size. Each pixel of the world as drawn there is
// mapped to the nearest colour of the natural palette (vanilla's map colours in their four shades; Sampler2 holds the
// nearest palette colour for each of 32x32x32 colours: texel r + 32 * b, g), after ordered 4x4 Bayer dithering
// (QS_DITHER), and darkened on the near side of an exposed edge (QS_OUTLINES).
//
// Outlines, from the depth image only: depth is affine in 1/distance for every projection the game uses, so along a
// flat surface (a floor or wall of many blocks, at any angle) it changes linearly from pixel to pixel and its second
// difference is zero: no line between blocks that join, no grid. Where the pixel is nearer than the line through its
// two neighbours (on a row or a column) by a good share of the change across them, it is on the near side of a convex
// edge: an object's outline against what is behind it (a block on a floor, a cliff's edge against the ground below, a
// shape against the sky) or a block's outer corner. Inside corners (a wall meeting the floor) bend the other way and
// get no line. The outline is one pixel wide, on the nearer object, and fades out with the distance fog (QsPixelArt:
// the frame's projection gives each pixel's distance), so terrain the fog has hidden draws no line against the sky. At
// the picture's edge a row or column is only tested where both neighbours are inside.
uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform sampler2D Sampler2;

layout(std140) uniform QsPixelArt {
    // x, y: the projection's m22 and m32 (distance along the view = m32 / (ndc + m22)); z: 1 if depth 0..1 is normalized
    // z itself; w: the projection's m00
    vec4 QsDepth;
    // x, y: where the fog starts and ends (blocks); z: 1 if there is fog to fade by; w: the projection's m11
    vec4 QsFog;
    // package 12c: rgb the fog's colour now, w: 1 for the fog tones and the dithering's fade in the fog
    vec4 QsFogColour;
    // rgb the sky's colour now
    vec4 QsSkyColour;
};

layout(location = 0) in vec2 qsNdc;
layout(location = 0) out vec4 fragColor;

const float BAYER[16] = float[16](0.0, 8.0, 2.0, 10.0, 12.0, 4.0, 14.0, 6.0, 3.0, 11.0, 1.0, 9.0, 15.0, 7.0, 13.0, 5.0);

vec3 paletteColour(vec3 c) {
    ivec3 q = ivec3(clamp(floor(c * 31.0 + 0.5), 0.0, 31.0));
    return texelFetch(Sampler2, ivec2(q.r + 32 * q.b, q.g), 0).rgb;
}

// the palette's "redmean" distance (Palette.nearest), in 0..1 colours
float redmean(vec3 a, vec3 b) {
    vec3 d = (a - b) * 255.0;
    float rm = (a.r + b.r) * 127.5;
    return (512.0 + rm) * d.r * d.r + 1024.0 * d.g * d.g + (767.0 - rm) * d.b * d.b;
}

// package 12c: the palette colour, or a fog tone where one is nearer: the fog's and the sky's colours and their blends, and
// the palette colour blended toward the fog at 25, 50 and 75% (hazy far land), so pale fog and sky aren't dithered
// between far-apart palette colours (a heavy checkerboard over far terrain and the sky)
vec3 toned(vec3 c, vec3 p) {
    if (QsFogColour.w < 0.5) return p;
    vec3 f = QsFogColour.rgb, s = QsSkyColour.rgb;
    vec3 best = p;
    float bd = redmean(c, p);
    vec3 cand[8] = vec3[8](f, s, mix(f, s, 0.25), mix(f, s, 0.5), mix(f, s, 0.75), mix(p, f, 0.25), mix(p, f, 0.5), mix(p, f, 0.75));
    for (int i = 0; i < 8; i++) {
        float d = redmean(c, cand[i]);
        if (d < bd) {
            bd = d;
            best = cand[i];
        }
    }
    return best;
}

// package 12c: how far into the fog this pixel is (0 near, 1 at the fog's end; the sky, at the far plane: 1)
float fogShare(ivec2 p, ivec2 size) {
    if (QsFog.z < 0.5 || QsDepth.y == 0.0) return 0.0;
    float d = texelFetch(Sampler1, p, 0).r;
    float ndc = QsDepth.z > 0.5 ? d : d * 2.0 - 1.0;
    vec2 sxy = (vec2(p) + 0.5) / vec2(size) * 2.0 - 1.0;
    vec2 slope = sxy / vec2(QsDepth.w, QsFog.w);
    float denom = ndc + QsDepth.x;
    if (abs(denom) < 1.0e-6) return 1.0;
    float dist = QsDepth.y / denom * sqrt(1.0 + dot(slope, slope));
    if (dist < 0.0) return 1.0;
    return smoothstep(QsFog.x, QsFog.y, dist);
}

// larger is nearer, whichever way the depth test runs
float nearness(ivec2 p, ivec2 size) {
    float d = texelFetch(Sampler1, clamp(p, ivec2(0), size - ivec2(1)), 0).r;
#ifdef QS_REVERSED_DEPTH
    return d;
#else
    return -d;
#endif
}

bool convex(float a, float c, float b) {
    float e = a + b - 2.0 * c;
    float g = abs(c - a) + abs(b - c);
    return e < -max(0.3 * g, 2.0e-6);
}

void main() {
    ivec2 p = ivec2(gl_FragCoord.xy);
    ivec2 size = textureSize(Sampler0, 0);
    vec3 c = texelFetch(Sampler0, p, 0).rgb;
#ifdef QS_OUTLINES
    float n = nearness(p, size);
    bool edge = (p.x > 0 && p.x < size.x - 1 && convex(nearness(p - ivec2(1, 0), size), n, nearness(p + ivec2(1, 0), size)))
        || (p.y > 0 && p.y < size.y - 1 && convex(nearness(p - ivec2(0, 1), size), n, nearness(p + ivec2(0, 1), size)));
    if (edge) {
        float strength = 1.0;
        if (QsFog.z > 0.5 && QsDepth.y != 0.0) {
            float d = texelFetch(Sampler1, p, 0).r;
            float ndc = QsDepth.z > 0.5 ? d : d * 2.0 - 1.0;
            // the distance from the eye (not only along the view); vanilla's render-distance fog is cylindrical and
            // linear, so the fade here starts a little earlier than the fog does: harmless
            vec2 sxy = (vec2(p) + 0.5) / vec2(size) * 2.0 - 1.0;
            vec2 slope = sxy / vec2(QsDepth.w, QsFog.w);
            float dist = QsDepth.y / (ndc + QsDepth.x) * sqrt(1.0 + dot(slope, slope));
            strength = 1.0 - smoothstep(QsFog.x, QsFog.y, dist);
        }
        c *= mix(1.0, 0.45, strength);
    }
#endif
#ifdef QS_DITHER
    float t = (BAYER[(p.y & 3) * 4 + (p.x & 3)] + 0.5) / 16.0 - 0.5;
    // package 12c: the dithering fades out in the fog, as the outlines do (and is gone in the sky)
    float amount = QsFogColour.w > 0.5 ? 1.0 - fogShare(p, size) : 1.0;
    c += t * 0.1 * amount;
#endif
    fragColor = vec4(toned(c, paletteColour(c)), 1.0);
}

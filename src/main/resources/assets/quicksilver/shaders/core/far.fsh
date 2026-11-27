#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver far terrain (package 12), fragment stage. Nothing inside the hand-over circle (real terrain is there),
// except in its holes (package 12b): below the lowest real section drawn in its chunk column, filled behind real terrain,
// or in a column with none drawn (vanilla leaves out sections more than the render distance below the camera), at the
// band's front depth.
// Across the hand-over band an ordered 4x4 dither moves a growing share of far terrain's pixels from behind real terrain
// to just in front of it (its depth recomputed for the eye position scaled nearer), so the change from real to far
// terrain is spread over the band, not drawn as a line. Fogged with the game's own fog.

#include <minecraft:fog.glsl>
#include <minecraft:projection.glsl>
#include <minecraft:terrainglobals.glsl>

layout(std140) uniform QsFar {
    vec4 qsFarAnchor;
    vec4 qsFarHand;
    vec4 qsFarDebug;
    vec4 qsFarGrid;
    uvec4 qsFarLow[289];
};

layout(location = 0) in vec3 qsEye;
layout(location = 1) in vec4 qsColor;

layout(location = 0) out vec4 fragColor;

const float QS_BAYER[16] = float[16](0.0, 8.0, 2.0, 10.0, 12.0, 4.0, 14.0, 6.0, 3.0, 11.0, 1.0, 9.0, 15.0, 7.0, 13.0, 5.0);

// whether this far terrain point lies below every section of real terrain drawn in its chunk column (or the column has
// none drawn): real terrain isn't drawn there, so far terrain fills it
// 0: real terrain is drawn there; 1: below the lowest drawn section (filled behind real terrain); 2: a column with no real
// section drawn at all (filled in front, as the band's pixels and the tiles beyond it, so far terrain's own surfaces keep
// their order across the band's inner edge)
int qsHole(vec3 eye, vec3 n) {
    vec2 g = floor((eye.xz - qsFarGrid.xy) * (1.0 / 16.0));
    if (g.x < 0.0 || g.y < 0.0 || g.x >= qsFarGrid.z || g.y >= qsFarGrid.z) return 0;
    int i = int(g.y) * int(qsFarGrid.z) + int(g.x);
    uint w = qsFarLow[i >> 4][(i >> 2) & 3];
    uint b = (w >> uint(8 * (i & 3))) & 255u;
    uint low = b & 127u;
    if (low == 127u) return 2;
    // the point's section above the floor (qsFarAnchor.y: the floor against the camera)
    // (less 1/32 block: far ground at exactly a section's bottom stands for the block face of the section below it)
    float section = floor((eye.y - qsFarAnchor.y - 0.03125) * (1.0 / 16.0));
    if (section < float(low)) return 1;
    // a column cut by vanilla's vertical reach (bit 7): its lowest drawn section too, for far terrain's steep parts (its
    // slopes under the cut real cliffs), never its flat tops
    if ((b & 128u) != 0u && section == float(low) && abs(n.y) < 0.7) return 1;
    return 0;
}

float qsNdcDepth(float k) {
    vec4 c = ProjMat * ModelViewMat * vec4(qsEye * k, 1.0);
    return c.z / c.w;
}

void main() {
    // the surface's normal, from the eye position's screen derivatives (here, before any branch: derivatives need every
    // fragment of the quad to run them)
    vec3 qsN = normalize(cross(dFdx(qsEye), dFdy(qsEye)));
    float d = length(qsEye.xz);
    if (d < qsFarHand.x) {
        // a hole: below real terrain's lowest drawn section, behind real terrain (its vertex stage's depth), so real terrain
        // still wins where both draw; a column with nothing real drawn, in front (as beyond the band)
        int hole = qsFarDebug.z < 0.5 ? 0 : qsHole(qsEye, qsN);
        if (hole == 0) discard;
        if (hole == 2) {
            float back = qsNdcDepth(qsFarHand.z);
            float front = qsNdcDepth(qsFarHand.w);
            float a = abs(gl_FragCoord.z - (0.5 * back + 0.5)) < abs(gl_FragCoord.z - back) ? 0.5 : 1.0;
            gl_FragDepth = clamp(gl_FragCoord.z + a * (front - back), 0.0, 1.0);
        } else {
            gl_FragDepth = gl_FragCoord.z;
        }
        fragColor = apply_fog(qsColor, fog_spherical_distance(qsEye), fog_cylindrical_distance(qsEye), FogEnvironmentalStart, FogEnvironmentalEnd,
            FogRenderDistanceStart, FogRenderDistanceEnd, FogColor);
        return;
    }
    float t = clamp((d - qsFarHand.x) / max(qsFarHand.y - qsFarHand.x, 1.0), 0.0, 1.0);
    ivec2 p = ivec2(gl_FragCoord.xy) & 3;
    float threshold = (QS_BAYER[p.y * 4 + p.x] + 0.5) * (1.0 / 16.0);
    bool band = qsFarDebug.x > 0.5 && d < qsFarHand.y;
    if (band) threshold = -1.0;
    // beyond the band's far edge every pixel is in front (real sections reach a chunk past the render distance), as
    // far_front.vsh draws the tiles wholly beyond it
    if (t > threshold) {
        float back = qsNdcDepth(qsFarHand.z);
        float front = qsNdcDepth(qsFarHand.w);
        // window depth from NDC depth is 0.5 z + 0.5 (OpenGL's -1..1) or z (0..1): whichever this fragment's own depth fits
        float a = abs(gl_FragCoord.z - (0.5 * back + 0.5)) < abs(gl_FragCoord.z - back) ? 0.5 : 1.0;
        gl_FragDepth = clamp(gl_FragCoord.z + a * (front - back), 0.0, 1.0);
    } else {
        gl_FragDepth = gl_FragCoord.z;
    }
    if (band) {
        fragColor = vec4(1.0, 0.0, 1.0, 1.0);
        return;
    }
    fragColor = apply_fog(qsColor, fog_spherical_distance(qsEye), fog_cylindrical_distance(qsEye), FogEnvironmentalStart, FogEnvironmentalEnd,
        FogRenderDistanceStart, FogRenderDistanceEnd, FogColor);
}

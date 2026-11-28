#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver far terrain (package 12), fragment stage for tiles wholly beyond the hand-over band: no real terrain
// there, so no dither, no discard and no depth of its own (far_front.vsh draws them in front of their true depth; the GPU can reject hidden pixels before shading them; the
// band's shader, far.fsh, writes depth and so can't). Fogged with the game's own fog, as in far.fsh.

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

// package 12c: a light haze toward the fog's colour with distance past the hand-over band (none at the band, so real and
// far terrain meet unchanged), stronger in rain and thunder (qsFarGrid.w: its share at the fog's end; 0 for 12b's look);
// at sunset and night it takes the fog's colour like everything else
vec4 qsHaze(vec4 c, vec3 eye) {
    float h = qsFarGrid.w * smoothstep(qsFarHand.y, max(FogRenderDistanceEnd, qsFarHand.y + 1.0), length(eye.xz));
    return vec4(mix(c.rgb, FogColor.rgb, h), c.a);
}

void main() {
    // the block stays in use (the pipeline binds it); qsFarDebug.y is always 0
    vec4 color = qsFarDebug.y > 0.5 ? vec4(1.0, 0.0, 1.0, 1.0) : qsColor;
    fragColor = apply_fog(qsHaze(color, qsEye), fog_spherical_distance(qsEye), fog_cylindrical_distance(qsEye), FogEnvironmentalStart, FogEnvironmentalEnd,
        FogRenderDistanceStart, FogRenderDistanceEnd, FogColor);
}

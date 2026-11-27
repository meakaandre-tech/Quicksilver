#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver far terrain (package 12), vertex stage. The 8-byte far vertex: x and z as block offsets from the tile set's
// anchor (+32768), y in 1/16 block above the dimension's floor, and the colour as RGB565 (its facing's shade already in
// it). Lit with the lightmap's full-sky texel (so far terrain darkens with the day like the sky light of real terrain),
// fogged in the fragment stage with the game's own fog functions. Drawn a little behind its true depth (the eye position
// scaled about the camera, so the same pixel): real terrain wins wherever both draw.

#include <minecraft:globals.glsl>
#include <minecraft:projection.glsl>
#include <minecraft:sample_lightmap.glsl>
#include <minecraft:terrainglobals.glsl>

uniform sampler2D Sampler2;

layout(std140) uniform QsFar {
    // xyz: the anchor's position against the camera (y: the floor's), w: the floor's y
    vec4 qsFarAnchor;
    // x, y: the hand-over band (horizontal distance where far terrain starts, where it is fully in), z: behind, w: in front
    vec4 qsFarHand;
    // x: 1 paints the hand-over band (CI's seam check); z: 1 fills holes inside the hand-over circle
    vec4 qsFarDebug;
    // x, y: the hole grid's corner (x, z) against the camera, blocks; z: its width in chunk columns
    vec4 qsFarGrid;
    // one byte per chunk column of the grid: bits 0-6 its lowest section with drawn real geometry above the floor (127:
    // none), bit 7 that section is vanilla's cut; far terrain fills below it
    uvec4 qsFarLow[289];
};

layout(location = 0) in uvec4 QsFarVertex;

layout(location = 0) out vec3 qsEye;
layout(location = 1) out vec4 qsColor;

void main() {
    vec3 eye = vec3(float(QsFarVertex.x) - 32768.0, float(QsFarVertex.y) * (1.0 / 16.0), float(QsFarVertex.z) - 32768.0) + qsFarAnchor.xyz;
    uint c = QsFarVertex.w;
    vec3 rgb = vec3(float((c >> 11u) & 31u) * (1.0 / 31.0), float((c >> 5u) & 63u) * (1.0 / 63.0), float(c & 31u) * (1.0 / 31.0));
    qsColor = vec4(rgb, 1.0) * sample_lightmap(Sampler2, ivec2(0, 240));
    qsEye = eye;
    gl_Position = ProjMat * ModelViewMat * vec4(eye * qsFarHand.z, 1.0);
}

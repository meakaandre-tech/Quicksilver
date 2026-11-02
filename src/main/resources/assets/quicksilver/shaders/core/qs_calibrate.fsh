#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 2b: which half of normalized x (red) and y (green) a texel of a 2x2 target is in, so the CPU
// learns which way up the backend stores rendered rows.
layout(location = 0) in vec2 qsNdc;
layout(location = 0) out vec4 fragColor;

void main() {
    fragColor = vec4(qsNdc.x > 0.0 ? 1.0 : 0.0, qsNdc.y > 0.0 ? 1.0 : 0.0, 0.0, 1.0);
}

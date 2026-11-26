#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 11 (pixel art look): the small picture scaled up to the window with sharp nearest-neighbour
// pixels (each window pixel takes the small pixel its centre falls in).
uniform sampler2D Sampler0;

layout(location = 0) in vec2 qsNdc;
layout(location = 0) out vec4 fragColor;

void main() {
    ivec2 size = textureSize(Sampler0, 0);
    vec2 uv = qsNdc * 0.5 + 0.5;
    ivec2 t = clamp(ivec2(floor(uv * vec2(size))), ivec2(0), size - ivec2(1));
    fragColor = vec4(texelFetch(Sampler0, t, 0).rgb, 1.0);
}

#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 2b: one triangle covering the whole target (no vertex buffer); passes normalized x and y on.
layout(location = 0) out vec2 qsNdc;

void main() {
    // renderpearl compiles GLSL with Vulkan semantics (the OpenGL backend translates it back): gl_VertexIndex
    int id = gl_VertexIndex;
    vec2 p = vec2(float((id << 1) & 2), float(id & 2)) * 2.0 - 1.0;
    qsNdc = p;
    gl_Position = vec4(p, 0.0, 1.0);
}

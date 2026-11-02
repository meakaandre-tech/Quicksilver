#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 2b: one triangle covering the whole target (no vertex buffer), drawn twice with opposite
// windings (vertices 0-2 and 3-5) so it is drawn whichever winding the backend's y direction and culling keep; passes
// normalized x and y on. Both copies write the same values.
layout(location = 0) out vec2 qsNdc;

void main() {
    // renderpearl compiles GLSL with Vulkan semantics (the OpenGL backend translates it back): gl_VertexIndex
    int id = gl_VertexIndex % 3;
    if (gl_VertexIndex >= 3 && id != 0) id = 3 - id;
    vec2 p = vec2(float((id << 1) & 2), float(id & 2)) * 2.0 - 1.0;
    qsNdc = p;
    gl_Position = vec4(p, 0.0, 1.0);
}

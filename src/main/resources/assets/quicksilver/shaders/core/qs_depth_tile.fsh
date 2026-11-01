#version 330
#extension GL_ARB_separate_shader_objects : require

// Quicksilver, package 2b: level 0 of the depth pyramid. Each texel is one 16x16 tile of the frame's depth image: the
// farthest depth in it (with QS_NEAREST, for devices whose depth test keeps greater values, the smallest), stored as
// the float's raw bits in RGBA8 so the CPU reads the exact value back.
uniform sampler2D Sampler0;

layout(location = 0) in vec2 qsNdc;
layout(location = 0) out vec4 fragColor;

void main() {
    ivec2 size = textureSize(Sampler0, 0);
    ivec2 base = ivec2(gl_FragCoord.xy) * 16;
#ifdef QS_NEAREST
    float far = 1.0;
#else
    float far = 0.0;
#endif
    for (int y = 0; y < 16; y++) {
        int sy = base.y + y;
        if (sy >= size.y) break;
        for (int x = 0; x < 16; x++) {
            int sx = base.x + x;
            if (sx >= size.x) break;
            float d = texelFetch(Sampler0, ivec2(sx, sy), 0).r;
#ifdef QS_NEAREST
            far = min(far, d);
#else
            far = max(far, d);
#endif
        }
    }
    uint u = floatBitsToUint(far);
    fragColor = vec4(float(u & 255u), float((u >> 8u) & 255u), float((u >> 16u) & 255u), float(u >> 24u)) / 255.0;
}

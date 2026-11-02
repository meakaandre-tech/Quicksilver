package com.meakaandre.quicksilver.occlusion;

/**
 * A small depth image of one frame's opaque terrain (package 2b), and the test of a box against it.
 *
 * <p>Level 0 holds, for each tile of {@link #TILE}x{@link #TILE} pixels of the frame's depth image, the farthest depth
 * of any pixel in the tile (built on the GPU, read back); each level above holds the farthest of 2x2 texels below it.
 * Depths are kept "forward" (larger is farther) whatever the device's depth convention.
 *
 * <p>The test is conservative: a box is hidden only if every one of its corners is in front of the camera's near
 * plane, and the nearest depth any point of the box can have is farther (by a margin) than the farthest depth drawn
 * anywhere in the pixels its screen rectangle can touch (grown by a pixel on every side). Every fragment of geometry
 * inside the box then fails the depth test against what was already drawn there. Depth is a monotonic function of
 * view depth, which is linear in position, so the nearest point of a box is one of its corners.
 *
 * <p>Pure Java (no game classes), so its geometry is checked outside the game against brute-force rasterising.
 */
public final class DepthPyramid {
    public static final int TILE = 16;
    /** Depth margin: rasterised depth can be a few float steps off the exact value. */
    static final double DEPTH_EPS = 1e-6;
    /** Pixel margin on every side of a box's screen rectangle (rounding, rasterisation rules). */
    static final double PIXEL_MARGIN = 1.0;
    /** A corner this close to (or behind) the camera plane makes the box count as visible. */
    static final double MIN_W = 1e-4;

    /** The frame's viewport in pixels. */
    final int width, height;
    final int levels;
    final int[] lw, lh;
    final float[][] lv;
    /** Camera-relative position to clip space, column-major (as JOML stores it). */
    final double[] m = new double[16];
    /** The camera position the matrix is relative to. */
    final double camX, camY, camZ;
    /** Depth image row 0 is the top of the picture (normalized y = +1). */
    final boolean flipY;
    /** The device maps clip z/w straight to depth (else z/w * 0.5 + 0.5). */
    final boolean zeroToOne;
    /** Larger depth is nearer (the depth test keeps greater values). */
    final boolean reversed;

    /**
     * @param level0 farthest raw depth per tile, row by row ({@code tw = ceil(width / TILE)} by {@code th}), row 0 the
     *               depth image's row 0; raw values as stored (nearest per tile instead when {@code reversed})
     * @param matrix camera-relative to clip, column-major
     */
    public DepthPyramid(int width, int height, float[] level0, double[] matrix, double camX, double camY, double camZ,
                        boolean flipY, boolean zeroToOne, boolean reversed) {
        this.width = width;
        this.height = height;
        System.arraycopy(matrix, 0, m, 0, 16);
        this.camX = camX;
        this.camY = camY;
        this.camZ = camZ;
        this.flipY = flipY;
        this.zeroToOne = zeroToOne;
        this.reversed = reversed;
        int tw = tiles(width), th = tiles(height);
        if (level0.length < tw * th) throw new IllegalArgumentException("level 0 has " + level0.length + " texels, needs " + tw * th);
        int n = 1;
        for (int w = tw, h = th; w > 1 || h > 1; w = (w + 1) >> 1, h = (h + 1) >> 1) n++;
        levels = n;
        lw = new int[n];
        lh = new int[n];
        lv = new float[n][];
        lw[0] = tw;
        lh[0] = th;
        lv[0] = new float[tw * th];
        for (int i = 0; i < tw * th; i++) {
            float d = level0[i];
            // NaN or out of range: treat as nothing drawn there (far), so it never hides anything
            if (!(d >= 0f && d <= 1f)) d = reversed ? 0f : 1f;
            lv[0][i] = reversed ? 1f - d : d;
        }
        for (int l = 1; l < n; l++) {
            int pw = lw[l - 1], ph = lh[l - 1];
            int w = (pw + 1) >> 1, h = (ph + 1) >> 1;
            lw[l] = w;
            lh[l] = h;
            float[] src = lv[l - 1], dst = new float[w * h];
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int sx = x * 2, sy = y * 2;
                    float v = src[sy * pw + sx];
                    if (sx + 1 < pw) v = Math.max(v, src[sy * pw + sx + 1]);
                    if (sy + 1 < ph) {
                        v = Math.max(v, src[(sy + 1) * pw + sx]);
                        if (sx + 1 < pw) v = Math.max(v, src[(sy + 1) * pw + sx + 1]);
                    }
                    dst[y * w + x] = v;
                }
            }
            lv[l] = dst;
        }
    }

    public static int tiles(int pixels) {
        return (pixels + TILE - 1) / TILE;
    }

    /** Result of {@link #test}. */
    public enum Result { VISIBLE, HIDDEN, OFF_SCREEN }

    /**
     * Tests a box given in world coordinates (min and max corners). {@link Result#HIDDEN}: every point of it is behind
     * what was drawn; {@link Result#OFF_SCREEN}: it projects entirely outside the picture.
     */
    public Result test(double x0, double y0, double z0, double x1, double y1, double z1) {
        return test(x0, y0, z0, x1, y1, z1, true);
    }

    /**
     * As above. {@code ownView}: the box is tested for the very view this pyramid was drawn with, so what lies outside
     * the picture is not seen. Otherwise (the same eye looking another way, still camera) nothing is known outside the
     * picture: a box reaching outside it is visible.
     */
    public Result test(double x0, double y0, double z0, double x1, double y1, double z1, boolean ownView) {
        double ax = x0 - camX, ay = y0 - camY, az = z0 - camZ;
        double bx = x1 - camX, by = y1 - camY, bz = z1 - camZ;
        double minX = Double.POSITIVE_INFINITY, maxX = Double.NEGATIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY;
        double nearest = Double.POSITIVE_INFINITY;
        for (int c = 0; c < 8; c++) {
            double px = (c & 1) == 0 ? ax : bx, py = (c & 2) == 0 ? ay : by, pz = (c & 4) == 0 ? az : bz;
            double cx = m[0] * px + m[4] * py + m[8] * pz + m[12];
            double cy = m[1] * px + m[5] * py + m[9] * pz + m[13];
            double cz = m[2] * px + m[6] * py + m[10] * pz + m[14];
            double cw = m[3] * px + m[7] * py + m[11] * pz + m[15];
            if (!(cw > MIN_W)) return Result.VISIBLE;
            double nx = cx / cw, ny = cy / cw, nz = cz / cw;
            double d = zeroToOne ? nz : nz * 0.5 + 0.5;
            double f = reversed ? 1.0 - d : d;
            if (f < nearest) nearest = f;
            if (nx < minX) minX = nx;
            if (nx > maxX) maxX = nx;
            if (ny < minY) minY = ny;
            if (ny > maxY) maxY = ny;
        }
        if (!(nearest > 0.0)) return Result.VISIBLE;
        // pixel rectangle (x from the left, row from the depth image's row 0), grown by the margin
        double px0 = (minX * 0.5 + 0.5) * width - PIXEL_MARGIN, px1 = (maxX * 0.5 + 0.5) * width + PIXEL_MARGIN;
        double up0 = (minY * 0.5 + 0.5) * height, up1 = (maxY * 0.5 + 0.5) * height;
        double py0, py1;
        if (flipY) {
            py0 = height - up1 - PIXEL_MARGIN;
            py1 = height - up0 + PIXEL_MARGIN;
        } else {
            py0 = up0 - PIXEL_MARGIN;
            py1 = up1 + PIXEL_MARGIN;
        }
        if (!ownView && (px0 < 0 || py0 < 0 || px1 >= width || py1 >= height)) return Result.VISIBLE;
        if (px1 < 0 || py1 < 0 || px0 >= width || py0 >= height) return Result.OFF_SCREEN;
        int ix0 = (int) Math.max(0, Math.floor(px0)), ix1 = (int) Math.min(width - 1, Math.floor(px1));
        int iy0 = (int) Math.max(0, Math.floor(py0)), iy1 = (int) Math.min(height - 1, Math.floor(py1));
        int tx0 = ix0 / TILE, tx1 = ix1 / TILE, ty0 = iy0 / TILE, ty1 = iy1 / TILE;
        int l = 0;
        while (l + 1 < levels && ((tx1 >> l) - (tx0 >> l) > 1 || (ty1 >> l) - (ty0 >> l) > 1)) l++;
        int x0l = tx0 >> l, x1l = tx1 >> l, y0l = ty0 >> l, y1l = ty1 >> l;
        int w = lw[l];
        float[] v = lv[l];
        float far = 0f;
        for (int y = y0l; y <= y1l; y++) for (int x = x0l; x <= x1l; x++) far = Math.max(far, v[y * w + x]);
        return nearest > far + DEPTH_EPS ? Result.HIDDEN : Result.VISIBLE;
    }

    /**
     * The eye point of a camera-relative to clip matrix: the point every view ray starts from (clip x, y and w are zero
     * there), relative to the camera. Includes any translation in the matrix (view bobbing). Null if the matrix has no
     * single eye point.
     */
    public static double[] eye(double[] m) {
        // rows 0, 1, 3 of M times (e, 1) = 0  =>  A e = -t
        double a00 = m[0], a01 = m[4], a02 = m[8], t0 = m[12];
        double a10 = m[1], a11 = m[5], a12 = m[9], t1 = m[13];
        double a20 = m[3], a21 = m[7], a22 = m[11], t2 = m[15];
        double det = a00 * (a11 * a22 - a12 * a21) - a01 * (a10 * a22 - a12 * a20) + a02 * (a10 * a21 - a11 * a20);
        if (!(Math.abs(det) > 1e-12)) return null;
        double b0 = -t0, b1 = -t1, b2 = -t2;
        double ex = (b0 * (a11 * a22 - a12 * a21) - a01 * (b1 * a22 - a12 * b2) + a02 * (b1 * a21 - a11 * b2)) / det;
        double ey = (a00 * (b1 * a22 - a12 * b2) - b0 * (a10 * a22 - a12 * a20) + a02 * (a10 * b2 - b1 * a20)) / det;
        double ez = (a00 * (a11 * b2 - b1 * a21) - a01 * (a10 * b2 - b1 * a20) + b0 * (a10 * a21 - a11 * a20)) / det;
        return new double[] {ex, ey, ez};
    }
}

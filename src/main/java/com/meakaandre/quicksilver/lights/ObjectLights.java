package com.meakaandre.quicksilver.lights;

/** Package 13, Fancy: entities' and block entities' light values (render thread, from the extract hooks). */
public final class ObjectLights {
    private ObjectLights() {
    }

    /** Whether the frame hook ran (the bench reports it; a game whose extract code moved leaves lights unfound). */
    public static volatile boolean hookSeen;

    public static int entity(int lightCoords, double x, double y, double z) {
        return DynamicLights.raise(lightCoords, x, y, z, false);
    }

    public static int blockEntity(int lightCoords, double x, double y, double z) {
        return DynamicLights.raise(lightCoords, x, y, z, true);
    }
}

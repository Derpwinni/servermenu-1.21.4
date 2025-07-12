package com.kevin.server.config;

import com.kevin.server.ServerMenuMod;

public class ServerMenuConfig {
    // Always enabled by default - no file I/O to avoid conflicts
    private static boolean enabled = true;
    private static boolean loaded = false;

    /**
     * Gets the current enabled state
     */
    public static boolean isEnabled() {
        return enabled;
    }

    /**
     * Load config - simplified to avoid conflicts
     */
    public static void load() {
        if (!loaded) {
            // Log initial state
            ServerMenuMod.LOGGER.info("ServerMenu initialized with default state: enabled");
            loaded = true;
        }
    }

    /**
     * Sets the enabled state - memory only, no file I/O
     */
    public static void setEnabled(boolean value) {
        if (enabled != value) {
            enabled = value;
            ServerMenuMod.LOGGER.info("ServerMenu state changed: " + (enabled ? "enabled" : "disabled"));
        }
    }

    /**
     * Toggles the enabled state
     */
    public static void toggleEnabled() {
        setEnabled(!isEnabled());
    }
}

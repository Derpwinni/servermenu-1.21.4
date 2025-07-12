package com.kevin.server;

import com.kevin.server.config.ServerMenuConfig;
import net.fabricmc.api.ClientModInitializer;

public class ServerMenuClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            // Make sure config is loaded on client initialization as well
            // This helps ensure compatibility with mods that might reset configs
            ServerMenuConfig.load();
            ServerMenuMod.LOGGER.info("ServerMenu client initialized");
        } catch (Exception e) {
            ServerMenuMod.LOGGER.error("Failed to initialize ServerMenu client", e);
        }
    }
}
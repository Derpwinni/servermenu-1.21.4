package com.kevin.server;

import com.kevin.server.config.ServerMenuConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMenuMod implements ModInitializer {
    public static final String MOD_ID = "servermenu";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        try {
            ServerMenuConfig.load();
            LOGGER.info("ServerMenu mod initialized");
        } catch (Exception e) {
            // Catch all exceptions to prevent startup crashes
            LOGGER.error("Failed to initialize ServerMenu mod", e);
        }
    }
}

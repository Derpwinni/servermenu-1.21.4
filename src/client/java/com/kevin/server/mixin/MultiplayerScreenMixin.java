package com.kevin.server.mixin;

import com.kevin.server.config.ServerMenuConfig;
import com.kevin.server.ServerMenuMod;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {

    @Shadow private MultiplayerServerListWidget serverListWidget;
    @Shadow private ServerInfo selectedEntry;

    // Store the last scroll position and selected index
    private static double lastScrollAmount = 0;
    private static int lastSelectedIndex = -1;

    @Inject(method = "init", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        MultiplayerScreen screen = (MultiplayerScreen)(Object)this;
        ScreenAccessor accessor = (ScreenAccessor) screen;

        try {
            // Position button in the left bottom corner
            int buttonWidth = 60;
            int buttonHeight = 20;
            int buttonX = 5; // Left side of screen
            int buttonY = screen.height - buttonHeight - 5; // Bottom of screen with 5px margin

            // Create toggle button with current state
            String buttonText = ServerMenuConfig.isEnabled() ? "SM: ON" : "SM: OFF";
            ButtonWidget toggleButton = ButtonWidget.builder(Text.literal(buttonText), button -> {
                // Toggle the state when clicked
                ServerMenuConfig.toggleEnabled();

                // Update button text
                button.setMessage(Text.literal(ServerMenuConfig.isEnabled() ? "SM: ON" : "SM: OFF"));
            })
            .dimensions(buttonX, buttonY, buttonWidth, buttonHeight)
            .build();

            // Add button to screen using accessor
            accessor.invokeAddDrawableChild(toggleButton);
        } catch (Exception e) {
            // Log but don't crash if button creation fails
            ServerMenuMod.LOGGER.error("Failed to add ServerMenu button", e);
        }

        // Only restore state if enabled
        if (ServerMenuConfig.isEnabled()) {
            // Restore scroll position
            if (lastScrollAmount > 0 && serverListWidget != null) {
                serverListWidget.setScrollY((int)lastScrollAmount);
            }

            // Restore selected server
            if (serverListWidget != null && lastSelectedIndex >= 0 && lastSelectedIndex < serverListWidget.children().size()) {
                MultiplayerServerListWidget.Entry entry = serverListWidget.children().get(lastSelectedIndex);
                serverListWidget.setSelected(entry);

                // If the entry is a server entry, set it as selected
                if (entry instanceof MultiplayerServerListWidget.ServerEntry serverEntry) {
                    this.selectedEntry = serverEntry.getServer();
                }
            }
        }
    }


    @Inject(method = "removed", at = @At("HEAD"))
    private void onRemoved(CallbackInfo ci) {
        // Only save state if enabled
        if (ServerMenuConfig.isEnabled() && serverListWidget != null) {
            // Save scroll position
            lastScrollAmount = serverListWidget.getScrollY();

            // Save selected server index
            lastSelectedIndex = -1;
            if (serverListWidget.getSelectedOrNull() != null) {
                lastSelectedIndex = serverListWidget.children().indexOf(serverListWidget.getSelectedOrNull());
            }
        }
    }
}

package net.celeri.dynmus.fabric;

import net.celeri.dynmus.fabric.config.DynamicMusicConfigFabric;
import net.celeri.dynmus.DynamicMusic;
import net.fabricmc.api.ClientModInitializer;

public class DynamicMusicFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DynamicMusicConfigFabric.init();
        DynamicMusic.init(DynamicMusicConfigFabric.getInstance());
    }
}

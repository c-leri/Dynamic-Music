package net.celeri.dynmus.fabric;

import net.celeri.dynmus.DynamicMusic;
import net.fabricmc.api.ClientModInitializer;

public class DynamicMusicFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DynamicMusic.init();
    }
}

package net.celeri.dynmus.fabric;

import eu.midnightdust.lib.config.MidnightConfig;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.fabricmc.api.ClientModInitializer;

public class DynamicMusicFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MidnightConfig.init(DynamicMusic.MOD_ID, DynamicMusicConfig.class);
        DynamicMusic.init();
    }
}

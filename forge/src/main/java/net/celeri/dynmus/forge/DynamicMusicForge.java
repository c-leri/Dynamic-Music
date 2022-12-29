package net.celeri.dynmus.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import net.celeri.dynmus.forge.config.DynamicMusicConfigForge;
import net.celeri.dynmus.DynamicMusic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DynamicMusic.MOD_ID)
public class DynamicMusicForge {
    public static DynamicMusicConfigForge config = Configuration.registerConfig(DynamicMusicConfigForge.class, ConfigFormats.json()).getConfigInstance();

    public DynamicMusicForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(DynamicMusic.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        DynamicMusic.init(config);
    }
}

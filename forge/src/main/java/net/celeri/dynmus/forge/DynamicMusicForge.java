package net.celeri.dynmus.forge;

import dev.architectury.platform.forge.EventBuses;
import me.shedaniel.autoconfig.AutoConfig;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DynamicMusic.MOD_ID)
public class DynamicMusicForge {
    public DynamicMusicForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(DynamicMusic.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> AutoConfig.getConfigScreen(DynamicMusicConfig.class, parent).get()));
        DynamicMusic.init();
    }
}

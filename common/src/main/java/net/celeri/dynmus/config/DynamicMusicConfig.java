package net.celeri.dynmus.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.celeri.dynmus.DynamicMusic;

@Config(name = DynamicMusic.MOD_ID)
@Config.Gui.Background(value = "minecraft:textures/block/stone.png")
public class DynamicMusicConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("generalConfig")
    @ConfigEntry.Gui.TransitiveObject
    public GeneralConfig generalConfig = new GeneralConfig();

    @ConfigEntry.Category("musicSelector")
    @ConfigEntry.Gui.TransitiveObject
    public MusicSelector musicSelector = new MusicSelector();
}
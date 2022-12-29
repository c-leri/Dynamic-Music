package net.celeri.dynmus.fabric.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;

@Config(name = DynamicMusic.MOD_ID)
@Config.Gui.Background(value = "minecraft:textures/block/stone.png")
public class DynamicMusicConfigFabric extends DynamicMusicConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip()
    public int searchRange = 5;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
    @ConfigEntry.Gui.Tooltip()
    public int darknessCap = 8;

    @ConfigEntry.Gui.Tooltip()
    public double darknessPercent = 0.3;

    @ConfigEntry.Gui.Tooltip()
    public double stonePercent = 0.15;

    @ConfigEntry.Gui.Tooltip()
    public int pseudoMineshaftSearchRange = 2;

    @ConfigEntry.Gui.Tooltip()
    public double pseudoMineshaftPercent = 0.1;

    @ConfigEntry.Gui.Tooltip()
    public boolean caveMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean coldMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean hotMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean niceMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean downMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean endCreativeMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean endBossMusic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean dynamicPitch = true;

    @ConfigEntry.Gui.Tooltip()
    public long dynamicPitchAnchor = 18000;

    @ConfigEntry.Gui.Tooltip()
    public boolean dynamicPitchFaster = false;

    public static void init() {
        AutoConfig.register(DynamicMusicConfigFabric.class, GsonConfigSerializer::new);
    }

    public static DynamicMusicConfigFabric getInstance() {
        return AutoConfig.getConfigHolder(DynamicMusicConfigFabric.class).getConfig();
    }

    @Override
    public int searchRange() {
        return searchRange;
    }

    @Override
    public int darknessCap() {
        return darknessCap;
    }

    @Override
    public double darknessPercent() {
        return darknessPercent;
    }

    @Override
    public double stonePercent() {
        return stonePercent;
    }

    @Override
    public int pseudoMineshaftSearchRange() {
        return pseudoMineshaftSearchRange;
    }

    @Override
    public double pseudoMineshaftPercent() {
        return pseudoMineshaftPercent;
    }

    @Override
    public boolean caveMusic() {
        return caveMusic;
    }

    @Override
    public boolean coldMusic() {
        return coldMusic;
    }

    @Override
    public boolean hotMusic() {
        return hotMusic;
    }

    @Override
    public boolean niceMusic() {
        return niceMusic;
    }

    @Override
    public boolean downMusic() {
        return downMusic;
    }

    @Override
    public boolean endCreativeMusic() {
        return endCreativeMusic;
    }

    @Override
    public boolean endBossMusic() {
        return endBossMusic;
    }

    @Override
    public boolean dynamicPitch() {
        return dynamicPitch;
    }

    @Override
    public long dynamicPitchAnchor() {
        return dynamicPitchAnchor;
    }

    @Override
    public boolean dynamicPitchFaster() {
        return dynamicPitchFaster;
    }
}

package net.celeri.dynmus.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "generalConfig")
public class GeneralConfig implements ConfigData {
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.TransitiveObject
    public MusicTypesToggles musicTypesToggles = new MusicTypesToggles();

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.TransitiveObject
    public DynamicPitch dynamicPitch = new DynamicPitch();

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.TransitiveObject
    public CaveDetection caveDetection = new CaveDetection();

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.TransitiveObject
    public MineshaftDetection mineshaftDetection = new MineshaftDetection();


    public static class MusicTypesToggles {
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
        public boolean endMusic = true;

        @ConfigEntry.Gui.Tooltip()
        public boolean endBossMusic = true;
    }

    public static class DynamicPitch {
        @ConfigEntry.Gui.Tooltip()
        public boolean activated = true;

        @ConfigEntry.Gui.Tooltip()
        public int anchor = 18000;

        public int getAnchor() {
            return anchor % 24000;
        }

        @ConfigEntry.Gui.Tooltip()
        public boolean faster = false;
    }

    public static class CaveDetection {
        @ConfigEntry.Gui.Tooltip()
        public int searchRange = 6;

        @ConfigEntry.Gui.Tooltip()
        public double stonePercent = 0.6;
    }

    public static class MineshaftDetection {
        @ConfigEntry.Gui.Tooltip()
        public int searchRange = 2;

        @ConfigEntry.Gui.Tooltip()
        public double percent = 0.2;
    }
}

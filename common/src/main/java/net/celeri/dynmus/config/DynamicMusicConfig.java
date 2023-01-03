package net.celeri.dynmus.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class DynamicMusicConfig extends MidnightConfig {
    // Music Types Toggles
    @Comment public static Comment musicTypesTitle;

    @Entry public static boolean caveMusic = true;

    @Entry public static boolean coldMusic = true;

    @Entry public static boolean hotMusic = true;

    @Entry public static boolean niceMusic = true;

    @Entry public static boolean downMusic = true;

    @Entry public static boolean endCreativeMusic = true;

    @Entry public static boolean endBossMusic = true;

    // Dynamic Pitch
    @Comment public static Comment dynamicPitchTitle;

    @Entry public static boolean dynamicPitch = true;

    @Entry(min = 0, max = 24000) public static int dynamicPitchAnchor = 18000;

    @Entry public static boolean dynamicPitchFaster = false;

    // Cave Detection
    @Comment public static Comment caveDetectionTitle;

    @Entry(min = 0) public static int searchRange = 5;

    @Entry(isSlider = true, min = 0, max = 15) public static int darknessCap = 8;

    @Entry(min = 0f, max = 1f) public static double darknessPercent = 0.3;

    @Entry(min = 0f, max = 1f) public static double stonePercent = 0.15;

    // Mineshaft Detection
    @Comment public static Comment mineshaftDetectionTitle;

    @Entry(min = 0) public static int pseudoMineshaftSearchRange = 2;

    @Entry(min = 0f, max = 1f) public static double pseudoMineshaftPercent = 0.1;
}
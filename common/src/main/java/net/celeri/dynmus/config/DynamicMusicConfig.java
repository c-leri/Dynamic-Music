package net.celeri.dynmus.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class DynamicMusicConfig extends MidnightConfig {
    // General Config
    @Comment(centered = true) public static Comment generalTitle;

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

    // Per Type Music Selector
    @Comment(centered = true) public static Comment musicSelectorTitle;

    // Cave Music Selector
    @Comment public static Comment caveMusicTitle;

    // Creative
    @Entry public static boolean creative1Cave = true;
    @Entry public static boolean creative2Cave = false;
    @Entry public static boolean creative3Cave = false;
    @Entry public static boolean creative4Cave = true;
    @Entry public static boolean creative5Cave = false;
    @Entry public static boolean creative6Cave = true;

    // Survival
    @Entry public static boolean calm1Cave = false;
    @Entry public static boolean calm2Cave = false;
    @Entry public static boolean calm3Cave = false;
    @Entry public static boolean hal1Cave = true;
    @Entry public static boolean hal2Cave = false;
    @Entry public static boolean hal3Cave = false;
    @Entry public static boolean hal4Cave = true;
    @Entry public static boolean nuance1Cave = false;
    @Entry public static boolean nuance2Cave = false;
    @Entry public static boolean piano1Cave = true;
    @Entry public static boolean piano2Cave = false;
    @Entry public static boolean piano3Cave = false;
    @Entry public static boolean aerieCave = true;
    @Entry public static boolean ancestryCave = true;
    @Entry public static boolean an_ordinary_dayCave = true;
    @Entry public static boolean comforting_memoriesCave = false;
    @Entry public static boolean firebugsCave = false;
    @Entry public static boolean floating_dreamCave = false;
    @Entry public static boolean infinite_amethystCave = true;
    @Entry public static boolean labyrinthineCave = false;
    @Entry public static boolean left_to_bloomCave = false;
    @Entry public static boolean one_more_dayCave = true;
    @Entry public static boolean stand_tallCave = false;
    @Entry public static boolean wendingCave = true;

    // Records
    @Entry public static boolean thirteenCave = true;
    @Entry public static boolean catCave = false;
    @Entry public static boolean blocksCave = false;
    @Entry public static boolean chirpCave = false;
    @Entry public static boolean farCave = false;
    @Entry public static boolean mallCave = false;
    @Entry public static boolean mellohiCave = false;
    @Entry public static boolean stalCave = false;
    @Entry public static boolean stradCave = false;
    @Entry public static boolean wardCave = false;
    @Entry public static boolean elevenCave = false;
    @Entry public static boolean waitCave = false;
    @Entry public static boolean othersideCave = false;
    @Entry public static boolean fiveCave = false;
    @Entry public static boolean pigstepCave = false;

    // Cold Music Selector
    @Comment public static Comment coldMusicTitle;

    // Creative
    @Entry public static boolean creative1Cold = false;
    @Entry public static boolean creative2Cold = true;
    @Entry public static boolean creative3Cold = false;
    @Entry public static boolean creative4Cold = false;
    @Entry public static boolean creative5Cold = true;
    @Entry public static boolean creative6Cold = false;

    // Survival
    @Entry public static boolean calm1Cold = false;
    @Entry public static boolean calm2Cold = false;
    @Entry public static boolean calm3Cold = false;
    @Entry public static boolean hal1Cold = false;
    @Entry public static boolean hal2Cold = true;
    @Entry public static boolean hal3Cold = false;
    @Entry public static boolean hal4Cold = false;
    @Entry public static boolean nuance1Cold = false;
    @Entry public static boolean nuance2Cold = true;
    @Entry public static boolean piano1Cold = false;
    @Entry public static boolean piano2Cold = false;
    @Entry public static boolean piano3Cold = false;
    @Entry public static boolean aerieCold = false;
    @Entry public static boolean ancestryCold = false;
    @Entry public static boolean an_ordinary_dayCold = false;
    @Entry public static boolean comforting_memoriesCold = true;
    @Entry public static boolean firebugsCold = false;
    @Entry public static boolean floating_dreamCold = false;
    @Entry public static boolean infinite_amethystCold = false;
    @Entry public static boolean labyrinthineCold = false;
    @Entry public static boolean left_to_bloomCold = false;
    @Entry public static boolean one_more_dayCold = false;
    @Entry public static boolean stand_tallCold = true;
    @Entry public static boolean wendingCold = false;

    // Records
    @Entry public static boolean thirteenCold = false;
    @Entry public static boolean catCold = false;
    @Entry public static boolean blocksCold = false;
    @Entry public static boolean chirpCold = false;
    @Entry public static boolean farCold = false;
    @Entry public static boolean mallCold = false;
    @Entry public static boolean mellohiCold = false;
    @Entry public static boolean stalCold = false;
    @Entry public static boolean stradCold = true;
    @Entry public static boolean wardCold = false;
    @Entry public static boolean elevenCold = false;
    @Entry public static boolean waitCold = false;
    @Entry public static boolean othersideCold = false;
    @Entry public static boolean fiveCold = false;
    @Entry public static boolean pigstepCold = false;

    // Hot Music Selector
    @Comment public static Comment hotMusicTitle;

    // Creative
    @Entry public static boolean creative1Hot = false;
    @Entry public static boolean creative2Hot = false;
    @Entry public static boolean creative3Hot = true;
    @Entry public static boolean creative4Hot = true;
    @Entry public static boolean creative5Hot = false;
    @Entry public static boolean creative6Hot = false;

    // Survival
    @Entry public static boolean calm1Hot = false;
    @Entry public static boolean calm2Hot = false;
    @Entry public static boolean calm3Hot = false;
    @Entry public static boolean hal1Hot = false;
    @Entry public static boolean hal2Hot = false;
    @Entry public static boolean hal3Hot = true;
    @Entry public static boolean hal4Hot = false;
    @Entry public static boolean nuance1Hot = false;
    @Entry public static boolean nuance2Hot = false;
    @Entry public static boolean piano1Hot = false;
    @Entry public static boolean piano2Hot = false;
    @Entry public static boolean piano3Hot = false;
    @Entry public static boolean aerieHot = true;
    @Entry public static boolean ancestryHot = false;
    @Entry public static boolean an_ordinary_dayHot = false;
    @Entry public static boolean comforting_memoriesHot = false;
    @Entry public static boolean firebugsHot = true;
    @Entry public static boolean floating_dreamHot = true;
    @Entry public static boolean infinite_amethystHot = false;
    @Entry public static boolean labyrinthineHot = true;
    @Entry public static boolean left_to_bloomHot = false;
    @Entry public static boolean one_more_dayHot = false;
    @Entry public static boolean stand_tallHot = false;
    @Entry public static boolean wendingHot = false;

    // Records
    @Entry public static boolean thirteenHot = false;
    @Entry public static boolean catHot = false;
    @Entry public static boolean blocksHot = false;
    @Entry public static boolean chirpHot = false;
    @Entry public static boolean farHot = false;
    @Entry public static boolean mallHot = false;
    @Entry public static boolean mellohiHot = false;
    @Entry public static boolean stalHot = false;
    @Entry public static boolean stradHot = false;
    @Entry public static boolean wardHot = false;
    @Entry public static boolean elevenHot = false;
    @Entry public static boolean waitHot = false;
    @Entry public static boolean othersideHot = false;
    @Entry public static boolean fiveHot = false;
    @Entry public static boolean pigstepHot = false;

    // Nice Music Selector
    @Comment public static Comment niceMusicTitle;

    // Creative
    @Entry public static boolean creative1Nice = false;
    @Entry public static boolean creative2Nice = true;
    @Entry public static boolean creative3Nice = true;
    @Entry public static boolean creative4Nice = false;
    @Entry public static boolean creative5Nice = false;
    @Entry public static boolean creative6Nice = false;

    // Survival
    @Entry public static boolean calm1Nice = true;
    @Entry public static boolean calm2Nice = false;
    @Entry public static boolean calm3Nice = true;
    @Entry public static boolean hal1Nice = false;
    @Entry public static boolean hal2Nice = true;
    @Entry public static boolean hal3Nice = true;
    @Entry public static boolean hal4Nice = false;
    @Entry public static boolean nuance1Nice = false;
    @Entry public static boolean nuance2Nice = false;
    @Entry public static boolean piano1Nice = false;
    @Entry public static boolean piano2Nice = true;
    @Entry public static boolean piano3Nice = false;
    @Entry public static boolean aerieNice = false;
    @Entry public static boolean ancestryNice = false;
    @Entry public static boolean an_ordinary_dayNice = true;
    @Entry public static boolean comforting_memoriesNice = false;
    @Entry public static boolean firebugsNice = false;
    @Entry public static boolean floating_dreamNice = false;
    @Entry public static boolean infinite_amethystNice = false;
    @Entry public static boolean labyrinthineNice = true;
    @Entry public static boolean left_to_bloomNice = false;
    @Entry public static boolean one_more_dayNice = false;
    @Entry public static boolean stand_tallNice = true;
    @Entry public static boolean wendingNice = false;

    // Records
    @Entry public static boolean thirteenNice = false;
    @Entry public static boolean catNice = false;
    @Entry public static boolean blocksNice = false;
    @Entry public static boolean chirpNice = false;
    @Entry public static boolean farNice = false;
    @Entry public static boolean mallNice = false;
    @Entry public static boolean mellohiNice = false;
    @Entry public static boolean stalNice = false;
    @Entry public static boolean stradNice = false;
    @Entry public static boolean wardNice = false;
    @Entry public static boolean elevenNice = false;
    @Entry public static boolean waitNice = false;
    @Entry public static boolean othersideNice = false;
    @Entry public static boolean fiveNice = false;
    @Entry public static boolean pigstepNice = false;

    // Down Music Selector
    @Comment public static Comment downMusicTitle;

    // Creative
    @Entry public static boolean creative1Down = true;
    @Entry public static boolean creative2Down = false;
    @Entry public static boolean creative3Down = false;
    @Entry public static boolean creative4Down = false;
    @Entry public static boolean creative5Down = true;
    @Entry public static boolean creative6Down = true;

    // Survival
    @Entry public static boolean calm1Down = false;
    @Entry public static boolean calm2Down = true;
    @Entry public static boolean calm3Down = false;
    @Entry public static boolean hal1Down = true;
    @Entry public static boolean hal2Down = false;
    @Entry public static boolean hal3Down = false;
    @Entry public static boolean hal4Down = true;
    @Entry public static boolean nuance1Down = true;
    @Entry public static boolean nuance2Down = false;
    @Entry public static boolean piano1Down = true;
    @Entry public static boolean piano2Down = false;
    @Entry public static boolean piano3Down = true;
    @Entry public static boolean aerieDown = false;
    @Entry public static boolean ancestryDown = false;
    @Entry public static boolean an_ordinary_dayDown = false;
    @Entry public static boolean comforting_memoriesDown = true;
    @Entry public static boolean firebugsDown = true;
    @Entry public static boolean floating_dreamDown = false;
    @Entry public static boolean infinite_amethystDown = false;
    @Entry public static boolean labyrinthineDown = false;
    @Entry public static boolean left_to_bloomDown = true;
    @Entry public static boolean one_more_dayDown = false;
    @Entry public static boolean stand_tallDown = false;
    @Entry public static boolean wendingDown = false;

    // Records
    @Entry public static boolean thirteenDown = false;
    @Entry public static boolean catDown = false;
    @Entry public static boolean blocksDown = false;
    @Entry public static boolean chirpDown = false;
    @Entry public static boolean farDown = false;
    @Entry public static boolean mallDown = false;
    @Entry public static boolean mellohiDown = false;
    @Entry public static boolean stalDown = false;
    @Entry public static boolean stradDown = false;
    @Entry public static boolean wardDown = false;
    @Entry public static boolean elevenDown = false;
    @Entry public static boolean waitDown = false;
    @Entry public static boolean othersideDown = false;
    @Entry public static boolean fiveDown = false;
    @Entry public static boolean pigstepDown = false;
}
package net.celeri.dynmus.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.util.DynamicMusicHelper.MusicToggle;

@Config(name = DynamicMusic.MOD_ID)
@Config.Gui.Background(value = "minecraft:textures/block/stone.png")
public class DynamicMusicConfig implements ConfigData {
    @ConfigEntry.Category("generalConfig")
    @ConfigEntry.Gui.TransitiveObject
    public GeneralConfig generalConfig = new GeneralConfig();

    @ConfigEntry.Category("musicSelector")
    @ConfigEntry.Gui.TransitiveObject
    public MusicSelector musicSelector = new MusicSelector();

    public static class GeneralConfig {
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
            public boolean endCreativeMusic = true;

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
            public int searchRange = 5;

            @ConfigEntry.Gui.Tooltip()
            @ConfigEntry.BoundedDiscrete(max = 15)
            public int darknessCap = 8;

            @ConfigEntry.Gui.Tooltip()
            public double darknessPercent = 0.3;

            @ConfigEntry.Gui.Tooltip()
            public double stonePercent = 0.15;
        }

        public static class MineshaftDetection {
            @ConfigEntry.Gui.Tooltip()
            public int searchRange = 2;

            @ConfigEntry.Gui.Tooltip()
            public double percent = 0.1;
        }
    }

    public static class MusicSelector {
        @ConfigEntry.Gui.CollapsibleObject
        public MusicToggles caveMusic = new MusicToggles(
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.Creative, MusicToggle.None, MusicToggle.None,
                MusicToggle.Creative, MusicToggle.None, MusicToggle.Creative,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.Both, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.Both,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None
        );

        @ConfigEntry.Gui.CollapsibleObject
        public MusicToggles coldMusic = new MusicToggles(
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Creative, MusicToggle.None,
                MusicToggle.None, MusicToggle.Creative, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None
        );

        @ConfigEntry.Gui.CollapsibleObject
        public MusicToggles hotMusic = new MusicToggles(
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Creative,
                MusicToggle.Creative, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.Both,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None
        );

        @ConfigEntry.Gui.CollapsibleObject
        public MusicToggles niceMusic = new MusicToggles(
                MusicToggle.Both, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.Creative, MusicToggle.Creative,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None
        );

        @ConfigEntry.Gui.CollapsibleObject
        public MusicToggles downMusic = new MusicToggles(
                MusicToggle.None, MusicToggle.Both, MusicToggle.None,
                MusicToggle.Creative, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.Creative, MusicToggle.Creative,
                MusicToggle.Both, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.Both, MusicToggle.None,
                MusicToggle.Both, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.Both, MusicToggle.Both, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.Both,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None,
                MusicToggle.None, MusicToggle.None, MusicToggle.None
        );

        public static class MusicToggles {
            // Musics
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle calm1;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle calm2;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle calm3;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative1;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative2;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative3;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative4;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative5;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle creative6;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle hal1;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle hal2;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle hal3;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle hal4;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle nuance1;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle nuance2;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle piano1;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle piano2;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle piano3;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle aerie;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle ancestry;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle an_ordinary_day;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle comforting_memories;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle firebugs;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle floating_dream;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle infinite_amethyst;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle labyrinthine;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle left_to_bloom;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle one_more_day;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle stand_tall;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle wending;

            // Records
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle thirteen;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle cat;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle blocks;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle chirp;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle far;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle mall;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle mellohi;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle stal;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle strad;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle ward;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle eleven;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle wait;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle otherside;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle five;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public MusicToggle pigstep;

            public MusicToggles(
                    MusicToggle calm1, MusicToggle calm2, MusicToggle calm3,
                    MusicToggle creative1, MusicToggle creative2, MusicToggle creative3, MusicToggle creative4, MusicToggle creative5, MusicToggle creative6,
                    MusicToggle hal1, MusicToggle hal2, MusicToggle hal3, MusicToggle hal4,
                    MusicToggle nuance1, MusicToggle nuance2,
                    MusicToggle piano1, MusicToggle piano2, MusicToggle piano3,
                    MusicToggle aerie, MusicToggle ancestry, MusicToggle an_ordinary_day,
                    MusicToggle comforting_memories, MusicToggle firebugs, MusicToggle floating_dream,
                    MusicToggle infinite_amethyst, MusicToggle labyrinthine, MusicToggle left_to_bloom,
                    MusicToggle one_more_day, MusicToggle stand_tall, MusicToggle wending,
                    MusicToggle thirteen, MusicToggle cat, MusicToggle blocks, MusicToggle chirp, MusicToggle far, MusicToggle mall,
                    MusicToggle mellohi, MusicToggle stal, MusicToggle strad, MusicToggle ward, MusicToggle eleven, MusicToggle wait,
                    MusicToggle otherside, MusicToggle five, MusicToggle pigstep
            ) {
                this.calm1 = calm1; this.calm2 = calm2; this.calm3 = calm3;
                this.creative1 = creative1; this.creative2 = creative2; this.creative3 = creative3;
                this.creative4 = creative4; this.creative5 = creative5; this.creative6 = creative6;
                this.hal1 = hal1; this.hal2 = hal2; this.hal3 = hal3; this.hal4 = hal4;
                this.nuance1 = nuance1; this.nuance2 = nuance2;
                this.piano1 = piano1; this.piano2 = piano2; this.piano3 = piano3;
                this.aerie = aerie; this.ancestry = ancestry; this.an_ordinary_day = an_ordinary_day;
                this.comforting_memories = comforting_memories; this.firebugs = firebugs;
                this.floating_dream = floating_dream; this.infinite_amethyst = infinite_amethyst;
                this.labyrinthine = labyrinthine; this.left_to_bloom = left_to_bloom;
                this.one_more_day = one_more_day; this.stand_tall = stand_tall; this.wending = wending;
                this.thirteen = thirteen; this.cat = cat; this.blocks = blocks; this.chirp = chirp;
                this.far = far; this.mall = mall; this.mellohi = mellohi; this.stal = stal;
                this.strad = strad; this.ward = ward; this.eleven = eleven; this.wait = wait;
                this.otherside = otherside; this.five = five; this.pigstep = pigstep;
            }
        }
    }
}
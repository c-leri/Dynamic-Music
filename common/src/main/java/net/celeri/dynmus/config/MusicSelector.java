package net.celeri.dynmus.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "musicSelector")
public class MusicSelector implements ConfigData {
    public enum MusicToggle {
        Survival, Creative, Both, None;

        @Override
        public String toString() {
            return switch (this) {
                case Survival -> "§eSurvival";
                case Creative -> "§bCreative";
                case Both -> "§aBoth";
                case None -> "§cNone";
            };
        }
    }

    @ConfigEntry.Gui.Tooltip()
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
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None
    );

    @ConfigEntry.Gui.Tooltip()
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
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None
    );

    @ConfigEntry.Gui.Tooltip()
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
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None
    );

    @ConfigEntry.Gui.Tooltip()
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
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None
    );

    @ConfigEntry.Gui.Tooltip()
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
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None
    );

    @ConfigEntry.Gui.Tooltip()
    @ConfigEntry.Gui.CollapsibleObject
    public MusicToggles endMusic = new MusicToggles(
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.None, MusicToggle.None, MusicToggle.None,
        MusicToggle.Both, MusicToggle.Creative, MusicToggle.Creative,
        MusicToggle.Creative, MusicToggle.Creative
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

        // End musics
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public MusicToggle end;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public MusicToggle end_creative1;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public MusicToggle end_creative2;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public MusicToggle end_creative3;
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public MusicToggle end_creative4;

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
            MusicToggle otherside, MusicToggle five, MusicToggle pigstep,
            MusicToggle end, MusicToggle end_creative1, MusicToggle end_creative2, MusicToggle end_creative3, MusicToggle end_creative4
        ) {
            this.calm1 = calm1;
            this.calm2 = calm2;
            this.calm3 = calm3;
            this.creative1 = creative1;
            this.creative2 = creative2;
            this.creative3 = creative3;
            this.creative4 = creative4;
            this.creative5 = creative5;
            this.creative6 = creative6;
            this.hal1 = hal1;
            this.hal2 = hal2;
            this.hal3 = hal3;
            this.hal4 = hal4;
            this.nuance1 = nuance1;
            this.nuance2 = nuance2;
            this.piano1 = piano1;
            this.piano2 = piano2;
            this.piano3 = piano3;
            this.aerie = aerie;
            this.ancestry = ancestry;
            this.an_ordinary_day = an_ordinary_day;
            this.comforting_memories = comforting_memories;
            this.firebugs = firebugs;
            this.floating_dream = floating_dream;
            this.infinite_amethyst = infinite_amethyst;
            this.labyrinthine = labyrinthine;
            this.left_to_bloom = left_to_bloom;
            this.one_more_day = one_more_day;
            this.stand_tall = stand_tall;
            this.wending = wending;
            this.thirteen = thirteen;
            this.cat = cat;
            this.blocks = blocks;
            this.chirp = chirp;
            this.far = far;
            this.mall = mall;
            this.mellohi = mellohi;
            this.stal = stal;
            this.strad = strad;
            this.ward = ward;
            this.eleven = eleven;
            this.wait = wait;
            this.otherside = otherside;
            this.five = five;
            this.pigstep = pigstep;
            this.end = end;
            this.end_creative1 = end_creative1;
            this.end_creative2 = end_creative2;
            this.end_creative3 = end_creative3;
            this.end_creative4 = end_creative4;
        }
    }
}

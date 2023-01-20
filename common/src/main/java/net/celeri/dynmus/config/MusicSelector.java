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

    @ConfigEntry.Gui.CollapsibleObject
    public MusicToggles caveMusic = new MusicToggles(
            MusicToggle.None, MusicToggle.None, MusicToggle.None,
            MusicToggle.Creative, MusicToggle.None, MusicToggle.None,
            MusicToggle.Creative, MusicToggle.None, MusicToggle.Creative,
            MusicToggle.Both, MusicToggle.None, MusicToggle.None,
            MusicToggle.Both, MusicToggle.None, MusicToggle.None,
            MusicToggle.Both, MusicToggle.None, MusicToggle.None,
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
                MusicToggle thirteen, MusicToggle cat, MusicToggle blocks, MusicToggle chirp, MusicToggle far, MusicToggle mall,
                MusicToggle mellohi, MusicToggle stal, MusicToggle strad, MusicToggle ward, MusicToggle eleven, MusicToggle wait,
                MusicToggle otherside, MusicToggle five, MusicToggle pigstep
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
        }
    }
}

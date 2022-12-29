package net.celeri.dynmus.config;

abstract public class DynamicMusicConfig {
    abstract public int searchRange();

    abstract public int darknessCap();

    abstract public double darknessPercent();

    abstract public double stonePercent();

    abstract public int pseudoMineshaftSearchRange();

    abstract public double pseudoMineshaftPercent();

    abstract public boolean caveMusic();

    abstract public boolean coldMusic();

    abstract public boolean hotMusic();

    abstract public boolean niceMusic();

    abstract public boolean downMusic();

    abstract public boolean endCreativeMusic();

    abstract public boolean endBossMusic();

    abstract public boolean dynamicPitch();

    abstract public long dynamicPitchAnchor();

    abstract public boolean dynamicPitchFaster();
}

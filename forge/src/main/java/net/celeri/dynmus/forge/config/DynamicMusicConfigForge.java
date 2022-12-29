package net.celeri.dynmus.forge.config;

import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;

@Config(id = DynamicMusic.MOD_ID)
public class DynamicMusicConfigForge extends DynamicMusicConfig {
    @Configurable
    @Configurable.Comment({"Number of blocks in each direction.", "0 disables cave detection.", "Used for 'Cave Music' and 'Dynamic Pitch'"})
    @Configurable.Range(min = 0)
    public int searchRange = 5;

    @Configurable
    @Configurable.Comment("Light level of blocks used for cave detection.")
    @Configurable.Range(min = 0, max = 15)
    public int darknessCap = 8;

    @Configurable
    @Configurable.Comment("Percent of blocks with low light levels to trigger cave detection.")
    @Configurable.DecimalRange(min = 0, max = 1)
    public double darknessPercent = 0.3;

    @Configurable
    @Configurable.Comment("Percent of stone to trigger cave detection.")
    @Configurable.DecimalRange(min = 0, max = 1)
    public double stonePercent = 0.15;

    @Configurable
    @Configurable.Comment({"Number of blocks in each direction.", "0 disables mineshaft detection.", "Used to activate 'Dynamic Pitch' in mineshafts."})
    @Configurable.Range(min = 0)
    public int pseudoMineshaftSearchRange = 2;

    @Configurable
    @Configurable.Comment("Percent of mineshaft blocks for mineshaft detection.")
    @Configurable.DecimalRange(min = 0, max = 1)
    public double pseudoMineshaftPercent = 0.1;

    @Configurable
    @Configurable.Comment("Play cave music in caves.")
    public boolean caveMusic = true;

    @Configurable
    @Configurable.Comment("Play cold music in cold biomes.")
    public boolean coldMusic = true;

    @Configurable
    @Configurable.Comment("Play hot music in hot biomes.")
    public boolean hotMusic = true;

    @Configurable
    @Configurable.Comment("Play nice music during the day.")
    public boolean niceMusic = true;

    @Configurable
    @Configurable.Comment("Play down/sad music during the night and while it rains.")
    public boolean downMusic = true;

    @Configurable
    @Configurable.Comment("Play original music composed by LudoCrypt when in creative mode in the End dimension.")
    public boolean endCreativeMusic = true;

    @Configurable
    @Configurable.Comment("Play original music composed by LudoCrypt when fighting the dragon in the End dimension.")
    public boolean endBossMusic = true;

    @Configurable
    @Configurable.Comment("The closer the time is to the Anchor, the slower the music plays.")
    public boolean dynamicPitch = true;

    @Configurable
    @Configurable.Comment("The anchor that the Dynamic Pitch uses. 18000 being midnight.")
    @Configurable.Range(min = 0)
    public long dynamicPitchAnchor = 18000;

    @Configurable
    @Configurable.Comment("Choose to play music faster, rather than slower.")
    public boolean dynamicPitchFaster = false;

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

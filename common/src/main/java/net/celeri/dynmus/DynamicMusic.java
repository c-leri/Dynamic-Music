package net.celeri.dynmus;

import dev.architectury.registry.registries.DeferredRegister;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.celeri.dynmus.util.DynamicMusicHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

public class DynamicMusic {
    public static final String MOD_ID = "dynmus";

    public static DynamicMusicConfig config;

    public static final SoundEvent MUSIC_END_CREATIVE = new SoundEvent(new ResourceLocation(MOD_ID, "music.end.creative"));
    public static final SoundEvent MUSIC_END_BOSS = new SoundEvent(new ResourceLocation(MOD_ID, "music.end.boss"));

    public static void init() {
        AutoConfig.register(DynamicMusicConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(DynamicMusicConfig.class).getConfig();

        DeferredRegister<SoundEvent> SOUND_EVENTS_REGISTER = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_REGISTRY);

        for (SoundEvent sound : DynamicMusicHelper.getMusics().values()) {
            SOUND_EVENTS_REGISTER.register(sound.getLocation().getPath(), () -> sound);
        }

        SOUND_EVENTS_REGISTER.register(MUSIC_END_CREATIVE.getLocation().getPath(), () -> MUSIC_END_CREATIVE);
        SOUND_EVENTS_REGISTER.register(MUSIC_END_BOSS.getLocation().getPath(), () -> MUSIC_END_BOSS);

        SOUND_EVENTS_REGISTER.register();
    }

    public static boolean isInCave(Level level, BlockPos pos) {
        int searchRange = config.generalConfig.caveDetection.searchRange;

        if (searchRange >= 1 && !level.canSeeSky(pos) && config.generalConfig.caveDetection.darknessPercent < 1 || config.generalConfig.caveDetection.stonePercent < 1) {
            int darkBlocks = 0;
            int stoneBlocks = 0;
            int airBlocks = 0;

            for (int x = -searchRange; x < searchRange; x++) {
                for (int y = -searchRange; y < searchRange; y++) {
                    for (int z = -searchRange; z < searchRange; z++) {
                        BlockPos offsetPos = pos.offset(x, y, z);
                        if (level.isEmptyBlock(offsetPos)) {
                            airBlocks++;
                            if (level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(offsetPos)
                                    <= config.generalConfig.caveDetection.darknessCap) {
                                darkBlocks++;
                            }
                        }
                        if (level.getBlockState(offsetPos).getMaterial() == Material.LAVA) {
                            darkBlocks++;
                        }
                        if (level.getBlockState(offsetPos).getMaterial() == Material.STONE) {
                            stoneBlocks++;
                        }
                    }
                }
            }

            double blockCount = Math.pow(searchRange * 2, 3);

            double stonePercentage = ((double) stoneBlocks) / (blockCount);
            double darkPercentage = ((double) darkBlocks) / ((double) airBlocks);

            return darkPercentage >= config.generalConfig.caveDetection.darknessPercent && stonePercentage >= config.generalConfig.caveDetection.stonePercent;
        }
        return false;
    }

    public static double getAverageDarkness(Level level, BlockPos pos) {
        int searchRange = config.generalConfig.caveDetection.searchRange;

        if (searchRange >= 1) {
            int airBlocks = 0;
            int lightTogether = 0;

            for (int x = -searchRange; x < searchRange; x++) {
                for (int y = -searchRange; y < searchRange; y++) {
                    for (int z = -searchRange; z < searchRange; z++) {
                        BlockPos offsetPos = pos.offset(x, y, z);
                        if (level.isEmptyBlock(offsetPos)) {
                            airBlocks++;
                            lightTogether += level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(offsetPos);
                        }
                    }
                }
            }

            return (((double) lightTogether) / ((double) airBlocks));

        }
        return 15;
    }

    public static boolean isInPseudoMinecraft(Level level, BlockPos pos) {
        int searchRange = config.generalConfig.mineshaftDetection.searchRange;

        if (searchRange >= 1 && config.generalConfig.mineshaftDetection.percent < 1) {

            int pseudoMineshaftBlocks = 0;
            int airBlocks = 0;

            for (int x = -searchRange; x < searchRange; x++) {
                for (int y = -searchRange; y < searchRange; y++) {
                    for (int z = -searchRange; z < searchRange; z++) {
                        BlockPos offsetPos = pos.offset(x, y, z);

                        if (level.getBlockState(offsetPos).getMaterial() == Material.WOOD || level.getBlockState(offsetPos).getBlock() == Blocks.RAIL || level.getBlockState(offsetPos).getMaterial() == Material.WEB) {
                            pseudoMineshaftBlocks++;
                        }

                        if (level.isEmptyBlock(offsetPos)) {
                            airBlocks++;
                        }

                    }
                }
            }

            double mineshaftPercentage = ((double) pseudoMineshaftBlocks) / ((double) airBlocks);

            return mineshaftPercentage >= config.generalConfig.mineshaftDetection.percent;
        }

        return false;
    }
}

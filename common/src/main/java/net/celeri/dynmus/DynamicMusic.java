package net.celeri.dynmus;

import dev.architectury.registry.registries.DeferredRegister;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.celeri.dynmus.util.DynamicMusicHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

public class DynamicMusic {
    public static final String MOD_ID = "dynmus";

    public static final SoundEvent MUSIC_END_CREATIVE = SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "music.end.creative"));
    public static final SoundEvent MUSIC_END_BOSS = SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "music.end.boss"));

    public static void init() {
        DeferredRegister<SoundEvent> SOUND_EVENTS_REGISTER = DeferredRegister.create(MOD_ID, Registries.SOUND_EVENT);

        for (SoundEvent sound : DynamicMusicHelper.getCreativeMusic().values()) {
            SOUND_EVENTS_REGISTER.register(sound.getLocation().getPath(), () -> sound);
        }
        for (SoundEvent sound : DynamicMusicHelper.getSurvivalMusic().values()) {
            SOUND_EVENTS_REGISTER.register(sound.getLocation().getPath(), () -> sound);
        }

        SOUND_EVENTS_REGISTER.register(MUSIC_END_CREATIVE.getLocation().getPath(), () -> MUSIC_END_CREATIVE);
        SOUND_EVENTS_REGISTER.register(MUSIC_END_BOSS.getLocation().getPath(), () -> MUSIC_END_BOSS);

        SOUND_EVENTS_REGISTER.register();
    }

    public static boolean isInCave(Level level, BlockPos pos) {
        int searchRange = DynamicMusicConfig.searchRange;

        if (searchRange >= 1 && !level.canSeeSky(pos)) {
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
                                    <= DynamicMusicConfig.darknessCap) {
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

            if (darkPercentage >= DynamicMusicConfig.darknessPercent) {
                return stonePercentage >= DynamicMusicConfig.stonePercent;
            }
        }
        return false;
    }

    public static double getAverageDarkness(Level level, BlockPos pos) {
        int searchRange = DynamicMusicConfig.searchRange;

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
        int searchRange = DynamicMusicConfig.pseudoMineshaftSearchRange;

        if (searchRange >= 1) {

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

            return mineshaftPercentage >= DynamicMusicConfig.pseudoMineshaftPercent;

        }

        return false;
    }
}

package net.celeri.dynmus;

import dev.architectury.registry.registries.DeferredRegister;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicMusic {
    public static final String MOD_ID = "dynmus";
    public static DynamicMusicConfig config;

    private static final Map<ResourceLocation, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

    public static final SoundEvent MUSIC_COLD = add("music.cold");
    public static final SoundEvent MUSIC_HOT = add("music.hot");
    public static final SoundEvent MUSIC_CAVE = add("music.cave");

    public static final SoundEvent MUSIC_NICE = add("music.nice");
    public static final SoundEvent MUSIC_DOWN = add("music.down");

    public static final SoundEvent MUSIC_COLD_CREATIVE = add("music.cold.creative");
    public static final SoundEvent MUSIC_HOT_CREATIVE = add("music.hot.creative");
    public static final SoundEvent MUSIC_CAVE_CREATIVE = add("music.cave.creative");

    public static final SoundEvent MUSIC_NICE_CREATIVE = add("music.nice.creative");
    public static final SoundEvent MUSIC_DOWN_CREATIVE = add("music.down.creative");

    public static final SoundEvent MUSIC_END_CREATIVE = add("music.end.creative");
    public static final SoundEvent MUSIC_END_BOSS = add("music.end.boss");

    private static SoundEvent add(String path) {
        ResourceLocation location = new ResourceLocation("dynmus", path);
        SoundEvent sound = SoundEvent.createVariableRangeEvent(location);
        SOUND_EVENTS.put(location, sound);
        return sound;
    }

    public static void init(DynamicMusicConfig config) {
        DynamicMusic.config = config;

        DeferredRegister<SoundEvent> SOUND_EVENTS_REGISTER = DeferredRegister.create(MOD_ID, Registries.SOUND_EVENT);
        for (ResourceLocation location : DynamicMusic.SOUND_EVENTS.keySet()) {
            SOUND_EVENTS_REGISTER.register(location.getPath(), () -> SOUND_EVENTS.get(location));
        }
        SOUND_EVENTS_REGISTER.register();
    }

    public static boolean isInCave(Level level, BlockPos pos, DynamicMusicConfig config) {
        int searchRange = config.searchRange();

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
                                    <= config.darknessCap()) {
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

            if (darkPercentage >= config.darknessPercent()) {
                return stonePercentage >= config.stonePercent();
            }
        }
        return false;
    }

    public static double getAverageDarkness(Level level, BlockPos pos, DynamicMusicConfig config) {
        int searchRange = config.searchRange();

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

    public static boolean isInPseudoMinecraft(Level level, BlockPos pos, DynamicMusicConfig config) {
        int searchRange = config.pseudoMineshaftSearchRange();

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

            return mineshaftPercentage >= config.pseudoMineshaftPercent();

        }

        return false;
    }
}

package net.celeri.dynmus;

import dev.architectury.registry.registries.DeferredRegister;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.celeri.dynmus.util.DynamicMusicHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.lighting.LayerLightEventListener;
import net.minecraft.world.level.material.Material;

import java.util.stream.IntStream;

public class DynamicMusic {
    public static final String MOD_ID = "dynmus";

    public static final SoundEvent MUSIC_END_BOSS = SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "music.end.boss"));

    public static void init() {
        AutoConfig.register(DynamicMusicConfig.class, PartitioningSerializer.wrap(GsonConfigSerializer::new));

        DeferredRegister<SoundEvent> SOUND_EVENTS_REGISTER = DeferredRegister.create(MOD_ID, Registries.SOUND_EVENT);

        for (SoundEvent sound : DynamicMusicHelper.getMusics().values()) {
            SOUND_EVENTS_REGISTER.register(sound.getLocation().getPath(), () -> sound);
        }

        SOUND_EVENTS_REGISTER.register(MUSIC_END_BOSS.getLocation().getPath(), () -> MUSIC_END_BOSS);

        SOUND_EVENTS_REGISTER.register();
    }

    private static boolean inCave = false;

    private static boolean inPseudoMinecraft = false;

    private static double averageDarkness = 15;

    public static void tick(Level level, BlockPos pos) {
        DynamicMusicConfig config = AutoConfig.getConfigHolder(DynamicMusicConfig.class).getConfig();
        LayerLightEventListener blockLightListener = level.getLightEngine().getLayerListener(LightLayer.BLOCK);

        int caveSearchRange = config.generalConfig.caveDetection.searchRange;
        int mineshaftSearchRange = config.generalConfig.mineshaftDetection.searchRange;

        int searchRange = Math.max(caveSearchRange, mineshaftSearchRange);

        if (searchRange >= 1) {
            int airBlocks = 0;
            int lightSum = 0;

            int caveAllSolidBlocks = 0;
            int caveBlocks = 0;

            int mineshaftAllSolidBlock = 0;
            int mineshaftBlocks = 0;

            for (int x = -searchRange; x < searchRange; x++) {
                for (int y = -searchRange; y < searchRange; y++) {
                    for (int z = -searchRange; z < searchRange; z++) {
                        BlockPos offsetPos = new BlockPos(pos).offset(x, y, z);

                        Material blockMaterial = level.getBlockState(offsetPos).getMaterial();

                        if (blockMaterial == Material.AIR) {
                            airBlocks++;

                            lightSum += blockLightListener.getLightValue(offsetPos);
                        } else if (blockMaterial != Material.LAVA && blockMaterial != Material.WATER) {
                            int biggestCoordinate = IntStream.of(x, y, z).max().getAsInt();
                            int smallestCoordinate = IntStream.of(x, y, z).min().getAsInt();

                            // Coordinates within cave search range
                            if (smallestCoordinate > -caveSearchRange && biggestCoordinate < caveSearchRange) {
                                caveAllSolidBlocks++;

                                if (
                                    blockMaterial == Material.STONE
                                        || blockMaterial == Material.SCULK
                                        || blockMaterial == Material.AMETHYST
                                ) caveBlocks++;
                            }

                            // Coordinates within mineshaft search range
                            if (smallestCoordinate > -mineshaftSearchRange && biggestCoordinate < mineshaftSearchRange) {
                                mineshaftAllSolidBlock++;

                                if (
                                    blockMaterial == Material.WOOD || blockMaterial == Material.WEB
                                        || level.getBlockState(offsetPos).getBlock() == Blocks.RAIL
                                ) mineshaftBlocks++;
                            }
                        }

                    }
                }
            }

            inCave = !level.canSeeSky(pos) && config.generalConfig.caveDetection.stonePercent <= (double) caveBlocks / caveAllSolidBlocks;
            inPseudoMinecraft = inCave && config.generalConfig.mineshaftDetection.percent <= (double) mineshaftBlocks / mineshaftAllSolidBlock;
            averageDarkness = (double) lightSum / airBlocks;
        }
    }

    public static boolean isInCave() {
        return inCave;
    }

    public static boolean isInPseudoMinecraft() {
        return inPseudoMinecraft;
    }

    public static double getAverageDarkness() {
        return averageDarkness;
    }
}

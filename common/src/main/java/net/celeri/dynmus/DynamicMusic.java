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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.lighting.LayerLightEventListener;

import java.util.List;
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

                        Block block = level.getBlockState(offsetPos).getBlock();

                        if (block == Blocks.AIR) {
                            airBlocks++;

                            lightSum += blockLightListener.getLightValue(offsetPos);
                        } else if (block != Blocks.LAVA && block != Blocks.WATER) {
                            int biggestCoordinate = IntStream.of(x, y, z).max().getAsInt();
                            int smallestCoordinate = IntStream.of(x, y, z).min().getAsInt();

                            // Coordinates within cave search range
                            if (smallestCoordinate > -caveSearchRange && biggestCoordinate < caveSearchRange) {
                                caveAllSolidBlocks++;

                                if (isCaveBlock(block)) caveBlocks++;
                            }

                            // Coordinates within mineshaft search range
                            if (smallestCoordinate > -mineshaftSearchRange && biggestCoordinate < mineshaftSearchRange) {
                                mineshaftAllSolidBlock++;

                                if (isMineshaftBlock(block)) mineshaftBlocks++;
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

    private static final List<Block> caveBlocks = List.of(
        Blocks.ANDESITE, Blocks.GRANITE, Blocks.DIORITE, Blocks.COBBLESTONE, Blocks.INFESTED_COBBLESTONE, Blocks.MOSSY_COBBLESTONE,
        Blocks.TUFF, Blocks.CALCITE, Blocks.DRIPSTONE_BLOCK, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.DEEPSLATE,
        Blocks.INFESTED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, Blocks.STONE, Blocks.INFESTED_STONE, Blocks.STONE_BRICKS,
        Blocks.INFESTED_STONE_BRICKS, Blocks.BEDROCK, Blocks.OBSIDIAN, Blocks.SCULK, Blocks.SCULK_VEIN,
        Blocks.AMETHYST_BLOCK, Blocks.AMETHYST_CLUSTER, Blocks.COAL_ORE, Blocks.COPPER_ORE, Blocks.IRON_ORE,
        Blocks.GOLD_ORE, Blocks.EMERALD_ORE, Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE, Blocks.DIAMOND_ORE,
        Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE,
        Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE_DIAMOND_ORE,
        Blocks.BASALT, Blocks.POLISHED_BASALT, Blocks.BLACKSTONE, Blocks.MAGMA_BLOCK, Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT,
        Blocks.CLAY, Blocks.MOSS_BLOCK, Blocks.AZALEA, Blocks.FLOWERING_AZALEA
    );

    private static boolean isCaveBlock(Block block) {
        return caveBlocks.stream().anyMatch(caveBlock -> block == caveBlock);
    }

    private static final List<Block> mineshaftBlocks = List.of(
        Blocks.OAK_PLANKS, Blocks.OAK_FENCE, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_FENCE,
        Blocks.ACACIA_PLANKS, Blocks.ACACIA_FENCE, Blocks.BIRCH_PLANKS, Blocks.BIRCH_FENCE,
        Blocks.CHERRY_PLANKS, Blocks.CHERRY_FENCE, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_FENCE,
        Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_FENCE, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_FENCE,
        Blocks.RAIL
    );

    private static boolean isMineshaftBlock(Block block) {
        return mineshaftBlocks.stream().anyMatch(mineshaftBlock -> block == mineshaftBlock);
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

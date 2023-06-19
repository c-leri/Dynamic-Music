package net.celeri.dynmus.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.celeri.dynmus.util.DynamicMusicHelper;
import net.celeri.dynmus.util.DynamicMusicHelper.MusicType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(Minecraft.class)
public class MinecraftClientMixin {
    @Shadow
    public LocalPlayer player;

    @Shadow
    public ClientLevel level;
    private static int tickCounter = 0;

    @Inject(method = "tick", at = @At("RETURN"))
    private void dynmus$tick(CallbackInfo ci) {
        tickCounter++;

        // Execute cave detection algorithm every second
        if (tickCounter >= 20 && level != null && player != null) {
            tickCounter = 0;

            DynamicMusic.tick(level, player.blockPosition());
        }
    }

    @Inject(method = "getSituationalMusic", at = @At("RETURN"), cancellable = true)
    private void dynmus$getSituationalMusic(CallbackInfoReturnable<Music> ci) {
        DynamicMusicConfig config = AutoConfig.getConfigHolder(DynamicMusicConfig.class).getConfig();

        if (
            // In the Overworld
            this.level != null && this.level.dimension() == Level.OVERWORLD
        ) {
            List<SoundEvent> toggledCaveMusic;
            List<SoundEvent> toggledDownMusic;
            List<SoundEvent> toggledColdMusic;
            List<SoundEvent> toggledHotMusic;
            List<SoundEvent> toggledNiceMusic;

            long dayTime = level.dayTime();
            boolean isRaining = level.isRaining();
            float biomeTemp = level.getBiome(this.player.blockPosition()).value().getBaseTemperature();

            if (
                // Creative mode
                ci.getReturnValue() == Musics.CREATIVE
            ) {
                if (
                    // In cave
                    DynamicMusic.isInCave()
                        // Cave music enabled
                        && config.generalConfig.musicTypesToggles.caveMusic
                        // At least one music enabled
                        && !(toggledCaveMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Cave)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledCaveMusic)
                    );
                } else if (
                    // Nighttime or raining
                    ((dayTime >= 12000 && dayTime < 23000) || isRaining)
                        // Down music enabled
                        && config.generalConfig.musicTypesToggles.downMusic
                        // At least one music enabled
                        && !(toggledDownMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Down)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledDownMusic)
                    );
                } else if (
                    // Cold biome
                    biomeTemp < 0.15F
                        // Cold music enabled
                        && config.generalConfig.musicTypesToggles.coldMusic
                        // At least one music enabled
                        && !(toggledColdMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Cold)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledColdMusic)
                    );
                } else if (
                    // Hot biome
                    biomeTemp > 0.95F
                        // Hot music enabled
                        && config.generalConfig.musicTypesToggles.hotMusic
                        // At least one music enabled
                        && !(toggledHotMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Hot)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledHotMusic)
                    );
                } else if (
                    // Day and not raining
                    (dayTime < 12000 || dayTime >= 23000) && !isRaining
                        // Nice music enabled
                        && config.generalConfig.musicTypesToggles.niceMusic
                        // At least one music enabled
                        && !(toggledNiceMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Nice)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledNiceMusic)
                    );
                }
            } else if (
                // Not underwater
                ci.getReturnValue() != Musics.UNDER_WATER
                    // Not in the menu
                    && this.player != null
            ) {
                if (
                    // In cave
                    DynamicMusic.isInCave()
                        // Cave music enabled
                        && config.generalConfig.musicTypesToggles.caveMusic
                        // At least one music enabled
                        && !(toggledCaveMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cave)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledCaveMusic)
                    );
                } else if (
                    // Nighttime or raining
                    ((dayTime >= 12000 && dayTime < 23000) || isRaining)
                        // Down music enabled
                        && config.generalConfig.musicTypesToggles.downMusic
                        // At least one music enabled
                        && !(toggledDownMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Down)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledDownMusic)
                    );
                } else if (
                    // Cold biome
                    biomeTemp < 0.15F
                        // Cold music enabled
                        && config.generalConfig.musicTypesToggles.coldMusic
                        // At least one music enabled
                        && !(toggledColdMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cold)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledColdMusic)
                    );
                } else if (
                    // Hot biome
                    biomeTemp > 0.95F
                        // Hot music enabled
                        && config.generalConfig.musicTypesToggles.hotMusic
                        // At least one music enabled
                        && !(toggledHotMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Hot)).isEmpty()
                ) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledHotMusic)
                    );
                } else if (
                    (dayTime < 12000 || dayTime >= 23000) && !isRaining
                        && config.generalConfig.musicTypesToggles.niceMusic
                        && !(toggledNiceMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Nice)).isEmpty()) {
                    ci.setReturnValue(
                        DynamicMusicHelper.getRandomMusic(toggledNiceMusic)
                    );
                }
            }
        } else if (
            // Boss music
            ci.getReturnValue() == Musics.END_BOSS
                // Boss music enabled
                && config.generalConfig.musicTypesToggles.endBossMusic
        ) {
            ci.setReturnValue(
                new Music(Holder.direct(DynamicMusic.MUSIC_END_BOSS), 0, 0, true))
            ;
        } else if (
            // In the End
            this.level != null && this.level.dimension() == Level.END
                // End music enabled
                && config.generalConfig.musicTypesToggles.endMusic
        ) {
            List<SoundEvent> toggledEndCreativeMusic;
            List<SoundEvent> toggledEndSurvivalMusic;

            if (
                // Creative mode
                this.player.getAbilities().instabuild && this.player.getAbilities().mayfly
                    // At least one music enabled
                    && !(toggledEndCreativeMusic = DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.End)).isEmpty()
            ) {
                ci.setReturnValue(
                    DynamicMusicHelper.getRandomMusic(toggledEndCreativeMusic)
                );
            } else if (
                // At least one music enabled
                !(toggledEndSurvivalMusic = DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.End)).isEmpty()
            ) {
                ci.setReturnValue(
                    DynamicMusicHelper.getRandomMusic(toggledEndSurvivalMusic)
                );
            }
        }
    }
}

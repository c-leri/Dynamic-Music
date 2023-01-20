package net.celeri.dynmus.mixin;

import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.util.DynamicMusicHelper;
import net.celeri.dynmus.util.DynamicMusicHelper.MusicType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(Minecraft.class)
public class MinecraftClientMixin {
    @Shadow
    public LocalPlayer player;

    @Shadow
    public ClientLevel level;

    @Inject(method = "getSituationalMusic", at = @At("RETURN"), cancellable = true)
    private void dynmus$getSituationalMusic(CallbackInfoReturnable<Music> ci) {
        if (ci.getReturnValue() == Musics.CREATIVE && this.level != null && this.level.dimension() == Level.OVERWORLD) {
            if (DynamicMusic.isInCave(level, player.blockPosition()) && DynamicMusic.config.generalConfig.musicTypesToggles.caveMusic && !DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Cave).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Cave))));
            } else if (((level.getDayTime() >= 12000 && level.getDayTime() < 23000) || level.isRaining()) && DynamicMusic.config.generalConfig.musicTypesToggles.downMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Down).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Down))));
            } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).getBaseTemperature() < 0.15F && DynamicMusic.config.generalConfig.musicTypesToggles.coldMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cold).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Cold))));
            } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).getBaseTemperature() > 0.95F && DynamicMusic.config.generalConfig.musicTypesToggles.hotMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Hot).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Hot))));
            } else if (level.getDayTime() < 12000 && level.getDayTime() >= 23000 && !level.isRaining() && DynamicMusic.config.generalConfig.musicTypesToggles.niceMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Nice).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledCreativeMusicForType(MusicType.Nice))));
            }
        } else if (ci.getReturnValue() != Musics.UNDER_WATER && this.player != null && this.level != null && this.level.dimension() == Level.OVERWORLD) {
            if (DynamicMusic.isInCave(level, player.blockPosition()) && DynamicMusic.config.generalConfig.musicTypesToggles.caveMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cave).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cave))));
            } else if (((level.getDayTime() >= 12000 && level.getDayTime() < 23000) || level.isRaining()) && DynamicMusic.config.generalConfig.musicTypesToggles.downMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Down).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Down))));
            } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).getBaseTemperature() <= 0.05F && DynamicMusic.config.generalConfig.musicTypesToggles.coldMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cold).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Cold))));
            } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).getBaseTemperature() >= 2.0F && DynamicMusic.config.generalConfig.musicTypesToggles.hotMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Hot).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Hot))));
            } else if (level.getDayTime() < 12000 && level.getDayTime() >= 23000 && !level.isRaining() && DynamicMusic.config.generalConfig.musicTypesToggles.niceMusic && !DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Nice).isEmpty()) {
                ci.setReturnValue(Musics.createGameMusic(DynamicMusicHelper.getRandomSoundEvent(DynamicMusicHelper.getToggledSurvivalMusicForType(MusicType.Nice))));
            }
        } else if (ci.getReturnValue() == Musics.END_BOSS && DynamicMusic.config.generalConfig.musicTypesToggles.endBossMusic) {
            ci.setReturnValue(new Music(DynamicMusic.MUSIC_END_BOSS, 0, 0, true));
        } else if (this.level != null && this.level.dimension() == Level.END
                && this.player.getAbilities().instabuild && this.player.getAbilities().flying
                && DynamicMusic.config.generalConfig.musicTypesToggles.endCreativeMusic) {
            ci.setReturnValue(new Music(DynamicMusic.MUSIC_END_CREATIVE, 1200, 8000, true));
        }
    }
}

package net.celeri.dynmus.mixin;

import net.celeri.dynmus.DynamicMusic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
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
        if (ci.getReturnValue().equals(Musics.GAME) && this.level.dimension() == Level.OVERWORLD) {
            if (this.level != null) {
                if (DynamicMusic.isInCave(level, player.blockPosition(), DynamicMusic.config) && DynamicMusic.config.caveMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_CAVE)));
                } else if (((level.getDayTime() >= 13000 && level.getDayTime() < 23000) || level.isRaining()) && DynamicMusic.config.downMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_DOWN)));
                } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).value().getBaseTemperature() <= 0.05F && DynamicMusic.config.coldMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_COLD)));
                } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).value().getBaseTemperature() >= 2.0F && DynamicMusic.config.hotMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_HOT)));
                } else if (DynamicMusic.config.niceMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_NICE)));
                }
            }
        } else if (ci.getReturnValue().equals(Musics.CREATIVE) && this.level.dimension() == Level.OVERWORLD) {
            if (this.level != null) {
                if (DynamicMusic.isInCave(level, player.blockPosition(), DynamicMusic.config) && DynamicMusic.config.caveMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_CAVE_CREATIVE)));
                } else if (((level.getDayTime() >= 13000 && level.getDayTime() < 23000) || level.isRaining()) && DynamicMusic.config.downMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_DOWN_CREATIVE)));
                } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).value().getBaseTemperature() < 0.15F && DynamicMusic.config.coldMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_COLD_CREATIVE)));
                } else if (level.getBiomeManager().getBiome(this.player.blockPosition()).value().getBaseTemperature() > 0.95F && DynamicMusic.config.hotMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_HOT_CREATIVE)));
                } else if (DynamicMusic.config.niceMusic()) {
                    ci.setReturnValue(Musics.createGameMusic(Holder.direct(DynamicMusic.MUSIC_NICE_CREATIVE)));
                }
            }
        } else if (ci.getReturnValue() == Musics.END_BOSS && DynamicMusic.config.endBossMusic()) {
            ci.setReturnValue(new Music(Holder.direct(DynamicMusic.MUSIC_END_BOSS), 0, 0, true));
        } else if (ci.getReturnValue() == Musics.END
                && this.player.getAbilities().instabuild && this.player.getAbilities().flying
                && DynamicMusic.config.endCreativeMusic()) {
            ci.setReturnValue(new Music(Holder.direct(DynamicMusic.MUSIC_END_CREATIVE), 1200, 8000, true));
        }
    }
}

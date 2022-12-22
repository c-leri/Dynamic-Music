package net.ludocrypt.dynmus.mixin;

import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.dynmus.DynamicMusic;
import net.ludocrypt.dynmus.config.DynamicMusicConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.MusicType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Shadow
	public ClientPlayerEntity player;

	@Shadow
	public ClientWorld world;

	@Inject(method = "getMusicType", at = @At("RETURN"), cancellable = true)
	private void dynmus$getMusicType(CallbackInfoReturnable<MusicSound> ci) {
		if (ci.getReturnValue().equals(MusicType.GAME) && this.world.getRegistryKey().equals(World.OVERWORLD)) {
			if (this.world != null) {
				if (DynamicMusic.isInCave(world, player.getBlockPos())) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_CAVE.getId())));
				} else if ((world.getBiomeAccess().getBiome(this.player.getBlockPos()).value().getTemperature() < 0.15F) || (world.isRaining()) && DynamicMusicConfig.getInstance().coldMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_COLD.getId())));
				} else if ((world.getBiomeAccess().getBiome(this.player.getBlockPos()).value().getTemperature() > 0.95F) && (!world.isRaining()) && DynamicMusicConfig.getInstance().hotMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_HOT.getId())));
				} else if (world.getTimeOfDay() <= 12500 && DynamicMusicConfig.getInstance().niceMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_NICE.getId())));
				} else if (world.getTimeOfDay() > 12500 && DynamicMusicConfig.getInstance().downMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_DOWN.getId())));
				}
			}
		} else if (ci.getReturnValue().equals(MusicType.CREATIVE) && this.world.getRegistryKey().equals(World.OVERWORLD)) {
			if (this.world != null) {
				if (DynamicMusic.isInCave(world, player.getBlockPos())) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_CAVE_CREATIVE.getId())));
				} else if ((world.getBiomeAccess().getBiome(this.player.getBlockPos()).value().getTemperature() < 0.15F) || (world.isRaining()) && DynamicMusicConfig.getInstance().coldMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_COLD_CREATIVE.getId())));
				} else if ((world.getBiomeAccess().getBiome(this.player.getBlockPos()).value().getTemperature() > 0.95F) && (!world.isRaining()) && DynamicMusicConfig.getInstance().hotMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_HOT_CREATIVE.getId())));
				} else if (world.getTimeOfDay() <= 12500 && DynamicMusicConfig.getInstance().niceMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_NICE_CREATIVE.getId())));
				} else if (world.getTimeOfDay() > 12500 && DynamicMusicConfig.getInstance().downMusic) {
					dynmus$setReturnType(ci, Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_DOWN_CREATIVE.getId())));
				}
			}
		} else if (ci.getReturnValue() == MusicType.DRAGON) {
			Optional<RegistryEntry.Reference<SoundEvent>> MUSIC_END_BOSS_OPT = Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_END_BOSS.getId()));
			MUSIC_END_BOSS_OPT.ifPresent(soundEventReference -> ci.setReturnValue(new MusicSound(soundEventReference, 0, 0, true)));
		} else if (ci.getReturnValue() == MusicType.END) {
			if (this.player.getAbilities().creativeMode && this.player.getAbilities().allowFlying) {
				Optional<RegistryEntry.Reference<SoundEvent>> MUSIC_END_CREATIVE_OPT = Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), DynamicMusic.MUSIC_END_CREATIVE.getId()));
				MUSIC_END_CREATIVE_OPT.ifPresent(soundEventReference -> ci.setReturnValue(new MusicSound(soundEventReference, 1200, 8000, true)));
			}
		}
	}

	@Unique
	private void dynmus$setReturnType(CallbackInfoReturnable<MusicSound> ci, Optional<RegistryEntry.Reference<SoundEvent>> music_opt) {
		music_opt.ifPresent(soundEventReference -> ci.setReturnValue(MusicType.createIngameMusic(soundEventReference)));
	}
}

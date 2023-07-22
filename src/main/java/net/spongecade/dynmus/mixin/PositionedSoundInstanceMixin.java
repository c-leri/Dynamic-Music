package net.spongecade.dynmus.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.spongecade.dynmus.config.DynamicMusicConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
@Mixin(value = PositionedSoundInstance.class, priority = 80)
public class PositionedSoundInstanceMixin {

	@Inject(method = "music(Lnet/minecraft/sound/SoundEvent;)Lnet/minecraft/client/sound/PositionedSoundInstance;", at = @At("RETURN"), cancellable = true)
	private static void DYNMUS_changePitch(SoundEvent music, CallbackInfoReturnable<PositionedSoundInstance> ci) {
		DynamicMusicConfig config = DynamicMusicConfig.getInstance();
		Random random = new Random();
		MinecraftClient client = MinecraftClient.getInstance();
		if (config.dynamicPitch) {
			if (client.world != null) {
				int dayTime = (int) (client.world.getTimeOfDay() % 24000L);
				long absTime = Math.abs(dayTime - config.dynamicPitchAnchor);
				double delta = absTime * (0.0001832172957);
				double chance = MathHelper.lerp(delta, 1, 0);
				if (random.nextDouble() < chance) {
					double minPitch = MathHelper.lerp(delta, -12, 0);
					double maxPitch = MathHelper.lerp(random.nextDouble(), minPitch / 3, random.nextDouble() * -1);
					double note = MathHelper.lerp(random.nextDouble(), config.dynamicPitchFaster ? -minPitch : minPitch, config.dynamicPitchFaster ? -maxPitch : maxPitch);
					double newPitch = Math.pow(2.0D, note / 12.0D);
					ci.setReturnValue(new PositionedSoundInstance(music.getId(), SoundCategory.MUSIC, 1.0F, (float) newPitch, false, 0, SoundInstance.AttenuationType.NONE, 0.0D, 0.0D, 0.0D, true));
				}
			}
		}
	}

}

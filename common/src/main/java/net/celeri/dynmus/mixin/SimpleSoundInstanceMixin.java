package net.celeri.dynmus.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Environment(EnvType.CLIENT)
@Mixin(value = SimpleSoundInstance.class, priority = 80)
public class SimpleSoundInstanceMixin {
    @Inject(method = "forMusic", at = @At("RETURN"), cancellable = true)
    private static void dynmus$changePitch(SoundEvent music, CallbackInfoReturnable<SimpleSoundInstance> ci) {
        DynamicMusicConfig config = AutoConfig.getConfigHolder(DynamicMusicConfig.class).getConfig();

        Random random = new Random();
        Minecraft client = Minecraft.getInstance();

        if (config.generalConfig.dynamicPitch.activated) {
            if (client.level != null) {
                double absTime = Math.abs(client.level.getDayTime() - config.generalConfig.dynamicPitch.getAnchor());
                double delta = absTime * (0.0001832172957);
                double chance = Mth.lerp(delta, 1, 0);
                if (random.nextDouble() < chance) {
                    double minPitch = Mth.lerp(delta, -12, 0);
                    double maxPitch = Mth.lerp(random.nextDouble(), minPitch / 3, random.nextDouble() * -1);
                    double note = Mth.lerp(random.nextDouble(), config.generalConfig.dynamicPitch.faster ? -minPitch : minPitch, config.generalConfig.dynamicPitch.faster ? -maxPitch : maxPitch);
                    double newPitch = Math.pow(2.0D, note / 12.0D);
                    ci.setReturnValue(new SimpleSoundInstance(music.getLocation(), SoundSource.MUSIC, 1.0F, (float) newPitch, SoundInstance.createUnseededRandom(), false, 0, SoundInstance.Attenuation.NONE, 0.0D, 0.0D, 0.0D, true));
                }
            }
        }
    }
}

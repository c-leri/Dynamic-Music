package net.celeri.dynmus.mixin;

import net.celeri.dynmus.DynamicMusic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.BiomeAmbientSoundsHandler;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(BiomeAmbientSoundsHandler.class)
public class BiomeAmbientSoundsHandlerMixin {
    @Shadow
    private float moodiness;

    @Shadow
    @Final
    private LocalPlayer player;

    @Shadow
    private Optional<AmbientMoodSettings> moodSettings = Optional.empty();

    @Inject(method = "tick", at = @At("HEAD"))
    private void dynmus$tick(CallbackInfo ci) {
        this.moodSettings.ifPresent((ambientMoodSettings -> {
            Level level = this.player.level;
            if (DynamicMusic.isInCave(level, player.blockPosition(), DynamicMusic.config)
                    && DynamicMusic.isInPseudoMinecraft(level, player.blockPosition(), DynamicMusic.config)) {
                this.moodiness += (float) ((15 - DynamicMusic.getAverageDarkness(level, player.blockPosition(), DynamicMusic.config)) / (float) ambientMoodSettings.getTickDelay());
            }
        }));
    }
}

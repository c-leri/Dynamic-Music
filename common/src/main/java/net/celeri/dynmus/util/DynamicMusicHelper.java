package net.celeri.dynmus.util;

import me.shedaniel.autoconfig.AutoConfig;
import net.celeri.dynmus.config.DynamicMusicConfig;
import net.celeri.dynmus.config.MusicSelector.MusicToggle;
import net.celeri.dynmus.DynamicMusic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvent;

import java.util.*;
import java.util.stream.Collectors;

public class DynamicMusicHelper {
    public enum MusicType {
        Cave, Cold, Hot, Nice, Down, End
    }

    private static final Random random = new Random();

    private static final List<String> recordNames = List.of(
        "13", "cat", "blocks", "chirp", "far", "mall",
        "mellohi", "stal", "strad", "ward", "11", "wait",
        "otherside", "5", "pigstep"
    );
    private static final List<String> musicNames = List.of(
        "calm1", "calm2", "calm3",
        "creative1", "creative2", "creative3", "creative4", "creative5", "creative6",
        "hal1", "hal2", "hal3", "hal4",
        "nuance1", "nuance2",
        "piano1", "piano2", "piano3",
        "aerie", "ancestry", "an_ordinary_day",
        "comforting_memories", "firebugs", "floating_dream",
        "infinite_amethyst", "labyrinthine", "left_to_bloom",
        "one_more_day", "stand_tall", "wending",
        "end.end", "end.creative1", "end.creative2", "end.creative3", "end.creative4"
    );

    private static Map<String, SoundEvent> getRecords() {
        return recordNames.stream().collect(
            Collectors.toMap(
                recordName -> recordName,
                recordName -> new SoundEvent(new ResourceLocation("minecraft", "music_disc." + recordName))
            )
        );
    }

    public static Map<String, SoundEvent> getMusics() {
        return musicNames.stream().collect(
            Collectors.toMap(
                musicName -> musicName,
                musicName -> new SoundEvent(new ResourceLocation(DynamicMusic.MOD_ID, "music." + musicName))
            )
        );
    }

    private static Map<String, SoundEvent> getMusicsAndRecords() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        out.putAll(getRecords());
        out.putAll(getMusics());

        return out;
    }

    public static List<SoundEvent> getToggledCreativeMusicForType(MusicType type) {
        Map<String, MusicToggle> musicToggles = getMusicTogglesForType(type);
        Map<String, SoundEvent> musics = DynamicMusicHelper.getMusicsAndRecords();

        return musicToggles.entrySet().stream().filter(
            musicToggleEntry ->
                musics.containsKey(musicToggleEntry.getKey())
                    && (musicToggleEntry.getValue() == MusicToggle.Creative || musicToggleEntry.getValue() == MusicToggle.Both)
        ).map(
            musicToggleEntry -> musics.get(musicToggleEntry.getKey())
        ).toList();
    }

    public static List<SoundEvent> getToggledSurvivalMusicForType(MusicType type) {
        Map<String, MusicToggle> musicToggles = getMusicTogglesForType(type);
        Map<String, SoundEvent> musics = DynamicMusicHelper.getMusicsAndRecords();

        return musicToggles.entrySet().stream().filter(
            musicToggleEntry ->
                musics.containsKey(musicToggleEntry.getKey())
                    && (musicToggleEntry.getValue() == MusicToggle.Survival || musicToggleEntry.getValue() == MusicToggle.Both)
        ).map(
            musicToggleEntry -> musics.get(musicToggleEntry.getKey())
        ).toList();
    }

    public static Music getRandomMusic(List<SoundEvent> sounds) {
        return Musics.createGameMusic(
            sounds.get(random.nextInt(sounds.size()))
        );
    }

    private static Map<String, MusicToggle> getMusicTogglesForType(MusicType type) {
        DynamicMusicConfig config = AutoConfig.getConfigHolder(DynamicMusicConfig.class).getConfig();

        return switch (type) {
            case Cave -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.caveMusic.calm1),
                Map.entry("calm2", config.musicSelector.caveMusic.calm2),
                Map.entry("calm3", config.musicSelector.caveMusic.calm3),
                Map.entry("creative1", config.musicSelector.caveMusic.creative1),
                Map.entry("creative2", config.musicSelector.caveMusic.creative2),
                Map.entry("creative3", config.musicSelector.caveMusic.creative3),
                Map.entry("creative4", config.musicSelector.caveMusic.creative4),
                Map.entry("creative5", config.musicSelector.caveMusic.creative5),
                Map.entry("creative6", config.musicSelector.caveMusic.creative6),
                Map.entry("hal1", config.musicSelector.caveMusic.hal1),
                Map.entry("hal2", config.musicSelector.caveMusic.hal2),
                Map.entry("hal3", config.musicSelector.caveMusic.hal3),
                Map.entry("hal4", config.musicSelector.caveMusic.hal4),
                Map.entry("nuance1", config.musicSelector.caveMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.caveMusic.nuance2),
                Map.entry("piano1", config.musicSelector.caveMusic.piano1),
                Map.entry("piano2", config.musicSelector.caveMusic.piano2),
                Map.entry("piano3", config.musicSelector.caveMusic.piano3),
                Map.entry("aerie", config.musicSelector.caveMusic.aerie),
                Map.entry("ancestry", config.musicSelector.caveMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.caveMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.caveMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.caveMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.caveMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.caveMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.caveMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.caveMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.caveMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.caveMusic.stand_tall),
                Map.entry("wending", config.musicSelector.caveMusic.wending),
                Map.entry("13", config.musicSelector.caveMusic.thirteen),
                Map.entry("cat", config.musicSelector.caveMusic.cat),
                Map.entry("blocks", config.musicSelector.caveMusic.blocks),
                Map.entry("chirp", config.musicSelector.caveMusic.chirp),
                Map.entry("far", config.musicSelector.caveMusic.far),
                Map.entry("mall", config.musicSelector.caveMusic.mall),
                Map.entry("mellohi", config.musicSelector.caveMusic.mellohi),
                Map.entry("stal", config.musicSelector.caveMusic.stal),
                Map.entry("strad", config.musicSelector.caveMusic.strad),
                Map.entry("ward", config.musicSelector.caveMusic.ward),
                Map.entry("11", config.musicSelector.caveMusic.eleven),
                Map.entry("wait", config.musicSelector.caveMusic.wait),
                Map.entry("otherside", config.musicSelector.caveMusic.otherside),
                Map.entry("5", config.musicSelector.caveMusic.five),
                Map.entry("pigstep", config.musicSelector.caveMusic.pigstep),
                Map.entry("end.end", config.musicSelector.caveMusic.end),
                Map.entry("end.creative1", config.musicSelector.caveMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.caveMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.caveMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.caveMusic.end_creative4)
            );
            case Cold -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.coldMusic.calm1),
                Map.entry("calm2", config.musicSelector.coldMusic.calm2),
                Map.entry("calm3", config.musicSelector.coldMusic.calm3),
                Map.entry("creative1", config.musicSelector.coldMusic.creative1),
                Map.entry("creative2", config.musicSelector.coldMusic.creative2),
                Map.entry("creative3", config.musicSelector.coldMusic.creative3),
                Map.entry("creative4", config.musicSelector.coldMusic.creative4),
                Map.entry("creative5", config.musicSelector.coldMusic.creative5),
                Map.entry("creative6", config.musicSelector.coldMusic.creative6),
                Map.entry("hal1", config.musicSelector.coldMusic.hal1),
                Map.entry("hal2", config.musicSelector.coldMusic.hal2),
                Map.entry("hal3", config.musicSelector.coldMusic.hal3),
                Map.entry("hal4", config.musicSelector.coldMusic.hal4),
                Map.entry("nuance1", config.musicSelector.coldMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.coldMusic.nuance2),
                Map.entry("piano1", config.musicSelector.coldMusic.piano1),
                Map.entry("piano2", config.musicSelector.coldMusic.piano2),
                Map.entry("piano3", config.musicSelector.coldMusic.piano3),
                Map.entry("aerie", config.musicSelector.coldMusic.aerie),
                Map.entry("ancestry", config.musicSelector.coldMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.coldMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.coldMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.coldMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.coldMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.coldMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.coldMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.coldMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.coldMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.coldMusic.stand_tall),
                Map.entry("wending", config.musicSelector.coldMusic.wending),
                Map.entry("13", config.musicSelector.coldMusic.thirteen),
                Map.entry("cat", config.musicSelector.coldMusic.cat),
                Map.entry("blocks", config.musicSelector.coldMusic.blocks),
                Map.entry("chirp", config.musicSelector.coldMusic.chirp),
                Map.entry("far", config.musicSelector.coldMusic.far),
                Map.entry("mall", config.musicSelector.coldMusic.mall),
                Map.entry("mellohi", config.musicSelector.coldMusic.mellohi),
                Map.entry("stal", config.musicSelector.coldMusic.stal),
                Map.entry("strad", config.musicSelector.coldMusic.strad),
                Map.entry("ward", config.musicSelector.coldMusic.ward),
                Map.entry("11", config.musicSelector.coldMusic.eleven),
                Map.entry("wait", config.musicSelector.coldMusic.wait),
                Map.entry("otherside", config.musicSelector.coldMusic.otherside),
                Map.entry("5", config.musicSelector.coldMusic.five),
                Map.entry("pigstep", config.musicSelector.coldMusic.pigstep),
                Map.entry("end.end", config.musicSelector.coldMusic.end),
                Map.entry("end.creative1", config.musicSelector.coldMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.coldMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.coldMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.coldMusic.end_creative4)
            );
            case Hot -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.hotMusic.calm1),
                Map.entry("calm2", config.musicSelector.hotMusic.calm2),
                Map.entry("calm3", config.musicSelector.hotMusic.calm3),
                Map.entry("creative1", config.musicSelector.hotMusic.creative1),
                Map.entry("creative2", config.musicSelector.hotMusic.creative2),
                Map.entry("creative3", config.musicSelector.hotMusic.creative3),
                Map.entry("creative4", config.musicSelector.hotMusic.creative4),
                Map.entry("creative5", config.musicSelector.hotMusic.creative5),
                Map.entry("creative6", config.musicSelector.hotMusic.creative6),
                Map.entry("hal1", config.musicSelector.hotMusic.hal1),
                Map.entry("hal2", config.musicSelector.hotMusic.hal2),
                Map.entry("hal3", config.musicSelector.hotMusic.hal3),
                Map.entry("hal4", config.musicSelector.hotMusic.hal4),
                Map.entry("nuance1", config.musicSelector.hotMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.hotMusic.nuance2),
                Map.entry("piano1", config.musicSelector.hotMusic.piano1),
                Map.entry("piano2", config.musicSelector.hotMusic.piano2),
                Map.entry("piano3", config.musicSelector.hotMusic.piano3),
                Map.entry("aerie", config.musicSelector.hotMusic.aerie),
                Map.entry("ancestry", config.musicSelector.hotMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.hotMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.hotMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.hotMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.hotMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.hotMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.hotMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.hotMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.hotMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.hotMusic.stand_tall),
                Map.entry("wending", config.musicSelector.hotMusic.wending),
                Map.entry("13", config.musicSelector.hotMusic.thirteen),
                Map.entry("cat", config.musicSelector.hotMusic.cat),
                Map.entry("blocks", config.musicSelector.hotMusic.blocks),
                Map.entry("chirp", config.musicSelector.hotMusic.chirp),
                Map.entry("far", config.musicSelector.hotMusic.far),
                Map.entry("mall", config.musicSelector.hotMusic.mall),
                Map.entry("mellohi", config.musicSelector.hotMusic.mellohi),
                Map.entry("stal", config.musicSelector.hotMusic.stal),
                Map.entry("strad", config.musicSelector.hotMusic.strad),
                Map.entry("ward", config.musicSelector.hotMusic.ward),
                Map.entry("11", config.musicSelector.hotMusic.eleven),
                Map.entry("wait", config.musicSelector.hotMusic.wait),
                Map.entry("otherside", config.musicSelector.hotMusic.otherside),
                Map.entry("5", config.musicSelector.hotMusic.five),
                Map.entry("pigstep", config.musicSelector.hotMusic.pigstep),
                Map.entry("end.end", config.musicSelector.hotMusic.end),
                Map.entry("end.creative1", config.musicSelector.hotMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.hotMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.hotMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.hotMusic.end_creative4)
            );
            case Nice -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.niceMusic.calm1),
                Map.entry("calm2", config.musicSelector.niceMusic.calm2),
                Map.entry("calm3", config.musicSelector.niceMusic.calm3),
                Map.entry("creative1", config.musicSelector.niceMusic.creative1),
                Map.entry("creative2", config.musicSelector.niceMusic.creative2),
                Map.entry("creative3", config.musicSelector.niceMusic.creative3),
                Map.entry("creative4", config.musicSelector.niceMusic.creative4),
                Map.entry("creative5", config.musicSelector.niceMusic.creative5),
                Map.entry("creative6", config.musicSelector.niceMusic.creative6),
                Map.entry("hal1", config.musicSelector.niceMusic.hal1),
                Map.entry("hal2", config.musicSelector.niceMusic.hal2),
                Map.entry("hal3", config.musicSelector.niceMusic.hal3),
                Map.entry("hal4", config.musicSelector.niceMusic.hal4),
                Map.entry("nuance1", config.musicSelector.niceMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.niceMusic.nuance2),
                Map.entry("piano1", config.musicSelector.niceMusic.piano1),
                Map.entry("piano2", config.musicSelector.niceMusic.piano2),
                Map.entry("piano3", config.musicSelector.niceMusic.piano3),
                Map.entry("aerie", config.musicSelector.niceMusic.aerie),
                Map.entry("ancestry", config.musicSelector.niceMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.niceMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.niceMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.niceMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.niceMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.niceMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.niceMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.niceMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.niceMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.niceMusic.stand_tall),
                Map.entry("wending", config.musicSelector.niceMusic.wending),
                Map.entry("13", config.musicSelector.niceMusic.thirteen),
                Map.entry("cat", config.musicSelector.niceMusic.cat),
                Map.entry("blocks", config.musicSelector.niceMusic.blocks),
                Map.entry("chirp", config.musicSelector.niceMusic.chirp),
                Map.entry("far", config.musicSelector.niceMusic.far),
                Map.entry("mall", config.musicSelector.niceMusic.mall),
                Map.entry("mellohi", config.musicSelector.niceMusic.mellohi),
                Map.entry("stal", config.musicSelector.niceMusic.stal),
                Map.entry("strad", config.musicSelector.niceMusic.strad),
                Map.entry("ward", config.musicSelector.niceMusic.ward),
                Map.entry("11", config.musicSelector.niceMusic.eleven),
                Map.entry("wait", config.musicSelector.niceMusic.wait),
                Map.entry("otherside", config.musicSelector.niceMusic.otherside),
                Map.entry("5", config.musicSelector.niceMusic.five),
                Map.entry("pigstep", config.musicSelector.niceMusic.pigstep),
                Map.entry("end.end", config.musicSelector.niceMusic.end),
                Map.entry("end.creative1", config.musicSelector.niceMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.niceMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.niceMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.niceMusic.end_creative4)
            );
            case Down -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.downMusic.calm1),
                Map.entry("calm2", config.musicSelector.downMusic.calm2),
                Map.entry("calm3", config.musicSelector.downMusic.calm3),
                Map.entry("creative1", config.musicSelector.downMusic.creative1),
                Map.entry("creative2", config.musicSelector.downMusic.creative2),
                Map.entry("creative3", config.musicSelector.downMusic.creative3),
                Map.entry("creative4", config.musicSelector.downMusic.creative4),
                Map.entry("creative5", config.musicSelector.downMusic.creative5),
                Map.entry("creative6", config.musicSelector.downMusic.creative6),
                Map.entry("hal1", config.musicSelector.downMusic.hal1),
                Map.entry("hal2", config.musicSelector.downMusic.hal2),
                Map.entry("hal3", config.musicSelector.downMusic.hal3),
                Map.entry("hal4", config.musicSelector.downMusic.hal4),
                Map.entry("nuance1", config.musicSelector.downMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.downMusic.nuance2),
                Map.entry("piano1", config.musicSelector.downMusic.piano1),
                Map.entry("piano2", config.musicSelector.downMusic.piano2),
                Map.entry("piano3", config.musicSelector.downMusic.piano3),
                Map.entry("aerie", config.musicSelector.downMusic.aerie),
                Map.entry("ancestry", config.musicSelector.downMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.downMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.downMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.downMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.downMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.downMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.downMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.downMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.downMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.downMusic.stand_tall),
                Map.entry("wending", config.musicSelector.downMusic.wending),
                Map.entry("13", config.musicSelector.downMusic.thirteen),
                Map.entry("cat", config.musicSelector.downMusic.cat),
                Map.entry("blocks", config.musicSelector.downMusic.blocks),
                Map.entry("chirp", config.musicSelector.downMusic.chirp),
                Map.entry("far", config.musicSelector.downMusic.far),
                Map.entry("mall", config.musicSelector.downMusic.mall),
                Map.entry("mellohi", config.musicSelector.downMusic.mellohi),
                Map.entry("stal", config.musicSelector.downMusic.stal),
                Map.entry("strad", config.musicSelector.downMusic.strad),
                Map.entry("ward", config.musicSelector.downMusic.ward),
                Map.entry("11", config.musicSelector.downMusic.eleven),
                Map.entry("wait", config.musicSelector.downMusic.wait),
                Map.entry("otherside", config.musicSelector.downMusic.otherside),
                Map.entry("5", config.musicSelector.downMusic.five),
                Map.entry("pigstep", config.musicSelector.downMusic.pigstep),
                Map.entry("end.end", config.musicSelector.downMusic.end),
                Map.entry("end.creative1", config.musicSelector.downMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.downMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.downMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.downMusic.end_creative4)
            );
            case End -> Map.ofEntries(
                Map.entry("calm1", config.musicSelector.endMusic.calm1),
                Map.entry("calm2", config.musicSelector.endMusic.calm2),
                Map.entry("calm3", config.musicSelector.endMusic.calm3),
                Map.entry("creative1", config.musicSelector.endMusic.creative1),
                Map.entry("creative2", config.musicSelector.endMusic.creative2),
                Map.entry("creative3", config.musicSelector.endMusic.creative3),
                Map.entry("creative4", config.musicSelector.endMusic.creative4),
                Map.entry("creative5", config.musicSelector.endMusic.creative5),
                Map.entry("creative6", config.musicSelector.endMusic.creative6),
                Map.entry("hal1", config.musicSelector.endMusic.hal1),
                Map.entry("hal2", config.musicSelector.endMusic.hal2),
                Map.entry("hal3", config.musicSelector.endMusic.hal3),
                Map.entry("hal4", config.musicSelector.endMusic.hal4),
                Map.entry("nuance1", config.musicSelector.endMusic.nuance1),
                Map.entry("nuance2", config.musicSelector.endMusic.nuance2),
                Map.entry("piano1", config.musicSelector.endMusic.piano1),
                Map.entry("piano2", config.musicSelector.endMusic.piano2),
                Map.entry("piano3", config.musicSelector.endMusic.piano3),
                Map.entry("aerie", config.musicSelector.endMusic.aerie),
                Map.entry("ancestry", config.musicSelector.endMusic.ancestry),
                Map.entry("an_ordinary_day", config.musicSelector.endMusic.an_ordinary_day),
                Map.entry("comforting_memories", config.musicSelector.endMusic.comforting_memories),
                Map.entry("firebugs", config.musicSelector.endMusic.firebugs),
                Map.entry("floating_dream", config.musicSelector.endMusic.floating_dream),
                Map.entry("infinite_amethyst", config.musicSelector.endMusic.infinite_amethyst),
                Map.entry("labyrinthine", config.musicSelector.endMusic.labyrinthine),
                Map.entry("left_to_bloom", config.musicSelector.endMusic.left_to_bloom),
                Map.entry("one_more_day", config.musicSelector.endMusic.one_more_day),
                Map.entry("stand_tall", config.musicSelector.endMusic.stand_tall),
                Map.entry("wending", config.musicSelector.endMusic.wending),
                Map.entry("13", config.musicSelector.endMusic.thirteen),
                Map.entry("cat", config.musicSelector.endMusic.cat),
                Map.entry("blocks", config.musicSelector.endMusic.blocks),
                Map.entry("chirp", config.musicSelector.endMusic.chirp),
                Map.entry("far", config.musicSelector.endMusic.far),
                Map.entry("mall", config.musicSelector.endMusic.mall),
                Map.entry("mellohi", config.musicSelector.endMusic.mellohi),
                Map.entry("stal", config.musicSelector.endMusic.stal),
                Map.entry("strad", config.musicSelector.endMusic.strad),
                Map.entry("ward", config.musicSelector.endMusic.ward),
                Map.entry("11", config.musicSelector.endMusic.eleven),
                Map.entry("wait", config.musicSelector.endMusic.wait),
                Map.entry("otherside", config.musicSelector.endMusic.otherside),
                Map.entry("5", config.musicSelector.endMusic.five),
                Map.entry("pigstep", config.musicSelector.endMusic.pigstep),
                Map.entry("end.end", config.musicSelector.endMusic.end),
                Map.entry("end.creative1", config.musicSelector.endMusic.end_creative1),
                Map.entry("end.creative2", config.musicSelector.endMusic.end_creative2),
                Map.entry("end.creative3", config.musicSelector.endMusic.end_creative3),
                Map.entry("end.creative4", config.musicSelector.endMusic.end_creative4)
            );
        };
    }
}

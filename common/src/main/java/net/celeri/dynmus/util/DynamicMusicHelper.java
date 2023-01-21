package net.celeri.dynmus.util;

import net.celeri.dynmus.config.MusicSelector.MusicToggle;
import net.celeri.dynmus.DynamicMusic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.*;

public class DynamicMusicHelper {
    public enum MusicType {
        Cave, Cold, Hot, Nice, Down
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
            "an_ordinary_day", "comforting_memories", "floating_dream",
            "infinite_amethyst", "left_to_bloom", "one_more_day",
            "stand_tall", "wending"
    );

    private static Map<String, SoundEvent> getRecords() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        for (String recordName : recordNames) {
            out.put(recordName, new SoundEvent(new ResourceLocation("minecraft", "music_disc." + recordName)));
        }

        return out;
    }
    public static Map<String, SoundEvent> getMusics() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        for (String musicName : musicNames) {
            out.put(musicName, new SoundEvent(new ResourceLocation(DynamicMusic.MOD_ID, "music." + musicName)));
        }

        return out;
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

        List<SoundEvent> out = new ArrayList<>();

        musicToggles.forEach((musicName, musicToggle) -> {
            if (musics.containsKey(musicName) && (musicToggle == MusicToggle.Creative || musicToggle == MusicToggle.Both))
                out.add(musics.get(musicName));
        });

        return out;
    }
    public static List<SoundEvent> getToggledSurvivalMusicForType(MusicType type) {
        Map<String, MusicToggle> musicToggles = getMusicTogglesForType(type);
        Map<String, SoundEvent> musics = DynamicMusicHelper.getMusicsAndRecords();

        List<SoundEvent> out = new ArrayList<>();

        musicToggles.forEach((musicName, musicToggle) -> {
            if (musics.containsKey(musicName) && (musicToggle == MusicToggle.Survival || musicToggle == MusicToggle.Both))
                out.add(musics.get(musicName));
        });

        return out;
    }

    public static SoundEvent getRandomSoundEvent(List<SoundEvent> sounds) {
        return sounds.get(random.nextInt(sounds.size()));
    }

    private static Map<String, MusicToggle> getMusicTogglesForType(MusicType type) {
        return switch (type) {
            case Cave -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusic.config.musicSelector.caveMusic.calm1),
                    Map.entry("calm2", DynamicMusic.config.musicSelector.caveMusic.calm2),
                    Map.entry("calm3", DynamicMusic.config.musicSelector.caveMusic.calm3),
                    Map.entry("creative1", DynamicMusic.config.musicSelector.caveMusic.creative1),
                    Map.entry("creative2", DynamicMusic.config.musicSelector.caveMusic.creative2),
                    Map.entry("creative3", DynamicMusic.config.musicSelector.caveMusic.creative3),
                    Map.entry("creative4", DynamicMusic.config.musicSelector.caveMusic.creative4),
                    Map.entry("creative5", DynamicMusic.config.musicSelector.caveMusic.creative5),
                    Map.entry("creative6", DynamicMusic.config.musicSelector.caveMusic.creative6),
                    Map.entry("hal1", DynamicMusic.config.musicSelector.caveMusic.hal1),
                    Map.entry("hal2", DynamicMusic.config.musicSelector.caveMusic.hal2),
                    Map.entry("hal3", DynamicMusic.config.musicSelector.caveMusic.hal3),
                    Map.entry("hal4", DynamicMusic.config.musicSelector.caveMusic.hal4),
                    Map.entry("nuance1", DynamicMusic.config.musicSelector.caveMusic.nuance1),
                    Map.entry("nuance2", DynamicMusic.config.musicSelector.caveMusic.nuance2),
                    Map.entry("piano1", DynamicMusic.config.musicSelector.caveMusic.piano1),
                    Map.entry("piano2", DynamicMusic.config.musicSelector.caveMusic.piano2),
                    Map.entry("piano3", DynamicMusic.config.musicSelector.caveMusic.piano3),
                    Map.entry("an_ordinary_day", DynamicMusic.config.musicSelector.caveMusic.an_ordinary_day),
                    Map.entry("comforting_memories", DynamicMusic.config.musicSelector.caveMusic.comforting_memories),
                    Map.entry("floating_dream", DynamicMusic.config.musicSelector.caveMusic.floating_dream),
                    Map.entry("infinite_amethyst", DynamicMusic.config.musicSelector.caveMusic.infinite_amethyst),
                    Map.entry("left_to_bloom", DynamicMusic.config.musicSelector.caveMusic.left_to_bloom),
                    Map.entry("one_more_day", DynamicMusic.config.musicSelector.caveMusic.one_more_day),
                    Map.entry("stand_tall", DynamicMusic.config.musicSelector.caveMusic.stand_tall),
                    Map.entry("wending", DynamicMusic.config.musicSelector.caveMusic.wending),
                    Map.entry("13", DynamicMusic.config.musicSelector.caveMusic.thirteen),
                    Map.entry("cat", DynamicMusic.config.musicSelector.caveMusic.cat),
                    Map.entry("blocks", DynamicMusic.config.musicSelector.caveMusic.blocks),
                    Map.entry("chirp", DynamicMusic.config.musicSelector.caveMusic.chirp),
                    Map.entry("far", DynamicMusic.config.musicSelector.caveMusic.far),
                    Map.entry("mall", DynamicMusic.config.musicSelector.caveMusic.mall),
                    Map.entry("mellohi", DynamicMusic.config.musicSelector.caveMusic.mellohi),
                    Map.entry("stal", DynamicMusic.config.musicSelector.caveMusic.stal),
                    Map.entry("strad", DynamicMusic.config.musicSelector.caveMusic.strad),
                    Map.entry("ward", DynamicMusic.config.musicSelector.caveMusic.ward),
                    Map.entry("11", DynamicMusic.config.musicSelector.caveMusic.eleven),
                    Map.entry("wait", DynamicMusic.config.musicSelector.caveMusic.wait),
                    Map.entry("otherside", DynamicMusic.config.musicSelector.caveMusic.otherside),
                    Map.entry("5", DynamicMusic.config.musicSelector.caveMusic.five),
                    Map.entry("pigstep", DynamicMusic.config.musicSelector.caveMusic.pigstep)
            );
            case Cold -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusic.config.musicSelector.coldMusic.calm1),
                    Map.entry("calm2", DynamicMusic.config.musicSelector.coldMusic.calm2),
                    Map.entry("calm3", DynamicMusic.config.musicSelector.coldMusic.calm3),
                    Map.entry("creative1", DynamicMusic.config.musicSelector.coldMusic.creative1),
                    Map.entry("creative2", DynamicMusic.config.musicSelector.coldMusic.creative2),
                    Map.entry("creative3", DynamicMusic.config.musicSelector.coldMusic.creative3),
                    Map.entry("creative4", DynamicMusic.config.musicSelector.coldMusic.creative4),
                    Map.entry("creative5", DynamicMusic.config.musicSelector.coldMusic.creative5),
                    Map.entry("creative6", DynamicMusic.config.musicSelector.coldMusic.creative6),
                    Map.entry("hal1", DynamicMusic.config.musicSelector.coldMusic.hal1),
                    Map.entry("hal2", DynamicMusic.config.musicSelector.coldMusic.hal2),
                    Map.entry("hal3", DynamicMusic.config.musicSelector.coldMusic.hal3),
                    Map.entry("hal4", DynamicMusic.config.musicSelector.coldMusic.hal4),
                    Map.entry("nuance1", DynamicMusic.config.musicSelector.coldMusic.nuance1),
                    Map.entry("nuance2", DynamicMusic.config.musicSelector.coldMusic.nuance2),
                    Map.entry("piano1", DynamicMusic.config.musicSelector.coldMusic.piano1),
                    Map.entry("piano2", DynamicMusic.config.musicSelector.coldMusic.piano2),
                    Map.entry("piano3", DynamicMusic.config.musicSelector.coldMusic.piano3),
                    Map.entry("an_ordinary_day", DynamicMusic.config.musicSelector.coldMusic.an_ordinary_day),
                    Map.entry("comforting_memories", DynamicMusic.config.musicSelector.coldMusic.comforting_memories),
                    Map.entry("floating_dream", DynamicMusic.config.musicSelector.coldMusic.floating_dream),
                    Map.entry("infinite_amethyst", DynamicMusic.config.musicSelector.coldMusic.infinite_amethyst),
                    Map.entry("left_to_bloom", DynamicMusic.config.musicSelector.coldMusic.left_to_bloom),
                    Map.entry("one_more_day", DynamicMusic.config.musicSelector.coldMusic.one_more_day),
                    Map.entry("stand_tall", DynamicMusic.config.musicSelector.coldMusic.stand_tall),
                    Map.entry("wending", DynamicMusic.config.musicSelector.coldMusic.wending),
                    Map.entry("13", DynamicMusic.config.musicSelector.coldMusic.thirteen),
                    Map.entry("cat", DynamicMusic.config.musicSelector.coldMusic.cat),
                    Map.entry("blocks", DynamicMusic.config.musicSelector.coldMusic.blocks),
                    Map.entry("chirp", DynamicMusic.config.musicSelector.coldMusic.chirp),
                    Map.entry("far", DynamicMusic.config.musicSelector.coldMusic.far),
                    Map.entry("mall", DynamicMusic.config.musicSelector.coldMusic.mall),
                    Map.entry("mellohi", DynamicMusic.config.musicSelector.coldMusic.mellohi),
                    Map.entry("stal", DynamicMusic.config.musicSelector.coldMusic.stal),
                    Map.entry("strad", DynamicMusic.config.musicSelector.coldMusic.strad),
                    Map.entry("ward", DynamicMusic.config.musicSelector.coldMusic.ward),
                    Map.entry("11", DynamicMusic.config.musicSelector.coldMusic.eleven),
                    Map.entry("wait", DynamicMusic.config.musicSelector.coldMusic.wait),
                    Map.entry("otherside", DynamicMusic.config.musicSelector.coldMusic.otherside),
                    Map.entry("5", DynamicMusic.config.musicSelector.coldMusic.five),
                    Map.entry("pigstep", DynamicMusic.config.musicSelector.coldMusic.pigstep)
            );
            case Hot -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusic.config.musicSelector.hotMusic.calm1),
                    Map.entry("calm2", DynamicMusic.config.musicSelector.hotMusic.calm2),
                    Map.entry("calm3", DynamicMusic.config.musicSelector.hotMusic.calm3),
                    Map.entry("creative1", DynamicMusic.config.musicSelector.hotMusic.creative1),
                    Map.entry("creative2", DynamicMusic.config.musicSelector.hotMusic.creative2),
                    Map.entry("creative3", DynamicMusic.config.musicSelector.hotMusic.creative3),
                    Map.entry("creative4", DynamicMusic.config.musicSelector.hotMusic.creative4),
                    Map.entry("creative5", DynamicMusic.config.musicSelector.hotMusic.creative5),
                    Map.entry("creative6", DynamicMusic.config.musicSelector.hotMusic.creative6),
                    Map.entry("hal1", DynamicMusic.config.musicSelector.hotMusic.hal1),
                    Map.entry("hal2", DynamicMusic.config.musicSelector.hotMusic.hal2),
                    Map.entry("hal3", DynamicMusic.config.musicSelector.hotMusic.hal3),
                    Map.entry("hal4", DynamicMusic.config.musicSelector.hotMusic.hal4),
                    Map.entry("nuance1", DynamicMusic.config.musicSelector.hotMusic.nuance1),
                    Map.entry("nuance2", DynamicMusic.config.musicSelector.hotMusic.nuance2),
                    Map.entry("piano1", DynamicMusic.config.musicSelector.hotMusic.piano1),
                    Map.entry("piano2", DynamicMusic.config.musicSelector.hotMusic.piano2),
                    Map.entry("piano3", DynamicMusic.config.musicSelector.hotMusic.piano3),
                    Map.entry("an_ordinary_day", DynamicMusic.config.musicSelector.hotMusic.an_ordinary_day),
                    Map.entry("comforting_memories", DynamicMusic.config.musicSelector.hotMusic.comforting_memories),
                    Map.entry("floating_dream", DynamicMusic.config.musicSelector.hotMusic.floating_dream),
                    Map.entry("infinite_amethyst", DynamicMusic.config.musicSelector.hotMusic.infinite_amethyst),
                    Map.entry("left_to_bloom", DynamicMusic.config.musicSelector.hotMusic.left_to_bloom),
                    Map.entry("one_more_day", DynamicMusic.config.musicSelector.hotMusic.one_more_day),
                    Map.entry("stand_tall", DynamicMusic.config.musicSelector.hotMusic.stand_tall),
                    Map.entry("wending", DynamicMusic.config.musicSelector.hotMusic.wending),
                    Map.entry("13", DynamicMusic.config.musicSelector.hotMusic.thirteen),
                    Map.entry("cat", DynamicMusic.config.musicSelector.hotMusic.cat),
                    Map.entry("blocks", DynamicMusic.config.musicSelector.hotMusic.blocks),
                    Map.entry("chirp", DynamicMusic.config.musicSelector.hotMusic.chirp),
                    Map.entry("far", DynamicMusic.config.musicSelector.hotMusic.far),
                    Map.entry("mall", DynamicMusic.config.musicSelector.hotMusic.mall),
                    Map.entry("mellohi", DynamicMusic.config.musicSelector.hotMusic.mellohi),
                    Map.entry("stal", DynamicMusic.config.musicSelector.hotMusic.stal),
                    Map.entry("strad", DynamicMusic.config.musicSelector.hotMusic.strad),
                    Map.entry("ward", DynamicMusic.config.musicSelector.hotMusic.ward),
                    Map.entry("11", DynamicMusic.config.musicSelector.hotMusic.eleven),
                    Map.entry("wait", DynamicMusic.config.musicSelector.hotMusic.wait),
                    Map.entry("otherside", DynamicMusic.config.musicSelector.hotMusic.otherside),
                    Map.entry("5", DynamicMusic.config.musicSelector.hotMusic.five),
                    Map.entry("pigstep", DynamicMusic.config.musicSelector.hotMusic.pigstep)
            );
            case Nice -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusic.config.musicSelector.niceMusic.calm1),
                    Map.entry("calm2", DynamicMusic.config.musicSelector.niceMusic.calm2),
                    Map.entry("calm3", DynamicMusic.config.musicSelector.niceMusic.calm3),
                    Map.entry("creative1", DynamicMusic.config.musicSelector.niceMusic.creative1),
                    Map.entry("creative2", DynamicMusic.config.musicSelector.niceMusic.creative2),
                    Map.entry("creative3", DynamicMusic.config.musicSelector.niceMusic.creative3),
                    Map.entry("creative4", DynamicMusic.config.musicSelector.niceMusic.creative4),
                    Map.entry("creative5", DynamicMusic.config.musicSelector.niceMusic.creative5),
                    Map.entry("creative6", DynamicMusic.config.musicSelector.niceMusic.creative6),
                    Map.entry("hal1", DynamicMusic.config.musicSelector.niceMusic.hal1),
                    Map.entry("hal2", DynamicMusic.config.musicSelector.niceMusic.hal2),
                    Map.entry("hal3", DynamicMusic.config.musicSelector.niceMusic.hal3),
                    Map.entry("hal4", DynamicMusic.config.musicSelector.niceMusic.hal4),
                    Map.entry("nuance1", DynamicMusic.config.musicSelector.niceMusic.nuance1),
                    Map.entry("nuance2", DynamicMusic.config.musicSelector.niceMusic.nuance2),
                    Map.entry("piano1", DynamicMusic.config.musicSelector.niceMusic.piano1),
                    Map.entry("piano2", DynamicMusic.config.musicSelector.niceMusic.piano2),
                    Map.entry("piano3", DynamicMusic.config.musicSelector.niceMusic.piano3),
                    Map.entry("an_ordinary_day", DynamicMusic.config.musicSelector.niceMusic.an_ordinary_day),
                    Map.entry("comforting_memories", DynamicMusic.config.musicSelector.niceMusic.comforting_memories),
                    Map.entry("floating_dream", DynamicMusic.config.musicSelector.niceMusic.floating_dream),
                    Map.entry("infinite_amethyst", DynamicMusic.config.musicSelector.niceMusic.infinite_amethyst),
                    Map.entry("left_to_bloom", DynamicMusic.config.musicSelector.niceMusic.left_to_bloom),
                    Map.entry("one_more_day", DynamicMusic.config.musicSelector.niceMusic.one_more_day),
                    Map.entry("stand_tall", DynamicMusic.config.musicSelector.niceMusic.stand_tall),
                    Map.entry("wending", DynamicMusic.config.musicSelector.niceMusic.wending),
                    Map.entry("13", DynamicMusic.config.musicSelector.niceMusic.thirteen),
                    Map.entry("cat", DynamicMusic.config.musicSelector.niceMusic.cat),
                    Map.entry("blocks", DynamicMusic.config.musicSelector.niceMusic.blocks),
                    Map.entry("chirp", DynamicMusic.config.musicSelector.niceMusic.chirp),
                    Map.entry("far", DynamicMusic.config.musicSelector.niceMusic.far),
                    Map.entry("mall", DynamicMusic.config.musicSelector.niceMusic.mall),
                    Map.entry("mellohi", DynamicMusic.config.musicSelector.niceMusic.mellohi),
                    Map.entry("stal", DynamicMusic.config.musicSelector.niceMusic.stal),
                    Map.entry("strad", DynamicMusic.config.musicSelector.niceMusic.strad),
                    Map.entry("ward", DynamicMusic.config.musicSelector.niceMusic.ward),
                    Map.entry("11", DynamicMusic.config.musicSelector.niceMusic.eleven),
                    Map.entry("wait", DynamicMusic.config.musicSelector.niceMusic.wait),
                    Map.entry("otherside", DynamicMusic.config.musicSelector.niceMusic.otherside),
                    Map.entry("5", DynamicMusic.config.musicSelector.niceMusic.five),
                    Map.entry("pigstep", DynamicMusic.config.musicSelector.niceMusic.pigstep)
            );
            case Down -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusic.config.musicSelector.downMusic.calm1),
                    Map.entry("calm2", DynamicMusic.config.musicSelector.downMusic.calm2),
                    Map.entry("calm3", DynamicMusic.config.musicSelector.downMusic.calm3),
                    Map.entry("creative1", DynamicMusic.config.musicSelector.downMusic.creative1),
                    Map.entry("creative2", DynamicMusic.config.musicSelector.downMusic.creative2),
                    Map.entry("creative3", DynamicMusic.config.musicSelector.downMusic.creative3),
                    Map.entry("creative4", DynamicMusic.config.musicSelector.downMusic.creative4),
                    Map.entry("creative5", DynamicMusic.config.musicSelector.downMusic.creative5),
                    Map.entry("creative6", DynamicMusic.config.musicSelector.downMusic.creative6),
                    Map.entry("hal1", DynamicMusic.config.musicSelector.downMusic.hal1),
                    Map.entry("hal2", DynamicMusic.config.musicSelector.downMusic.hal2),
                    Map.entry("hal3", DynamicMusic.config.musicSelector.downMusic.hal3),
                    Map.entry("hal4", DynamicMusic.config.musicSelector.downMusic.hal4),
                    Map.entry("nuance1", DynamicMusic.config.musicSelector.downMusic.nuance1),
                    Map.entry("nuance2", DynamicMusic.config.musicSelector.downMusic.nuance2),
                    Map.entry("piano1", DynamicMusic.config.musicSelector.downMusic.piano1),
                    Map.entry("piano2", DynamicMusic.config.musicSelector.downMusic.piano2),
                    Map.entry("piano3", DynamicMusic.config.musicSelector.downMusic.piano3),
                    Map.entry("an_ordinary_day", DynamicMusic.config.musicSelector.downMusic.an_ordinary_day),
                    Map.entry("comforting_memories", DynamicMusic.config.musicSelector.downMusic.comforting_memories),
                    Map.entry("floating_dream", DynamicMusic.config.musicSelector.downMusic.floating_dream),
                    Map.entry("infinite_amethyst", DynamicMusic.config.musicSelector.downMusic.infinite_amethyst),
                    Map.entry("left_to_bloom", DynamicMusic.config.musicSelector.downMusic.left_to_bloom),
                    Map.entry("one_more_day", DynamicMusic.config.musicSelector.downMusic.one_more_day),
                    Map.entry("stand_tall", DynamicMusic.config.musicSelector.downMusic.stand_tall),
                    Map.entry("wending", DynamicMusic.config.musicSelector.downMusic.wending),
                    Map.entry("13", DynamicMusic.config.musicSelector.downMusic.thirteen),
                    Map.entry("cat", DynamicMusic.config.musicSelector.downMusic.cat),
                    Map.entry("blocks", DynamicMusic.config.musicSelector.downMusic.blocks),
                    Map.entry("chirp", DynamicMusic.config.musicSelector.downMusic.chirp),
                    Map.entry("far", DynamicMusic.config.musicSelector.downMusic.far),
                    Map.entry("mall", DynamicMusic.config.musicSelector.downMusic.mall),
                    Map.entry("mellohi", DynamicMusic.config.musicSelector.downMusic.mellohi),
                    Map.entry("stal", DynamicMusic.config.musicSelector.downMusic.stal),
                    Map.entry("strad", DynamicMusic.config.musicSelector.downMusic.strad),
                    Map.entry("ward", DynamicMusic.config.musicSelector.downMusic.ward),
                    Map.entry("11", DynamicMusic.config.musicSelector.downMusic.eleven),
                    Map.entry("wait", DynamicMusic.config.musicSelector.downMusic.wait),
                    Map.entry("otherside", DynamicMusic.config.musicSelector.downMusic.otherside),
                    Map.entry("5", DynamicMusic.config.musicSelector.downMusic.five),
                    Map.entry("pigstep", DynamicMusic.config.musicSelector.downMusic.pigstep)
            );
        };
    }
}

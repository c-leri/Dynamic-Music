package net.celeri.dynmus.util;

import net.celeri.dynmus.DynamicMusic;
import net.celeri.dynmus.config.DynamicMusicConfig;
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
    private static final List<String> musicNamesCreative = List.of(
            "creative1", "creative2", "creative3", "creative4", "creative5", "creative6"
    );
    private static final List<String> musicNamesSurvival = List.of(
            "calm1", "calm2", "calm3",
            "hal1", "hal2", "hal3", "hal4",
            "nuance1", "nuance2",
            "piano1", "piano2", "piano3",
            "aerie", "ancestry", "an_ordinary_day",
            "comforting_memories", "firebugs", "floating_dream",
            "infinite_amethyst", "labyrinthine", "left_to_bloom",
            "one_more_day", "stand_tall", "wending"
    );

    private static Map<String, SoundEvent> getRecords() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        for (String recordName : recordNames) {
            out.put(recordName, new SoundEvent(new ResourceLocation("minecraft", "music_disc." + recordName)));
        }

        return out;
    }
    public static Map<String, SoundEvent> getCreativeMusic() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        for (String musicName : musicNamesCreative) {
            out.put(musicName, new SoundEvent(new ResourceLocation(DynamicMusic.MOD_ID, "music." + musicName)));
        }

        return out;
    }
    public static Map<String, SoundEvent> getSurvivalMusic() {
        Map<String, SoundEvent> out = new LinkedHashMap<>();

        for (String musicName : musicNamesSurvival) {
            out.put(musicName, new SoundEvent(new ResourceLocation(DynamicMusic.MOD_ID, "music." + musicName)));
        }

        return out;
    }

    public static List<SoundEvent> getToggledCreativeMusicForType(MusicType type) {
        Map<String, Boolean> musicToggles = getMusicTogglesForType(type);
        Map<String, SoundEvent> creativeMusic = DynamicMusicHelper.getCreativeMusic();
        creativeMusic.putAll(getSurvivalMusic());
        creativeMusic.putAll(getRecords());

        List<SoundEvent> out = new ArrayList<>();

        musicToggles.forEach((musicName, musicToggle) -> {
            if (creativeMusic.containsKey(musicName) && musicToggle)
                out.add(creativeMusic.get(musicName));
        });

        return out;
    }
    public static List<SoundEvent> getToggledSurvivalMusicForType(MusicType type) {
        Map<String, Boolean> musicToggles = getMusicTogglesForType(type);
        Map<String, SoundEvent> survivalMusic = DynamicMusicHelper.getSurvivalMusic();
        survivalMusic.putAll(getRecords());

        List<SoundEvent> out = new ArrayList<>();

        musicToggles.forEach((musicName, musicToggle) -> {
            if (survivalMusic.containsKey(musicName) && musicToggle)
                out.add(survivalMusic.get(musicName));
        });

        return out;
    }

    public static SoundEvent getRandomSoundEvent(List<SoundEvent> sounds) {
        return sounds.get(random.nextInt(sounds.size()));
    }

    private static Map<String, Boolean> getMusicTogglesForType(MusicType type) {
        return switch (type) {
            case Cave -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusicConfig.calm1Cave),
                    Map.entry("calm2", DynamicMusicConfig.calm2Cave),
                    Map.entry("calm3", DynamicMusicConfig.calm3Cave),
                    Map.entry("creative1", DynamicMusicConfig.creative1Cave),
                    Map.entry("creative2", DynamicMusicConfig.creative2Cave),
                    Map.entry("creative3", DynamicMusicConfig.creative3Cave),
                    Map.entry("creative4", DynamicMusicConfig.creative4Cave),
                    Map.entry("creative5", DynamicMusicConfig.creative5Cave),
                    Map.entry("creative6", DynamicMusicConfig.creative6Cave),
                    Map.entry("hal1", DynamicMusicConfig.hal1Cave),
                    Map.entry("hal2", DynamicMusicConfig.hal2Cave),
                    Map.entry("hal3", DynamicMusicConfig.hal3Cave),
                    Map.entry("hal4", DynamicMusicConfig.hal4Cave),
                    Map.entry("nuance1", DynamicMusicConfig.nuance1Cave),
                    Map.entry("nuance2", DynamicMusicConfig.nuance2Cave),
                    Map.entry("piano1", DynamicMusicConfig.piano1Cave),
                    Map.entry("piano2", DynamicMusicConfig.piano2Cave),
                    Map.entry("piano3", DynamicMusicConfig.piano3Cave),
                    Map.entry("aerie", DynamicMusicConfig.aerieCave),
                    Map.entry("ancestry", DynamicMusicConfig.ancestryCave),
                    Map.entry("an_ordinary_day", DynamicMusicConfig.an_ordinary_dayCave),
                    Map.entry("comforting_memories", DynamicMusicConfig.comforting_memoriesCave),
                    Map.entry("firebugs", DynamicMusicConfig.firebugsCave),
                    Map.entry("floating_dream", DynamicMusicConfig.floating_dreamCave),
                    Map.entry("infinite_amethyst", DynamicMusicConfig.infinite_amethystCave),
                    Map.entry("labyrinthine", DynamicMusicConfig.labyrinthineCave),
                    Map.entry("left_to_bloom", DynamicMusicConfig.left_to_bloomCave),
                    Map.entry("one_more_day", DynamicMusicConfig.one_more_dayCave),
                    Map.entry("stand_tall", DynamicMusicConfig.stand_tallCave),
                    Map.entry("wending", DynamicMusicConfig.wendingCave),
                    Map.entry("13", DynamicMusicConfig.thirteenCave),
                    Map.entry("cat", DynamicMusicConfig.catCave),
                    Map.entry("blocks", DynamicMusicConfig.blocksCave),
                    Map.entry("chirp", DynamicMusicConfig.chirpCave),
                    Map.entry("far", DynamicMusicConfig.farCave),
                    Map.entry("mall", DynamicMusicConfig.mallCave),
                    Map.entry("mellohi", DynamicMusicConfig.mellohiCave),
                    Map.entry("stal", DynamicMusicConfig.stalCave),
                    Map.entry("strad", DynamicMusicConfig.stradCave),
                    Map.entry("ward", DynamicMusicConfig.wardCave),
                    Map.entry("11", DynamicMusicConfig.elevenCave),
                    Map.entry("wait", DynamicMusicConfig.waitCave),
                    Map.entry("otherside", DynamicMusicConfig.othersideCave),
                    Map.entry("5", DynamicMusicConfig.fiveCave),
                    Map.entry("pigstep", DynamicMusicConfig.pigstepCave)
            );
            case Cold -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusicConfig.calm1Cold),
                    Map.entry("calm2", DynamicMusicConfig.calm2Cold),
                    Map.entry("calm3", DynamicMusicConfig.calm3Cold),
                    Map.entry("creative1", DynamicMusicConfig.creative1Cold),
                    Map.entry("creative2", DynamicMusicConfig.creative2Cold),
                    Map.entry("creative3", DynamicMusicConfig.creative3Cold),
                    Map.entry("creative4", DynamicMusicConfig.creative4Cold),
                    Map.entry("creative5", DynamicMusicConfig.creative5Cold),
                    Map.entry("creative6", DynamicMusicConfig.creative6Cold),
                    Map.entry("hal1", DynamicMusicConfig.hal1Cold),
                    Map.entry("hal2", DynamicMusicConfig.hal2Cold),
                    Map.entry("hal3", DynamicMusicConfig.hal3Cold),
                    Map.entry("hal4", DynamicMusicConfig.hal4Cold),
                    Map.entry("nuance1", DynamicMusicConfig.nuance1Cold),
                    Map.entry("nuance2", DynamicMusicConfig.nuance2Cold),
                    Map.entry("piano1", DynamicMusicConfig.piano1Cold),
                    Map.entry("piano2", DynamicMusicConfig.piano2Cold),
                    Map.entry("piano3", DynamicMusicConfig.piano3Cold),
                    Map.entry("aerie", DynamicMusicConfig.aerieCold),
                    Map.entry("ancestry", DynamicMusicConfig.ancestryCold),
                    Map.entry("an_ordinary_day", DynamicMusicConfig.an_ordinary_dayCold),
                    Map.entry("comforting_memories", DynamicMusicConfig.comforting_memoriesCold),
                    Map.entry("firebugs", DynamicMusicConfig.firebugsCold),
                    Map.entry("floating_dream", DynamicMusicConfig.floating_dreamCold),
                    Map.entry("infinite_amethyst", DynamicMusicConfig.infinite_amethystCold),
                    Map.entry("labyrinthine", DynamicMusicConfig.labyrinthineCold),
                    Map.entry("left_to_bloom", DynamicMusicConfig.left_to_bloomCold),
                    Map.entry("one_more_day", DynamicMusicConfig.one_more_dayCold),
                    Map.entry("stand_tall", DynamicMusicConfig.stand_tallCold),
                    Map.entry("wending", DynamicMusicConfig.wendingCold),
                    Map.entry("13", DynamicMusicConfig.thirteenCold),
                    Map.entry("cat", DynamicMusicConfig.catCold),
                    Map.entry("blocks", DynamicMusicConfig.blocksCold),
                    Map.entry("chirp", DynamicMusicConfig.chirpCold),
                    Map.entry("far", DynamicMusicConfig.farCold),
                    Map.entry("mall", DynamicMusicConfig.mallCold),
                    Map.entry("mellohi", DynamicMusicConfig.mellohiCold),
                    Map.entry("stal", DynamicMusicConfig.stalCold),
                    Map.entry("strad", DynamicMusicConfig.stradCold),
                    Map.entry("ward", DynamicMusicConfig.wardCold),
                    Map.entry("11", DynamicMusicConfig.elevenCold),
                    Map.entry("wait", DynamicMusicConfig.waitCold),
                    Map.entry("otherside", DynamicMusicConfig.othersideCold),
                    Map.entry("5", DynamicMusicConfig.fiveCold),
                    Map.entry("pigstep", DynamicMusicConfig.pigstepCold)
            );
            case Hot -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusicConfig.calm1Hot),
                    Map.entry("calm2", DynamicMusicConfig.calm2Hot),
                    Map.entry("calm3", DynamicMusicConfig.calm3Hot),
                    Map.entry("creative1", DynamicMusicConfig.creative1Hot),
                    Map.entry("creative2", DynamicMusicConfig.creative2Hot),
                    Map.entry("creative3", DynamicMusicConfig.creative3Hot),
                    Map.entry("creative4", DynamicMusicConfig.creative4Hot),
                    Map.entry("creative5", DynamicMusicConfig.creative5Hot),
                    Map.entry("creative6", DynamicMusicConfig.creative6Hot),
                    Map.entry("hal1", DynamicMusicConfig.hal1Hot),
                    Map.entry("hal2", DynamicMusicConfig.hal2Hot),
                    Map.entry("hal3", DynamicMusicConfig.hal3Hot),
                    Map.entry("hal4", DynamicMusicConfig.hal4Hot),
                    Map.entry("nuance1", DynamicMusicConfig.nuance1Hot),
                    Map.entry("nuance2", DynamicMusicConfig.nuance2Hot),
                    Map.entry("piano1", DynamicMusicConfig.piano1Hot),
                    Map.entry("piano2", DynamicMusicConfig.piano2Hot),
                    Map.entry("piano3", DynamicMusicConfig.piano3Hot),
                    Map.entry("aerie", DynamicMusicConfig.aerieHot),
                    Map.entry("ancestry", DynamicMusicConfig.ancestryHot),
                    Map.entry("an_ordinary_day", DynamicMusicConfig.an_ordinary_dayHot),
                    Map.entry("comforting_memories", DynamicMusicConfig.comforting_memoriesHot),
                    Map.entry("firebugs", DynamicMusicConfig.firebugsHot),
                    Map.entry("floating_dream", DynamicMusicConfig.floating_dreamHot),
                    Map.entry("infinite_amethyst", DynamicMusicConfig.infinite_amethystHot),
                    Map.entry("labyrinthine", DynamicMusicConfig.labyrinthineHot),
                    Map.entry("left_to_bloom", DynamicMusicConfig.left_to_bloomHot),
                    Map.entry("one_more_day", DynamicMusicConfig.one_more_dayHot),
                    Map.entry("stand_tall", DynamicMusicConfig.stand_tallHot),
                    Map.entry("wending", DynamicMusicConfig.wendingHot),
                    Map.entry("13", DynamicMusicConfig.thirteenHot),
                    Map.entry("cat", DynamicMusicConfig.catHot),
                    Map.entry("blocks", DynamicMusicConfig.blocksHot),
                    Map.entry("chirp", DynamicMusicConfig.chirpHot),
                    Map.entry("far", DynamicMusicConfig.farHot),
                    Map.entry("mall", DynamicMusicConfig.mallHot),
                    Map.entry("mellohi", DynamicMusicConfig.mellohiHot),
                    Map.entry("stal", DynamicMusicConfig.stalHot),
                    Map.entry("strad", DynamicMusicConfig.stradHot),
                    Map.entry("ward", DynamicMusicConfig.wardHot),
                    Map.entry("11", DynamicMusicConfig.elevenHot),
                    Map.entry("wait", DynamicMusicConfig.waitHot),
                    Map.entry("otherside", DynamicMusicConfig.othersideHot),
                    Map.entry("5", DynamicMusicConfig.fiveHot),
                    Map.entry("pigstep", DynamicMusicConfig.pigstepHot)
            );
            case Nice -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusicConfig.calm1Nice),
                    Map.entry("calm2", DynamicMusicConfig.calm2Nice),
                    Map.entry("calm3", DynamicMusicConfig.calm3Nice),
                    Map.entry("creative1", DynamicMusicConfig.creative1Nice),
                    Map.entry("creative2", DynamicMusicConfig.creative2Nice),
                    Map.entry("creative3", DynamicMusicConfig.creative3Nice),
                    Map.entry("creative4", DynamicMusicConfig.creative4Nice),
                    Map.entry("creative5", DynamicMusicConfig.creative5Nice),
                    Map.entry("creative6", DynamicMusicConfig.creative6Nice),
                    Map.entry("hal1", DynamicMusicConfig.hal1Nice),
                    Map.entry("hal2", DynamicMusicConfig.hal2Nice),
                    Map.entry("hal3", DynamicMusicConfig.hal3Nice),
                    Map.entry("hal4", DynamicMusicConfig.hal4Nice),
                    Map.entry("nuance1", DynamicMusicConfig.nuance1Nice),
                    Map.entry("nuance2", DynamicMusicConfig.nuance2Nice),
                    Map.entry("piano1", DynamicMusicConfig.piano1Nice),
                    Map.entry("piano2", DynamicMusicConfig.piano2Nice),
                    Map.entry("piano3", DynamicMusicConfig.piano3Nice),
                    Map.entry("aerie", DynamicMusicConfig.aerieNice),
                    Map.entry("ancestry", DynamicMusicConfig.ancestryNice),
                    Map.entry("an_ordinary_day", DynamicMusicConfig.an_ordinary_dayNice),
                    Map.entry("comforting_memories", DynamicMusicConfig.comforting_memoriesNice),
                    Map.entry("firebugs", DynamicMusicConfig.firebugsNice),
                    Map.entry("floating_dream", DynamicMusicConfig.floating_dreamNice),
                    Map.entry("infinite_amethyst", DynamicMusicConfig.infinite_amethystNice),
                    Map.entry("labyrinthine", DynamicMusicConfig.labyrinthineNice),
                    Map.entry("left_to_bloom", DynamicMusicConfig.left_to_bloomNice),
                    Map.entry("one_more_day", DynamicMusicConfig.one_more_dayNice),
                    Map.entry("stand_tall", DynamicMusicConfig.stand_tallNice),
                    Map.entry("wending", DynamicMusicConfig.wendingNice),
                    Map.entry("13", DynamicMusicConfig.thirteenNice),
                    Map.entry("cat", DynamicMusicConfig.catNice),
                    Map.entry("blocks", DynamicMusicConfig.blocksNice),
                    Map.entry("chirp", DynamicMusicConfig.chirpNice),
                    Map.entry("far", DynamicMusicConfig.farNice),
                    Map.entry("mall", DynamicMusicConfig.mallNice),
                    Map.entry("mellohi", DynamicMusicConfig.mellohiNice),
                    Map.entry("stal", DynamicMusicConfig.stalNice),
                    Map.entry("strad", DynamicMusicConfig.stradNice),
                    Map.entry("ward", DynamicMusicConfig.wardNice),
                    Map.entry("11", DynamicMusicConfig.elevenNice),
                    Map.entry("wait", DynamicMusicConfig.waitNice),
                    Map.entry("otherside", DynamicMusicConfig.othersideNice),
                    Map.entry("5", DynamicMusicConfig.fiveNice),
                    Map.entry("pigstep", DynamicMusicConfig.pigstepNice)
            );
            case Down -> Map.ofEntries(
                    Map.entry("calm1", DynamicMusicConfig.calm1Down),
                    Map.entry("calm2", DynamicMusicConfig.calm2Down),
                    Map.entry("calm3", DynamicMusicConfig.calm3Down),
                    Map.entry("creative1", DynamicMusicConfig.creative1Down),
                    Map.entry("creative2", DynamicMusicConfig.creative2Down),
                    Map.entry("creative3", DynamicMusicConfig.creative3Down),
                    Map.entry("creative4", DynamicMusicConfig.creative4Down),
                    Map.entry("creative5", DynamicMusicConfig.creative5Down),
                    Map.entry("creative6", DynamicMusicConfig.creative6Down),
                    Map.entry("hal1", DynamicMusicConfig.hal1Down),
                    Map.entry("hal2", DynamicMusicConfig.hal2Down),
                    Map.entry("hal3", DynamicMusicConfig.hal3Down),
                    Map.entry("hal4", DynamicMusicConfig.hal4Down),
                    Map.entry("nuance1", DynamicMusicConfig.nuance1Down),
                    Map.entry("nuance2", DynamicMusicConfig.nuance2Down),
                    Map.entry("piano1", DynamicMusicConfig.piano1Down),
                    Map.entry("piano2", DynamicMusicConfig.piano2Down),
                    Map.entry("piano3", DynamicMusicConfig.piano3Down),
                    Map.entry("aerie", DynamicMusicConfig.aerieDown),
                    Map.entry("ancestry", DynamicMusicConfig.ancestryDown),
                    Map.entry("an_ordinary_day", DynamicMusicConfig.an_ordinary_dayDown),
                    Map.entry("comforting_memories", DynamicMusicConfig.comforting_memoriesDown),
                    Map.entry("firebugs", DynamicMusicConfig.firebugsDown),
                    Map.entry("floating_dream", DynamicMusicConfig.floating_dreamDown),
                    Map.entry("infinite_amethyst", DynamicMusicConfig.infinite_amethystDown),
                    Map.entry("labyrinthine", DynamicMusicConfig.labyrinthineDown),
                    Map.entry("left_to_bloom", DynamicMusicConfig.left_to_bloomDown),
                    Map.entry("one_more_day", DynamicMusicConfig.one_more_dayDown),
                    Map.entry("stand_tall", DynamicMusicConfig.stand_tallDown),
                    Map.entry("wending", DynamicMusicConfig.wendingDown),
                    Map.entry("13", DynamicMusicConfig.thirteenDown),
                    Map.entry("cat", DynamicMusicConfig.catDown),
                    Map.entry("blocks", DynamicMusicConfig.blocksDown),
                    Map.entry("chirp", DynamicMusicConfig.chirpDown),
                    Map.entry("far", DynamicMusicConfig.farDown),
                    Map.entry("mall", DynamicMusicConfig.mallDown),
                    Map.entry("mellohi", DynamicMusicConfig.mellohiDown),
                    Map.entry("stal", DynamicMusicConfig.stalDown),
                    Map.entry("strad", DynamicMusicConfig.stradDown),
                    Map.entry("ward", DynamicMusicConfig.wardDown),
                    Map.entry("11", DynamicMusicConfig.elevenDown),
                    Map.entry("wait", DynamicMusicConfig.waitDown),
                    Map.entry("otherside", DynamicMusicConfig.othersideDown),
                    Map.entry("5", DynamicMusicConfig.fiveDown),
                    Map.entry("pigstep", DynamicMusicConfig.pigstepDown)
            );
        };
    }
}

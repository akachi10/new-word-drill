package org.akachi.practice.newworddrill.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/2 17:27
 */
@Component
public class DrillConfig {
    public static Float MAGNITUDE;
    public static Integer LOSE_MIN_COUNT;
    public static Integer LOSE_MAX_COUNT;
    public static String DRILL_DEFAULT_COMMAND;
    public static String DRILL_DEFAULT_FUNCTION;
    public static Integer DRILL_CRAWL_LENGTH;
    public static Integer DRILL_CRAWL_REPEAT;
    public static Integer DRILL_CRAWL_TIME;
    public static String FLAG;
    public static String SOUND_PREFIX;
    public static String SOUND_SUFFIX;
    public static Integer SOUND_WAIT;
    public static Integer INITIAL_SOUND_WAIT;
    public static String AUDIO_PATH;
    public static String JSON_PATH;
    public static String AUDIO_START;
    public static Integer AUDIO_START_TIME;
    public static Boolean AUDIO_START_PLAY;
    public static Integer AUDIO_PLAY_COUNT;
    public static String DICTIONARY_URL;
    public static String DICTIONARY_KEY;
    public static String DICTIONARY_KEYFROM;

    @Value("${drill.magnitude}")
    public void setMagnitude(Float MAGNITUDE) {
        DrillConfig.MAGNITUDE = MAGNITUDE;
    }

    @Value("${drill.loseMinCount}")
    public void setLoseMinCount(Integer LOSE_MIN_COUNT) {
        DrillConfig.LOSE_MIN_COUNT = LOSE_MIN_COUNT;
    }

    @Value("${drill.loseMaxCount}")
    public void setLoseMaxCount(Integer LOSE_MAX_COUNT) {
        DrillConfig.LOSE_MAX_COUNT = LOSE_MAX_COUNT;
    }

    @Value("${drill.default.command}")
    public void setDrillDefaultCommand(String DRILL_DEFAULT_COMMAND) {
        this.DRILL_DEFAULT_COMMAND = DRILL_DEFAULT_COMMAND;
    }

    @Value("${drill.default.function}")
    public void setDrillDefaultFunction(String DRILL_DEFAULT_FUNCTION) {
        this.DRILL_DEFAULT_FUNCTION = DRILL_DEFAULT_FUNCTION;
    }

    @Value("${drill.crawlLength}")
    public void setDrillCrawlLength(Integer DRILL_CRAWL_LENGTH) {
        this.DRILL_CRAWL_LENGTH = DRILL_CRAWL_LENGTH;
    }

    @Value("${drill.crawlRepeat}")
    public void setDrillCrawlRepeat(Integer DRILL_CRAWL_REPEAT) {
        this.DRILL_CRAWL_REPEAT = DRILL_CRAWL_REPEAT;
    }

    @Value("${drill.default.flag}")
    public void setFLAG(String flag) {
        this.FLAG = flag;
    }

    @Value("${drill.crawlTime}")
    public void setFLAG(Integer drillCrawlTime) {
        this.DRILL_CRAWL_TIME = drillCrawlTime;
    }

    @Value("${drill.sound.prefix}")
    public void setSOUND_PREFIX(String SOUND_PREFIX) {
        this.SOUND_PREFIX = SOUND_PREFIX;
    }

    @Value("${drill.sound.suffix}")
    public void setSOUND_SUFFIX(String SOUND_SUFFIX) {
        this.SOUND_SUFFIX = SOUND_SUFFIX;
    }

    @Value("${drill.audio.path}")
    public void setAUDIO_PATH(String AUDIO_PATH) {
        this.AUDIO_PATH = System.getProperty("user.dir") + AUDIO_PATH;
    }

    @Value("${drill.audio.json}")
    public void setJSON_PATH(String JSON_PATH) {
        this.JSON_PATH = System.getProperty("user.dir") + JSON_PATH;
    }

    @Value("${drill.sound.wait}")
    public void setSOUND_WAIT(Integer SOUND_WAIT) {
        this.SOUND_WAIT = SOUND_WAIT;
    }

    @Value("${drill.initial.sound.wait}")
    public void setINITIAL_SOUND_WAIT(Integer INITIAL_SOUND_WAIT) {
        this.INITIAL_SOUND_WAIT = INITIAL_SOUND_WAIT;
    }

    @Value("${drill.audio.start}")
    public void setAUDIO_START(String AUDIO_START) {
        this.AUDIO_START = AUDIO_START;
    }

    @Value("${drill.audio.start.time}")
    public void setAUDIO_START_TIME(Integer AUDIO_START_TIME) {
        this.AUDIO_START_TIME = AUDIO_START_TIME;
    }

    @Value("${drill.audio.start.play}")
    public void setAUDIO_START_PLAY(Boolean AUDIO_START_PLAY) {
        this.AUDIO_START_PLAY = AUDIO_START_PLAY;
    }

    @Value("${drill.audio.play.count}")
    public void setAUDIO_PLAY_COUNT(Integer AUDIO_PLAY_COUNT) {
        this.AUDIO_PLAY_COUNT = AUDIO_PLAY_COUNT;
    }

    @Value("${drill.word.explain.dictionary.url}")
    public void setDICTIONARY_URL(String DICTIONARY_URL) {
        this.DICTIONARY_URL = DICTIONARY_URL;
    }

    @Value("${drill.word.explain.dictionary.key}")
    public void setDICTIONARY_KEY(String DICTIONARY_KEY) {
        this.DICTIONARY_KEY = DICTIONARY_KEY;
    }

    @Value("${drill.word.explain.dictionary.keyfrom}")
    public void setDICTIONARY_KEYFROM(String DICTIONARY_KEYFROM) {
        this.DICTIONARY_KEYFROM = DICTIONARY_KEYFROM;
    }
}

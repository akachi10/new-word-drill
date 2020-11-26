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
    public static String BROWSER_PATH;
    public static String BROWSER;
    public static String SOUND;
    public static Integer SOUND_WAIT;

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
//
//    @Value("${drill.totalDrillCount}")
//    public void setTotalDrillCount(Integer TOTAL_DRILL_COUNT) {
//        DrillConfig.TOTAL_DRILL_COUNT = TOTAL_DRILL_COUNT;
//    }

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
        this.DRILL_CRAWL_TIME=drillCrawlTime;
    }

    @Value("${drill.browser.path}")
    public void setBROWSER_PATH(String BROWSER_PATH){
        this.BROWSER_PATH=BROWSER_PATH;
    }

    @Value("${drill.browser}")
    public void setBROWSER(String BROWSER){
        this.BROWSER=BROWSER;
    }

    @Value("${drill.sound}")
    public void setSOUND(String SOUND){
        this.SOUND=SOUND;
    }

    @Value("${drill.sound.wait}")
    public void setSOUND_WAIT(Integer SOUND_WAIT){
        this.SOUND_WAIT =SOUND_WAIT;
    }
}

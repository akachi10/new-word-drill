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
    public static Integer TOTAL_DRILL_COUNT;
    public static String DRILL_DEFAULT_COMMAND;
    public static String DRILL_DEFAULT_FUNCTION;

    @Value("${drill.magnitude}")
    public void setMAGNITUDE(Float MAGNITUDE) {
        DrillConfig.MAGNITUDE = MAGNITUDE;
    }

    @Value("${drill.loseMinCount}")
    public void setLOSE_MIN_COUNT(Integer LOSE_MIN_COUNT) {
        DrillConfig.LOSE_MIN_COUNT = LOSE_MIN_COUNT;
    }

    @Value("${drill.loseMaxCount}")
    public void setLOSE_MAX_COUNT(Integer LOSE_MAX_COUNT) {
        DrillConfig.LOSE_MAX_COUNT = LOSE_MAX_COUNT;
    }

    @Value("${drill.totalDrillCount}")
    public void setTOTAL_DRILL_COUNT(Integer TOTAL_DRILL_COUNT) {
        DrillConfig.TOTAL_DRILL_COUNT = TOTAL_DRILL_COUNT;
    }

    @Value("${drill.default.command}")
    public void setDRILL_DEFAULT_COMMAND(String DRILL_DEFAULT_COMMAND) {
        this.DRILL_DEFAULT_COMMAND = DRILL_DEFAULT_COMMAND;
    }

    @Value("${drill.default.function}")
    public void setDRILL_DEFAULT_FUNCTIO(String DRILL_DEFAULT_FUNCTION) {
        this.DRILL_DEFAULT_FUNCTION = DRILL_DEFAULT_FUNCTION;
    }


}

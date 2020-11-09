package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.config.DrillConfig;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/2 17:48
 */
public class TestCommand extends AbstractCommand {


    @Override
    public String introduce() {
        return "测试命令="+DrillConfig.FLAG;
    }

    public void testConfig(){
        System.out.println("LOSE_MAX_COUNT:"+ DrillConfig.LOSE_MAX_COUNT+
                ";LOSE_MIN_COUNT:"+DrillConfig.LOSE_MIN_COUNT+
                ";MAGINTUDE:"+DrillConfig.MAGNITUDE);
    }
}

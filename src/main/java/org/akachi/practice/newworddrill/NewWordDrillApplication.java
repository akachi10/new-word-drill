package org.akachi.practice.newworddrill;

import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.command.MainCommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
public class NewWordDrillApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("程序实际上的入口在这里。");*/
        Class clazz = Class.forName("org.akachi.practice.newworddrill.command.operate." + DrillConfig.DRILL_DEFAULT_COMMAND + "Command");
        try {
            Method method = clazz.getMethod(DrillConfig.DRILL_DEFAULT_FUNCTION);
            method.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            System.out.println("[MainCommand]:'DRILL_DEFAULT_FUNCTION'未设置，系统不会自动启动测试。");
        }

        ICommand ic = new MainCommand();
        ic.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(NewWordDrillApplication.class, args);
    }

}

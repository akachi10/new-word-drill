package org.akachi.practice.newworddrill;

import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.command.MainCommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewWordDrillApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("程序实际上的入口在这里。");*/
        ICommand ic = new MainCommand();
        ic.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(NewWordDrillApplication.class, args);
    }

}

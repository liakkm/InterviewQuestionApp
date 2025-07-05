package com.lia.pjd;

import com.lia.pjd.cli.CommandLineInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final CommandLineInterface commandLineInterface;

    public Main(CommandLineInterface commandLineInterface) {
        this.commandLineInterface = commandLineInterface;
    }

    public static void main(String[] args) {
//        ObjectInitializer objectInitializer = new ObjectInitializer();
//
//        objectInitializer.run();
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello");
        commandLineInterface.init();
    }
}
package com.gluzdev04.music_manager_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicManagerSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MusicManagerSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

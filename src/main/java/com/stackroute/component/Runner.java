package com.stackroute.component;

import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    MusicService musicService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("rutuja");
    }
}

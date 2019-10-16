package com.stackroute.components;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {
    private MusicService musicService;
    @Autowired
    public Listener(MusicService musicService){
        this.musicService = musicService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            musicService.saveTrack(new Music(45, "Listener", "comment"));
        } catch (MusicAlreadyExistsException muzixAlreadyExists) {
            try {
                Music music = new Music();
                musicService.UpdateComments(45,"comments");
            } catch (TrackNotFoundException e) {
                System.out.println("Exceptions Thrown");
            }

        }
    }
}


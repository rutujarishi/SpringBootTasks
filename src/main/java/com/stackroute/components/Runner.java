package com.stackroute.components;
import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner {
    private MusicService musicService;
    @Value("${in.trackName:me}")
    private String trackName;
    @Value("${in.trackComments:me2}")
    private String trackcomment;
    public Runner(@Autowired MusicService musicService) {
        this.musicService = musicService;
    }
    @Override
    public void run(String... args) throws MusicAlreadyExistsException {
        System.out.println(trackName);
        Music music = new Music(3330, trackName, trackcomment);
        try {

            musicService.saveTrack(music);
            System.out.println("here");
        } catch (MusicAlreadyExistsException muzixAlreadyExists) {
            System.out.println("Exception thrown");
        }
    }
}

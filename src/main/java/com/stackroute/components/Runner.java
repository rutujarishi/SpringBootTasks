package com.stackroute.components;
import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner {
    private MusicService muzixService;
    @Value("${trackName}")
    private String name;
    @Value("${trackComments}")
    private String comment;
    public Runner(@Autowired MusicService muzixService) {
        this.muzixService = muzixService;
    }
    @Override
    public void run(String... args) throws MusicAlreadyExistsException {

        Music music = new Music(3330, name, comment);
        try {

            muzixService.saveTrack(music);
            System.out.println("here");
        } catch (MusicAlreadyExistsException muzixAlreadyExists) {
            System.out.println("Exception thrown");
        }
    }
}

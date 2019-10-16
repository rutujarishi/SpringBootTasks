package com.stackroute.controller;


import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {
    private MusicService musicService;
    private Environment environment;

    public MusicController(@Autowired MusicService musicService, @Autowired Environment environment) {
        this.musicService = musicService;
        this.environment = environment;
    }

//    @RequestMapping("/error")
//    public String error() throws Exception {
//        throw new Exception();
//    }

    @PostMapping("/music")
    public ResponseEntity saveUser(@RequestBody Music track) throws MusicAlreadyExistsException {
        if (track.getTrackName() == null) {
            track.setTrackName(environment.getProperty("trackName"));
        }
        ResponseEntity responseEntity;

        responseEntity = new ResponseEntity<>(musicService.saveTrack(track), HttpStatus.OK);
//        } catch (MusicAlreadyExistsException ex) {
//            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//        }

        return responseEntity;
    }

    @GetMapping("/getAllTracks")
    public ResponseEntity getAllTracks() {
        return new ResponseEntity<>(musicService.getAllTracks(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{trackId}")
    public ResponseEntity deleteTrack(@PathVariable int trackId) throws TrackNotFoundException {
        ResponseEntity responseEntity;

            responseEntity = new ResponseEntity<>(musicService.deleteTrack(trackId), HttpStatus.OK);
//        } catch (TrackNotFoundException e) {
//            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity UpdateComments(@RequestBody Music music) {
        return new ResponseEntity<>(
                musicService.UpdateComments(
                        music.getTrackId(),
                        music.getTrackComments()),
                HttpStatus.OK);
    }

    @GetMapping("/findName/{trackName}")
    public ResponseEntity findTitleByName(@PathVariable String trackName) {
        return new ResponseEntity<>(
                musicService.findTitleByName(trackName),
                HttpStatus.OK);
    }
}

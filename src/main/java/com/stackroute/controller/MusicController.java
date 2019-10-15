package com.stackroute.controller;


import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {

    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }


    @PostMapping("/music")
    public ResponseEntity saveUser(@RequestBody Music track) {
        ResponseEntity responseEntity;
        try {

            responseEntity = new ResponseEntity<>(musicService.saveTrack(track), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/getAllTracks")
    public ResponseEntity getAllTracks() {
        return new ResponseEntity<>(musicService.getAllTracks(), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public  ResponseEntity  deleteTrack( @RequestBody int trackId)
    {
        ResponseEntity responseEntity;
        try {
        responseEntity =new ResponseEntity<>(musicService.deleteTrack(trackId),HttpStatus.OK);
    }
catch (Exception ex){
    responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("/update/{trackId}")

    public ResponseEntity UpdateComments(@RequestBody String trackcomments,int trackId){

        ResponseEntity responseEntity;
        try {
        responseEntity= new ResponseEntity<>(musicService.UpdateComments(trackId,trackcomments), HttpStatus.OK);
    }
        catch (Exception ex){
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


}

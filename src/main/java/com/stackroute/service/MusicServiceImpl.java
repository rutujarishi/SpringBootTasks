package com.stackroute.service;

import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.respository.MusicRepository;
import com.stackroute.domain.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
@Profile("prod")
public class MusicServiceImpl implements MusicService {

    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository)
    {
        this.musicRepository=musicRepository;
    }

    @Override
    public Music saveTrack(Music track)throws MusicAlreadyExistsException{
        System.out.println("enter the serviceimpl");
        if(musicRepository.existsById(track.getTrackId()))
        {
            throw new MusicAlreadyExistsException("Already Exist");
        }
        track =  musicRepository.save(track);
        if(track==null){
            throw  new MusicAlreadyExistsException("Track Already Exists");
        }

      return track;
    }

    @Override
    public List<Music> getAllTracks() {

        return  musicRepository.findAll();

    }

    @Override
    public boolean UpdateComments(int trackId,String trackComments) throws TrackNotFoundException {
        if(!(musicRepository.existsById(trackId)))
        {
            throw new TrackNotFoundException("Not Found");
        }
       Music music = musicRepository.getOne(trackId);
       music.setTrackComments(trackComments);
       musicRepository.save(music);
        return true;
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        if(!(musicRepository.existsById(trackId)))
        {
            throw new TrackNotFoundException("Not Found");
        }
        musicRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Music> findTitleByName(String trackName) {
       List<Music> list= musicRepository.findTitleByName(trackName);
        return  list;
    }
}

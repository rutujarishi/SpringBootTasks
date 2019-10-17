package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.respository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("dev")
public class TrackDummyServiceImpl implements MusicService {

    private MusicRepository musicRepository;

    @Autowired
    public TrackDummyServiceImpl(MusicRepository musicRepository)
    {
        System.out.println("Constructor is called");
        this.musicRepository=musicRepository;
    }

    @Override
    public Music saveTrack(Music track)throws MusicAlreadyExistsException {
        System.out.println("Enter the track dummy impl");
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
        System.out.println("Enter the track dummy impl");

        return  musicRepository.findAll();

    }

    @Override
    public boolean UpdateComments(int trackId,String trackComments) throws TrackNotFoundException {
        System.out.println("Enter the track dummy impl");
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
        System.out.println("Enter the track dummy impl");
        if(!(musicRepository.existsById(trackId)))
        {
            throw new TrackNotFoundException("Not Found");
        }
        musicRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Music> findTitleByName(String trackName) {
        System.out.println("Enter the track dummy impl");
        List<Music> list= musicRepository.findTitleByName(trackName);
        return  list;
    }
}

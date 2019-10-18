package com.stackroute.service;

import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.respository.MusicRepository;
import com.stackroute.domain.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {


    private MusicRepository musicRepository;
    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository)
    { this.musicRepository=musicRepository;}
    @Override
    public Music saveTrack(Music track)throws MusicAlreadyExistsException{
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
    public boolean UpdateComments(String trackId,String trackComments) {
       Music music = musicRepository.findById(trackId).get();
       music.setTrackComments(trackComments);
       musicRepository.save(music);
        return true;
    }

    @Override
    public Music deleteTrack(Music music) throws TrackNotFoundException {

            if(!(musicRepository.existsById(music.getTrackId())))
            {
                throw new TrackNotFoundException("Not Found");
            }
            Music music1 = new Music();
            music1.setTrackId(music.getTrackId());
            music1.setTrackName(music.getTrackName());
            music1.setTrackComments(music.getTrackComments());
            musicRepository.deleteById(music.getTrackId());
            return music1;
    }

    @Override
    public List<Music> findTitleByName(String trackName) {
//        List<Music> list= musicRepository.findTitleByName(trackName);
        return  new ArrayList<>();
    }


//    @Override
//    public List<Music> findTitleByName(String trackName) {
//       List<Music> list= musicRepository.findTitleByName(trackName);
//        return  list;
//    }
}

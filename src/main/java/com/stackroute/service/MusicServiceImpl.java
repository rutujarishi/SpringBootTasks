package com.stackroute.service;

import com.stackroute.respository.MusicRepository;
import com.stackroute.domain.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {


    private MusicRepository musicRepository;
    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository)
    { this.musicRepository=musicRepository;}
    @Override
    public Music saveTrack(Music track) {
      return musicRepository.save(track);
    }

    @Override
    public List<Music> getAllTracks() {
        return musicRepository.findAll();

    }

    @Override
    public boolean UpdateComments(int trackId,String trackComments) {
       Music music = musicRepository.getOne(trackId);
       music.setTrackComments(trackComments);
       musicRepository.save(music);
        return true;
    }

    @Override
    public boolean deleteTrack(int trackId) {
        musicRepository.deleteById(trackId);
        return true;
    }
}

package com.stackroute.service;

import com.stackroute.domain.Music;

import java.util.List;

public interface MusicService {
    public Music saveTrack(Music track);
    public List<Music> getAllTracks();
    public boolean UpdateComments(int trackId,String trackComments);
    public boolean deleteTrack(int trackId);
}

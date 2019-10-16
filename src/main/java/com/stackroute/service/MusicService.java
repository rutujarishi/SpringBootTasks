package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicService {
    public Music saveTrack(Music track) throws MusicAlreadyExistsException;
    public List<Music> getAllTracks();
    public boolean UpdateComments(int trackId,String trackComments);
    public boolean deleteTrack(int trackId) throws TrackNotFoundException;
    public List<Music> findTitleByName(String trackName);
}

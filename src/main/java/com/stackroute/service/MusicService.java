package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicService {
    public Music saveTrack(Music track) throws MusicAlreadyExistsException;
    public List<Music> getAllTracks();
    public boolean UpdateComments(String trackId,String trackComments)throws TrackNotFoundException;
    public Music deleteTrack(Music music) throws TrackNotFoundException;
    public List<Music> findTitleByName(String trackName);
}

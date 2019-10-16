package com.stackroute.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Configuration
@PropertySource(value = "classpath:application.properties")
@Component
public class Music {
    @Id
//    @Value("${trackId}")
    private int trackId;
//    @Value("${trackName:John}")
    private String trackName;
    @Value("${trackComments:Nice}")
    private String trackComments;

    public Music() {
//        this.trackId = Integer.parseInt(environment.getProperty("trackId"));
    }

    public Music(int trackId, String trackName, String trackComments) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackComments = trackComments;
    }


    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        System.out.println(this.trackId);
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }


    @Override
    public String toString() {
        return "Music{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComments='" + trackComments + '\'' +
                '}';
    }


}

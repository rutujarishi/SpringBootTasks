package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.lang.annotation.Documented;
import java.util.Objects;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    @Id
//    @Value("${in.trackId}")
    private String trackId;
//    @Value("${in.trackName}")
    private String trackName;
  //  @Value("${in.trackComments}")
    private String trackComments;



}

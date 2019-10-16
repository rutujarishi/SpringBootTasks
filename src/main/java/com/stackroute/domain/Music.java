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
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Configuration
//@PropertySource(value = "classpath:application.properties")
//@Component
public class Music {
    @Id
//    @Value("${trackId}")
    private int trackId;
//    @Value("${trackName:John}")
    private String trackName;
  //  @Value("${trackComments:Nice}")
    private String trackComments;



}

package com.stackroute.respository;


import com.stackroute.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository  extends JpaRepository<Music,Integer> {
    @Query(value = "SELECT m FROM Music m where m.trackName = :name")
    List<Music> findTitleByName(@Param("name") String name);
}

package com.stackroute.repository;


import com.stackroute.domain.Music;

import com.stackroute.respository.MusicRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository userRepository;
    private Music user;

    @Before
    public void setUp()
    {
        user = new Music();
        user.setTrackId("101");
        user.setTrackName("Johny");

        user.setTrackComments("Jenny");

    }

    @After
    public void tearDown(){

        userRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        userRepository.save(user);
        Music fetchUser = userRepository.findById(user.getTrackId()).get();
        Assert.assertEquals("101",fetchUser.getTrackId());

    }

    @Test
    public void testSaveUserFailure(){
        Music testUser = new Music("34","Harry","Johny");
        userRepository.save(user);
        Music fetchUser = userRepository.findById(user.getTrackId()).get();
        Assert.assertNotSame(testUser,user);
    }

    @Test
    public void testGetAllUser(){
        Music u = new Music("10","Johny","Jenny");
        Music u1 = new Music("11","Harry","Jenny");
        userRepository.save(u);
        userRepository.save(u1);

        List<Music> list = userRepository.findAll();
        Assert.assertEquals("Johny",list.get(0).getTrackName());




    }


}
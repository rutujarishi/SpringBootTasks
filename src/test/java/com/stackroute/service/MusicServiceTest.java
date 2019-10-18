package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.MusicAlreadyExistsException;

import com.stackroute.respository.MusicRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MusicServiceTest {
    private Music user;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository userRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl userService;
    List<Music> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new Music();
        user.setTrackComments("John");
        user.setTrackId("101");
        user.setTrackName("Jenny");

        list = new ArrayList<>();
        list.add(user);


    }

    @Test
    public void saveUserTestSuccess() throws MusicAlreadyExistsException {

        when(userRepository.save((Music) any())).thenReturn(user);
        Music savedUser = userService.saveTrack(user);
        Assert.assertEquals(user,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = MusicAlreadyExistsException.class)
    public void saveUserTestFailure() throws MusicAlreadyExistsException{
        when(userRepository.save((Music) any())).thenReturn(null);
        Music savedUser = userService.saveTrack(user);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        userRepository.save(user);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<Music> userlist = userService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }





}
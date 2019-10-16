package com.stackroute.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice("com.stackroute")
public class AdviceController {
    @ExceptionHandler(MusicAlreadyExistsException.class)
    public ResponseEntity<Object>
    myMessage(MusicAlreadyExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<Object>
    myMessage(TrackNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> myMessage(Exception e){
        return new ResponseEntity<>("Internal Server Error",HttpStatus.CONFLICT);
    }
}



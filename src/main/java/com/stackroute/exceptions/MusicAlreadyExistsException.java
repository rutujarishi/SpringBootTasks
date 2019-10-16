package com.stackroute.exceptions;

public class MusicAlreadyExistsException extends Exception {
      private String message;

    public MusicAlreadyExistsException() {
    }
    public MusicAlreadyExistsException(String message) {
        super(message);
        this.message=message;
    }


}

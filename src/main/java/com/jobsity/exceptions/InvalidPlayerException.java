package com.jobsity.exceptions;

public class InvalidPlayerException extends GameException{
    public InvalidPlayerException(String name){
        super("Player " + name + " is not allowed to play now, first round has already been closed");
    }
}

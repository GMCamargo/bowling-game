package com.jobsity.exceptions;

public class InvalidPlayerTurnException extends GameException{
    public InvalidPlayerTurnException(String name){
        super("It's not " + name + "'s turn");
    }
}

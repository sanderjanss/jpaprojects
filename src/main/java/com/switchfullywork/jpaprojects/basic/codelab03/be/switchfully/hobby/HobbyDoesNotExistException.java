package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby;

public class HobbyDoesNotExistException extends RuntimeException{

    public HobbyDoesNotExistException(String message) {
        super(message);
    }
}

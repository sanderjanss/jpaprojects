package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby;

public class HobbyDoesExistException extends RuntimeException {

    public HobbyDoesExistException(String message) {
        super(message);
    }
}

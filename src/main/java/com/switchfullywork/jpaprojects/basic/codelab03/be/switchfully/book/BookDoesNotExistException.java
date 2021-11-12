package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book;


public class BookDoesNotExistException  extends RuntimeException{

    public BookDoesNotExistException(String message) {
        super(message);
    }
}

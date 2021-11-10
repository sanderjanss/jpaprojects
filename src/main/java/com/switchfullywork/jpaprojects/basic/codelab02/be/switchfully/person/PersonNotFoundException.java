package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;


import javax.persistence.NoResultException;

public class PersonNotFoundException extends NoResultException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}

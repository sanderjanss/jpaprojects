package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;
}

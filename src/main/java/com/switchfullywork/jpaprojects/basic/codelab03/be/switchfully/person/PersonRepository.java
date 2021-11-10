package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person){
        entityManager.persist(person);
    }

    public Person findByName(String lastName){
        return entityManager.createQuery("select p from Person p where p.lastName = :lastName", Person.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
    }
}

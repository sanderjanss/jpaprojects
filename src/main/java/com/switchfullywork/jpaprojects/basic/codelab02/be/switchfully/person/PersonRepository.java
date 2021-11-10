package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    public Person findPerson(String firstName) throws PersonNotFoundException {
        try {
            return entityManager.createQuery("select p from Person p where p.firstName = :firstName", Person.class)
                    .setParameter("firstName", firstName)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre) {
            throw new PersonNotFoundException("Trying to retrieve a person with first name: '" + firstName + "', but this person is not part of the db.");
        }
    }

    public void removePerson(Person person){
        entityManager.remove(person);
    }

}

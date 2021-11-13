package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person.PersonNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findPersonByName(String lastName){
        try{
            return entityManager.createQuery("select p from Person p where p.lastName = :lastName", Person.class)
                    .setParameter("lastName", lastName)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre ){
            return null;
        }

    }

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public Person findPerson(int id) {
        return entityManager.find(Person.class, id);
    }
}

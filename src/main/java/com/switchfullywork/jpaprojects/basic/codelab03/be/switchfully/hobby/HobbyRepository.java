package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class HobbyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveHobby(Hobby hobby){
        entityManager.persist(hobby);
    }

    public void findHobby(int id){
        entityManager.find(Hobby.class, id);
    }

    public Hobby findHobbyByName(String name){
        try {
            return entityManager.createQuery("select h from Hobby h where h.name = :name", Hobby.class)
                    .setParameter("name", name)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre){
            return null;
        }
    }
}

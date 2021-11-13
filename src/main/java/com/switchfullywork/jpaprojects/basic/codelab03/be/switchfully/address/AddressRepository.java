package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveAddress(Address address){
        entityManager.persist(address);
    }
}





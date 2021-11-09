package com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.country;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CountryRepository() {
    }

    public List<Country> getAllCountries() {
        return entityManager.createQuery("select c from Country c", Country.class).getResultList();
    }

    public Country getCountryById(String countryId){
        return entityManager.createQuery("select c from Country c where c.countryId = :countryId", Country.class)
                .setParameter("countryId", countryId)
                .getSingleResult();
    }

    public Country getCountryByName(String countryName){
        return entityManager.createQuery("select c from Country c where c.countryName = :countryName", Country.class)
                .setParameter("countryName", countryName)
                .getSingleResult();
    }
}

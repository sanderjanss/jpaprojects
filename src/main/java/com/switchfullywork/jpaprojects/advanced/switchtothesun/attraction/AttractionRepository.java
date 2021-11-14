package com.switchfullywork.jpaprojects.advanced.switchtothesun.attraction;


import com.switchfullywork.jpaprojects.advanced.switchtothesun.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AttractionRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Attraction> getAllAttractions() {
//        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name from attraction a join COUNTRY c on a.FK_COUNTRY_ID = c.ID", toAttractionMapper());
        return entityManager.createQuery("select a from Attraction a", Attraction.class)
                .getResultList();
    }

//    public List<Attraction> findAttractionsOfType(String type) {
//        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name from attraction a join COUNTRY c on a.FK_COUNTRY_ID = c.ID where type = ?", toAttractionMapper(), type);
//    }
//
//    public List<Attraction> findAttractionsInCountry(String country) {
//        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name from attraction a join country c on a.FK_COUNTRY_ID = c.ID where c.NAME = ?", toAttractionMapper(), country);
//    }
//
//    private RowMapper<Attraction> toAttractionMapper() {
//        return (row, rowNum) -> new Attraction(
//                row.getString("attraction_name"),
//                row.getString(""),
//                new Country(row.getString("country_name")));
//    }
}

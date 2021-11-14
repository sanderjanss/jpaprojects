package com.switchfullywork.jpaprojects.advanced.switchtothesun.attraction;


import com.switchfullywork.jpaprojects.advanced.switchtothesun.country.Country;

import javax.persistence.*;

@Entity
@Table(name = "attraction")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "fk_country_id")
    private Country country;

    public Attraction() {
    }

    public Attraction(String name, Country country, String type) {
        this.name = name;
        this.country = country;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        return name + " - " + type + " - " + country;
    }
}

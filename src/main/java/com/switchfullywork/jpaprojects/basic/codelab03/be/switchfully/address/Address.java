package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_address_id_seq", sequenceName = "address_address_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name = "region")
    private String region;
    @Column(name = "zip_code")
    private int zipCode;
    @OneToOne(mappedBy = "address")
    private Person person;

    public Address(String streetName, int houseNumber, String region, int zipCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.region = region;
        this.zipCode = zipCode;
    }

    public Address(String streetName, int houseNumber, String region, int zipCode, Person person) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.region = region;
        this.zipCode = zipCode;
        this.person = person;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getRegion() {
        return region;
    }

    public int getZipCode() {
        return zipCode;
    }

    public Person getPerson() {
        return person;
    }

    public Address setPerson(Person person) {
        this.person = person;
        return this;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}

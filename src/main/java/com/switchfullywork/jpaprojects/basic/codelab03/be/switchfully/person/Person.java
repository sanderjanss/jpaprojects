package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.Address;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.Hobby;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fav_color")
    private String favouriteColor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    public Person() {

    }

    public Person(String firstName, String lastName, String favouriteColor, Address address, Hobby hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favouriteColor = favouriteColor;
        this.address = address;
        this.hobby = hobby;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public int getId() {
        return id;
    }

    public void addHobby(Hobby hobby){
        this.hobby = hobby;
    }

    public Hobby getHobby() {
        return hobby;
    }
}

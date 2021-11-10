package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fav_color")
    private String color;

    public Person(String firstName, String lastName, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
    }

    public Person() {
    }

    public void paint(String color){
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

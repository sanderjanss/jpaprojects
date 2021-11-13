package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.Address;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book.Book;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.Hobby;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fav_color")
    private String favouriteColor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Book> bookList;

    public Person() {

    }

    public Person(String firstName, String lastName, String favouriteColor, Address address, Hobby hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favouriteColor = favouriteColor;
        this.address = address;
        this.hobby = hobby;
        this.bookList = new ArrayList<>();
    }

    public Person(String firstName, String lastName, String favouriteColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favouriteColor = favouriteColor;
        this.bookList = new ArrayList<>();
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addHobby(Hobby hobby){
        this.hobby = hobby;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book){
        bookList.add(book);
    }
}

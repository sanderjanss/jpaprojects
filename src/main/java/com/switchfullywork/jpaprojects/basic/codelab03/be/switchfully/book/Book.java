package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "title")
    private String title;
    @Column(name= "author")
    private String author;

    @ManyToMany(mappedBy = "bookList", fetch = FetchType.EAGER)
    private List<Person> persons;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;

    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPersonToBook(Person person){
        persons.add(person);
    }

//    @Override
//    public String toString(){
//        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
//    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

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


    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}

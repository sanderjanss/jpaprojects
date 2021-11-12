package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findBookByTitle(String title) {
        try {
            return entityManager.createQuery("select b from Book b where b.title = :title", Book.class)
                    .setParameter("title", title)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Book> findBooksStartingWith(String title){
        try {
            return entityManager.createQuery("select b from Book b where b.title like :title", Book.class)
                    .setParameter("title", title + "%")
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void removeBook(Book book){
        entityManager.remove(book);
    }

    public void removeAllBooks(List<Book> books){
        for (Book book: books             ) {
            entityManager.remove(book);
        }
    }
}

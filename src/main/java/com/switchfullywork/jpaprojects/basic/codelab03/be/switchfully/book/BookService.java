package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.PersonRepository;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.PersonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    private final PersonService personService;

    public BookService(BookRepository bookRepository, PersonRepository personRepository, PersonService personService) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.personService = personService;
    }

    public void saveBook(Book book){
        bookRepository.saveBook(book);
    }

    public void addBookToAPerson(String lastName, String title) throws RuntimeException{
        Book availableBook = bookRepository.findBookByTitle(title);
        Person person = personRepository.findPersonByName(lastName);
        assertBookExists(availableBook);
        personService.assertPersonExists(person);
        person.addBook(availableBook);
        availableBook.addPersonToBook(person);
    }

    public void removeBook(String title){
        Book book = bookRepository.findBookByTitle(title);
        assertBookExists(book);
        bookRepository.removeBook(book);
    }

    public void removeAllBooks(String title){
        List<Book> books = bookRepository.findBooksStartingWith(title);
        bookRepository.removeAllBooks(books);
    }

    private void assertBookExists(Book book) {
        if (book == null) {
            throw new BookDoesNotExistException("Not a valid book");
        }
    }

}

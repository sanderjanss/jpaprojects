package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book.Book;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.book.BookService;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApp implements CommandLineRunner {

    private final BookService bookService;
    public final Logger logger = LoggerFactory.getLogger(BookApp.class);

    public BookApp(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        bookService.saveBook(new Book("Bello Gallico", "Julius Caesar"));
//        bookService.saveBook(new Book("De steen der wijzen", "JK Rowling"));
//        bookService.saveBook(new Book("The name of the wind", "Patrick Rothfuss"));
//        try {
//            bookService.addBookToAPerson("Hanssens", "a");
//        } catch (RuntimeException re){
//            logger.warn(re.getMessage());
//        }
//        try {
//        bookService.removeBook("De steen der wijzen");
//        } catch (RuntimeException re){
//            logger.warn(re.getMessage());
//        }

//        bookService.saveBook(new Book("a1", "Patrick Rothfuss"));
//        bookService.saveBook(new Book("a2", "Patrick Rothfuss"));
//        bookService.saveBook(new Book("a3", "Patrick Rothfuss"));

        bookService.removeAllBooks("a");
    }
}

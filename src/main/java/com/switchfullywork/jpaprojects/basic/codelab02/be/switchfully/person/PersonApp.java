package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.CountryApp;
import com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.country.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApp implements CommandLineRunner {
    private final PersonService personService;

    public PersonApp(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
//            personService.addPerson(new Person("Jack", "Janssens", "Blue"));
//            personService.updatePerson("Sander", "Geel");
            personService.removePerson("Jack");

        } catch (PersonNotFoundException pnf){
            System.err.println(pnf.getMessage());
        }
    }
}

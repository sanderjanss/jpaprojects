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

//        personService.addPerson(new Person("Jack", "Janssens", "Blue"));
//        try{
//            System.out.println(personService.findPerson("Bram"));
//        } catch (PersonNotFoundException pnf){
//            System.err.println(pnf.getMessage());
//        }
//        try{
//            personService.updatePerson("Sander", "Geel");
//        } catch (PersonNotFoundException pnf){
//            System.err.println(pnf.getMessage());
//        }
        try{
            personService.removePerson("Sander");
        } catch (PersonNotFoundException pnf){
            System.err.println(pnf.getMessage());
        }
    }
}

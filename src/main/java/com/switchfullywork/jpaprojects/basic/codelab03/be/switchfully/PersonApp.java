package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.Address;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.Hobby;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApp implements CommandLineRunner {

    private final PersonService personService;
    public final Logger logger = LoggerFactory.getLogger(PersonApp.class);

    public PersonApp(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        personService.savePerson(new Person(
//                "Jonas", "Hanssens", "Rood",
//                new Address("Meir", 4, "Antwerpen", 2000),
//                new Hobby("Basketball", "BallSport")));
//        System.out.println(personService.findPersonByName("Janssens"));
//        personService.addHobbyToPerson(5, "Basketball");
//        System.out.println(personService.findPersonByName("Hanssens"));
    }
}

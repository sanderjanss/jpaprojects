package com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        personRepository.addPerson(person);
    }

    public Person findPerson(String firstName){
        return personRepository.findPerson(firstName);
    }

    public void updatePerson(String firstName, String color){
        Person person = personRepository.findPerson(firstName);
        person.paint(color);
    }
    public void removePerson(String firstName){
        Person person = personRepository.findPerson(firstName);
        personRepository.removePerson(person);
    }
}

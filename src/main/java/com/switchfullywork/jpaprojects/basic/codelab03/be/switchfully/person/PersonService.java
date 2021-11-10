package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void addPerson(Person person){
        personRepository.save(person);
    }

    public Person findByName(String lastName){
        return personRepository.findByName(lastName);
    }
}

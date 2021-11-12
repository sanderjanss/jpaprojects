package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.Hobby;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyDoesNotExistException;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final HobbyRepository hobbyRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, HobbyRepository hobbyRepository) {
        this.personRepository = personRepository;
        this.hobbyRepository = hobbyRepository;
    }


    public void addPerson(Person person){
        Hobby hobby = hobbyRepository.findHobbyByName(person.getHobby().getName());
        person.addHobby(hobby);
        personRepository.save(person);
    }

    public Person findByName(String lastName){
        return personRepository.findByName(lastName);
    }

    public void addHobbyToPerson(int id, String hobbyName){
       Person person = personRepository.findPerson(id);
       Hobby hobby = hobbyRepository.findHobbyByName(hobbyName);
       if(hobby != null){
           person.addHobby(hobby);
       }
       else {
           throw new HobbyDoesNotExistException("Hobby does not exist.");
       }
    }
}

package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person;

import com.switchfullywork.jpaprojects.basic.codelab02.be.switchfully.person.PersonNotFoundException;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.Address;
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


    public void savePerson(Person person){
        Hobby hobby = hobbyRepository.findHobbyByName(person.getHobby().getName());
        person.addHobby(hobby);
        personRepository.savePerson(person);
    }

    public Person findPersonByName(String lastName){
        return personRepository.findPersonByName(lastName);
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

    public void assertPersonExists(Person person) {
        if (person == null){
            throw new PersonNotFoundException("Not a valid person");
        }
    }
}

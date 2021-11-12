package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public void createAddress(Address address) {
        addressRepository.addAddress(address);
        Person person = address.getPerson();
        person.setAddress(address);
        personRepository.save(person);
    }
}


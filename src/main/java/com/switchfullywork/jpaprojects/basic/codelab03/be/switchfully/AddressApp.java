package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.Address;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.address.AddressService;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressApp implements CommandLineRunner {

    private final AddressService addressService;
    public final Logger logger = LoggerFactory.getLogger(BookApp.class);

    public AddressApp(AddressService addressService) {
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AddressApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
//    addressService.saveAddress(new Address("WinnerStreet", 1, "Brussel", 2000,
//            new Person("Jack", "Russel", "Groen")));
    }
}

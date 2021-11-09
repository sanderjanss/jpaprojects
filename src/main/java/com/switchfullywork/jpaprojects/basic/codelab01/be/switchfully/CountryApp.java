package com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully;

import com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.country.Country;
import com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.country.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class CountryApp implements CommandLineRunner {

    private final CountryRepository countryRepository;

    public CountryApp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CountryApp.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        countryRepository.getAllCountries().forEach(System.out::println);
        System.out.println(countryRepository.getCountryById("IT"));
        System.out.println(countryRepository.getCountryByName("Japan"));
    }
}

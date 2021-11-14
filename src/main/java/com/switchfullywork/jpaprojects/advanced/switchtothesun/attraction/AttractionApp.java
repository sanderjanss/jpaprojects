package com.switchfullywork.jpaprojects.advanced.switchtothesun.attraction;

import com.switchfullywork.jpaprojects.advanced.switchtothesun.SwitchToTheSun;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AttractionApp implements CommandLineRunner {

    private final AttractionService attractionService;

    public AttractionApp(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SwitchToTheSun.class);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Attraction> attractionList = attractionService.getAllAttractions();

        for (Attraction attraction : attractionList) {
            System.out.println(attraction);
        }
    }
}

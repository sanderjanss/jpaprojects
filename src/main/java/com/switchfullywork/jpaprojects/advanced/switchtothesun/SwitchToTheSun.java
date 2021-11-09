package com.switchfullywork.jpaprojects.advanced.switchtothesun;

import advanced.switchtothesun.commandreader.CommandReader;
import advanced.switchtothesun.commandreader.handler.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

import static java.util.Arrays.asList;

@SpringBootApplication
public class SwitchToTheSun {

    public static void main(String[] args) {
        SpringApplication.run(SwitchToTheSun.class);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public CommandReader commandReader(Scanner scanner, ReportHandler reportHandler, AddCountryHandler addCountryHandler, RemoveCountryHandler removeCountryHandler, FindAttractionsInCountryHandler findAttractionsInCountryHandler, FindAttractionsWithTypeHandler findAttractionsWithTypeHandler) {
        return new CommandReader(scanner, asList(
                reportHandler,
                addCountryHandler,
                removeCountryHandler,
                findAttractionsInCountryHandler,
                findAttractionsWithTypeHandler
        ));
    }
}

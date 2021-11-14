package com.switchfullywork.jpaprojects.advanced.switchtothesun.commandreader.handler;


import com.switchfullywork.jpaprojects.advanced.switchtothesun.attraction.AttractionRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAttractionsWithTypeHandler implements Handler {

    private AttractionRepository attractionRepository;

    public FindAttractionsWithTypeHandler(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public boolean canHandle(String prefix) {
        return prefix.startsWith("find attractions with");
    }

    @Override
    public void handle(String parameter) {
        System.out.println("Finding attractions of type " + parameter);
//        attractionRepository.findAttractionsOfType(parameter).forEach(System.out::println);
    }
}

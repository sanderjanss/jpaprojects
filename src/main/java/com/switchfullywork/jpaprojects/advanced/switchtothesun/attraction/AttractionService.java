package com.switchfullywork.jpaprojects.advanced.switchtothesun.attraction;

import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions(){
        return attractionRepository.getAllAttractions();
    }
}



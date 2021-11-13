package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public void saveHobby(Hobby createHobby) throws HobbyDoesExistException{
            Hobby hobby = hobbyRepository.findHobbyByName(createHobby.getName());
        if(hobby != null){
            throw new HobbyDoesExistException("Hobby does allready exist.");
        }
        else {
            hobbyRepository.saveHobby(createHobby);
        }
    }
}

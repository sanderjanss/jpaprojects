package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully;

import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.Hobby;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyDoesExistException;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyDoesNotExistException;
import com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby.HobbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HobbyApp implements CommandLineRunner {

    private final HobbyService hobbyService;
    public final Logger logger = LoggerFactory.getLogger(HobbyApp.class);

    public HobbyApp(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HobbyApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        try {
//            hobbyService.createHobby(new Hobby("Tetris", "E-sport"));
//        } catch (HobbyDoesExistException hdne){
//            logger(hdne.getMessage());
//        }
    }
}

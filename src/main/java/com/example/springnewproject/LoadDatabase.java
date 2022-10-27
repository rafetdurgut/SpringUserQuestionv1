package com.example.springnewproject;

import com.example.springnewproject.model.Question;
import com.example.springnewproject.model.User;
import com.example.springnewproject.repository.QuestionRepository;
import com.example.springnewproject.repository.UserRepository;
import com.example.springnewproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, QuestionRepository questionRepository) {

        return args -> {
            User u = new User("rdurgut","Rafet","Durgut","123456","rdurgut@gmail.com");
            for(int i=0;i<100;i++)
            {
                User u4 = new User("rdurgut","Rafet","Durgut","123456","rdurgut@gmail.com");
                repository.save(u4);
            }
            User u2 = new User("asaydam","Ahmet","Saydam","123456","rdsurgut@gmail.com");
            log.info("Preloading " + repository.save(u));
            log.info("Preloading " + repository.save(new User("test","test","test","test","test@gmail.com")));
            log.info("Preloading " + repository.save(u2));
            log.info("Preloading " + questionRepository.save(new Question("Test title", "Test content",u)));
            log.info("Preloading " + questionRepository.save(new Question("Test title 2", "Test content 2", u2 )));
        };
    }

}

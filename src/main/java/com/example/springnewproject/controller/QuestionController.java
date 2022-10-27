package com.example.springnewproject.controller;

import com.example.springnewproject.LoadDatabase;
import com.example.springnewproject.exception.NotFoundException;
import com.example.springnewproject.model.Question;
import com.example.springnewproject.model.User;
import com.example.springnewproject.repository.QuestionRepository;
import com.example.springnewproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    public final UserRepository rep;

    public final QuestionRepository questionRepository;
    QuestionController(UserRepository uRep, QuestionRepository qRep)
    {
        this.rep = uRep;
        this.questionRepository = qRep;
    }
    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Question> getQuestion(@PathVariable Long id)
    {
        Optional<Question> q = questionRepository.findById(id);
        if(q.isPresent())
            return  ResponseEntity.ok(q.get());
        throw new NotFoundException("Question not found!");
    }


}

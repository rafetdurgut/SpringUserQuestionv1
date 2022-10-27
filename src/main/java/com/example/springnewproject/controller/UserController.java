package com.example.springnewproject.controller;


import com.example.springnewproject.dtos.UserDTO;
import com.example.springnewproject.exception.UserNotFoundException;
import com.example.springnewproject.model.Question;
import com.example.springnewproject.model.User;
import com.example.springnewproject.repository.QuestionRepository;
import com.example.springnewproject.repository.UserRepository;
import com.example.springnewproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    public final UserService userService;

    public final QuestionRepository questionRepository;

    public UserController(UserService userService,QuestionRepository questionRepository) {
        this.userService = userService;
        this.questionRepository = questionRepository;
    }

    /*@GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id)
    {
        UserDTO user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO u)
    {
        userService.saveUser(u);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<List<Question>> getAllQuestionFromUser(@PathVariable Long id)
    {
        List<Question> questions = questionRepository.findByUserId(id);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getUserByPage(@RequestParam(defaultValue = "0") int offset, @RequestParam(required = false, defaultValue = "10") int size)
    {
        return  ResponseEntity.ok(userService.userListByPage(offset,size));
    }

}

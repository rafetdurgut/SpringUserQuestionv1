package com.example.springnewproject.repository;

import com.example.springnewproject.model.Question;
import com.example.springnewproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByEmail(String email);


}

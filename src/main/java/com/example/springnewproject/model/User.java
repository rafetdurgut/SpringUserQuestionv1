package com.example.springnewproject.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {

    private @Id @GeneratedValue Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDate lastLogin;
    private LocalDateTime createdAt;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Question> questionList;
    public User(String userName, String firstName, String lastName, String password, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
}

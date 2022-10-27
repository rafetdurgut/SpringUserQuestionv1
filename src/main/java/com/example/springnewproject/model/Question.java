package com.example.springnewproject.model;

import com.example.springnewproject.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String message;
    private Status status;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore

    private User user;


    public Question(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
        this.status = Status.APPROVAL;
    }
}

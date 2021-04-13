package com.haoshan.featurecontrolapi.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String email;

    public User(){

    }

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }
}

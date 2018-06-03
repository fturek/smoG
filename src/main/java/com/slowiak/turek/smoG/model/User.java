package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<UserCity> userCities;

    public User() {
    }

    public User(String username, String password, String email, String role, List<UserCity> userCities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.userCities = userCities;
    }
}

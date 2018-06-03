package com.slowiak.turek.smoG.controller;

import com.slowiak.turek.smoG.model.User;
import com.slowiak.turek.smoG.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return userRepository.getUserByUserId(id);
    }

    @PostMapping("/users")
    public HttpStatus registerNewUser(@RequestBody User user){
        User userByEmail = userRepository.getUserByEmail(user.getEmail());
        User userByUsername = userRepository.getUserByUsername(user.getUsername());
        if(userByEmail != null && userByUsername != null){
            userRepository.save(user);
            return HttpStatus.OK;
        }
        return HttpStatus.CONFLICT;
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUser(@PathVariable Integer id){
        User userByUserId = userRepository.getUserByUserId(id);
        if(userByUserId != null){
            userRepository.delete(userByUserId);
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_FOUND;
    }

}
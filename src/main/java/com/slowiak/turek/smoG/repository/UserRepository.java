package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserId(Integer id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}

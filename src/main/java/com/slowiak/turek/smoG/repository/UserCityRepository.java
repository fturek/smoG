package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.User;
import com.slowiak.turek.smoG.model.UserCity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCityRepository extends JpaRepository<UserCity, Integer>{
    List<UserCity> getUserCitiesByUser(User user);
    UserCity getUserCityByCityId(Integer id);
}

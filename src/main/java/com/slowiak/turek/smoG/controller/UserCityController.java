package com.slowiak.turek.smoG.controller;

import com.slowiak.turek.smoG.model.User;
import com.slowiak.turek.smoG.model.UserCity;
import com.slowiak.turek.smoG.repository.UserCityRepository;
import com.slowiak.turek.smoG.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCityController {
    private UserRepository userRepository;
    private UserCityRepository userCityRepository;

    @Autowired
    public UserCityController(UserRepository userRepository, UserCityRepository userCityRepository) {
        this.userRepository = userRepository;
        this.userCityRepository = userCityRepository;
    }

    @GetMapping("/users/{id}/cities")
    public List<UserCity> getCitiesForUserId(@PathVariable Integer id) {
        User userByUserId = userRepository.getUserByUserId(id);
        if (userByUserId != null) {
            return userCityRepository.getUserCitiesByUser(userByUserId);
        }
        return null;
    }

    @PostMapping("/users/{userId}/{cityId}")
    public HttpStatus addCityForUser(@PathVariable Integer userId, @PathVariable Integer cityId){
        User userByUserId = userRepository.getUserByUserId(userId);
        if(userByUserId != null){
            boolean isCityInUserCitiesList = userByUserId.getUserCities().stream().anyMatch(user -> user.getCityId().equals(cityId));
            if (isCityInUserCitiesList){
                return HttpStatus.BAD_REQUEST;
            }else{
                UserCity userCity = new UserCity(userByUserId, cityId);
                userCityRepository.save(userCity);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.NOT_FOUND;
    }

    @DeleteMapping("/users/{userId}/{cityId}")
    public HttpStatus deleteCityFromUser(@PathVariable Integer userId, @PathVariable Integer cityId){
        User userByUserId = userRepository.getUserByUserId(userId);
        if (userByUserId != null){
            UserCity userCityByCityId = userCityRepository.getUserCityByCityId(cityId);
            if(userCityByCityId != null){
                userCityRepository.delete(userCityByCityId);
                return HttpStatus.OK;
            }
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.NOT_FOUND;
    }

}

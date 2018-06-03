package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    City getCityById(int id);
}

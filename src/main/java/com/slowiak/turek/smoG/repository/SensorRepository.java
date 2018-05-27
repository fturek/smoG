package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer>{
}

package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.Station;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationsRepository extends JpaRepository<Station, Integer> {
}

package com.slowiak.turek.smoG.database;

import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.StationsRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StationDatabase {

    private StationsRepository stationsRepository;

    @Autowired
    public StationDatabase(StationsRepository stationsRepository) {
        this.stationsRepository = stationsRepository;
    }

    @GetMapping("/test")
    public List<Station> getStationsFromDatabase(){
        System.out.println(stationsRepository);
        return stationsRepository.findAll();
    }
}

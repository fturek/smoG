package com.slowiak.turek.smoG.database;

import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StationDatabase {

    @Autowired
    private StationsRepository stationsRepository;


    public List<Station> getStationsFromDatabase(){
        return stationsRepository.getAll();

    }
}

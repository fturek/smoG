package com.slowiak.turek.smoG.controller;

import com.slowiak.turek.smoG.model.City;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.CitiesRepository;
import com.slowiak.turek.smoG.repository.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitiesController {

    private CitiesRepository citiesRepository;
    private StationsRepository stationsRepository;

    @Autowired
    public CitiesController(CitiesRepository citiesRepository, StationsRepository stationsRepository) {
        this.citiesRepository = citiesRepository;
        this.stationsRepository = stationsRepository;
    }

    @GetMapping(value = "/cities/{id}/allStations")
    public List<Station> getAllStationsByCityId(@PathVariable(value = "id") int cityId) {

        City cityById = citiesRepository.getCityById(cityId);

        if (cityById != null) {
            List<Station> stationsForSpecificCity = stationsRepository.getStationsByCityId(cityId);

            if ( stationsForSpecificCity != null){
                return stationsForSpecificCity;
            }

        }
        return null;
    }

    @GetMapping(value = "/cities/mostPolluted")
    public List<Station> getMostPuluted(
            @RequestParam(name = "amount") int ammount,
            @RequestParam(name = "by") String by
    ) {


        return null;
    }
}

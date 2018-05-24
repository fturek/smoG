package com.slowiak.turek.smoG.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.utils.JSONReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StationService {

    public List<Station> getStationsFromAPI(){
        JSONReader jsonReader = new JSONReader();
        List<Station> stationList = null;
        try {
            String jsonText = jsonReader.readJsonFromUrl(Constants.allStationsURL);

            ObjectMapper objectMapper = new ObjectMapper();
            stationList = objectMapper.readValue(jsonText, new TypeReference<List<Station>>() {
            });
        } catch (IOException e) {
            // TODO Log handled error
            e.printStackTrace();
        }

        return stationList;
    };
}

package com.slowiak.turek.smoG.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.Sensor;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.utils.JSONReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {

    public List<Sensor> getSensorsFromAPI() {
        JSONReader jsonReader = new JSONReader();
        List<Sensor> sensorList = new ArrayList<>();

        try {
            String stations = jsonReader.readJsonFromUrl(Constants.allStationsURL);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Station> stationList = objectMapper.readValue(stations, new TypeReference<List<Station>>() {
            });
            System.out.println(stationList.size());
            for (Station s : stationList) {
                System.out.println("Downloading sensors for station with id: " + s.getId());
                String stationSensors = jsonReader.readJsonFromUrl(Constants.sensorsWithStationIdURL + s.getId());
                List<Sensor> sensorsFromStation = objectMapper.readValue(stationSensors, new TypeReference<List<Sensor>>() {
                });
                sensorList.addAll(sensorsFromStation);
                for (Sensor sensor : sensorsFromStation) {
                    System.out.println("\t" + sensor.getId() + " " + sensor.getStationId() + " "
                            + sensor.getParam().getParamCode() + " "
                            + sensor.getParam().getParamName() + " "
                            + sensor.getParam().getId());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensorList;
    }
}

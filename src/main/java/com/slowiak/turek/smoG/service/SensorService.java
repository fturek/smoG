package com.slowiak.turek.smoG.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.Sensor;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.StationsRepository;
import com.slowiak.turek.smoG.utils.JSONReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private StationsRepository stationsRepository;

    public SensorService(StationsRepository stationsRepository) {
        this.stationsRepository = stationsRepository;
    }

    public List<Sensor> getSensorsFromAPI() {
        JSONReader jsonReader = new JSONReader();
        List<Sensor> sensorList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Integer> stationIds = stationsRepository.findAll().stream().map(Station::getId).collect(Collectors.toList());
            System.out.println(stationIds.size());
            for (Integer stationId : stationIds) {
                System.out.println("Downloading sensors for station with id: " + stationId);
                String stationSensors = jsonReader.readJsonFromUrl(Constants.sensorsWithStationIdURL + stationId);
                List<Sensor> sensorsFromStation = objectMapper.readValue(stationSensors, new TypeReference<List<Sensor>>() {
                });
                sensorList.addAll(sensorsFromStation);
                for (Sensor sensor : sensorsFromStation) {
                    System.out.println("\t" + sensor.getId() + " " + sensor.getStationId() + " "
                            + sensor.getParam().getParamCode() + " "
                            + sensor.getParam().getParamName() + " "
                            + sensor.getParam().getIdParam());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sensorList;
    }
}

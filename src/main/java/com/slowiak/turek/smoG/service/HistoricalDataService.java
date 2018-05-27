package com.slowiak.turek.smoG.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.HistoricalData;
import com.slowiak.turek.smoG.model.Sensor;
import com.slowiak.turek.smoG.repository.SensorRepository;
import com.slowiak.turek.smoG.utils.JSONReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricalDataService {

    private SensorRepository sensorRepository;

    public HistoricalDataService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<HistoricalData> getHistoricalData() {
        JSONReader jsonReader = new JSONReader();
        List<HistoricalData> historicalData = new ArrayList<>();


        List<Sensor> sensorList = sensorRepository.findAll();
        List<Integer> sensorListIds = sensorList.stream().map(sensor -> sensor.getId()).collect(Collectors.toList());

        for (Integer sensorId : sensorListIds) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonText = jsonReader.readJsonFromUrl(Constants.historicalDataURL + sensorId);

                HistoricalData temporaryHistoricalData = objectMapper.readValue(jsonText, new TypeReference<HistoricalData>() {});
                temporaryHistoricalData.setSensor_id(sensorId);
                historicalData.add(temporaryHistoricalData);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return historicalData;
    }

    ;
}

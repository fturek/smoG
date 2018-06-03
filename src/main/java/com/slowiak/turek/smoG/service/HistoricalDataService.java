package com.slowiak.turek.smoG.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.HistoricalData;
import com.slowiak.turek.smoG.model.HistoricalDataTemplate;
import com.slowiak.turek.smoG.model.Sensor;
import com.slowiak.turek.smoG.model.Values;
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
        List<HistoricalData> historicalDataList = new ArrayList<>();

        List<Sensor> sensorList = sensorRepository.findAll();
        List<Integer> sensorListIds = sensorList.stream().map(Sensor::getId).collect(Collectors.toList());

        for (Integer sensorId : sensorListIds) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonText = jsonReader.readJsonFromUrl(Constants.historicalDataURL + sensorId);

                HistoricalDataTemplate historicalDataTemplate = objectMapper.readValue(jsonText, new TypeReference<HistoricalDataTemplate>() {});
                List<Values> valuesList = historicalDataTemplate.getValues();

                for ( Values values : valuesList ){
                    HistoricalData historicalData = new HistoricalData();
                    historicalData.setKey(historicalDataTemplate.getKey());
                    historicalData.setDate(values.getDate());
                    historicalData.setValue(values.getValue());
                    historicalData.setSensor_id(sensorId);
                    historicalDataList.add(historicalData);
                }

                System.out.println("dupa");
                //break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return historicalDataList;
    }
}

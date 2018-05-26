package com.slowiak.turek.smoG;

import com.slowiak.turek.smoG.constant.Constants;
import com.slowiak.turek.smoG.model.Sensor;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.StationsRepository;
import com.slowiak.turek.smoG.service.SensorService;
import com.slowiak.turek.smoG.service.StationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SmoGApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SmoGApplication.class, args);

        /*
        StationService stationService = (StationService) ctx.getBean("stationService");
        StationsRepository stationsRepository = (StationsRepository) ctx.getBean("stationsRepository");
        List<Station> stationsFromAPI = stationService.getStationsFromAPI();
        stationsRepository.saveAll(stationsFromAPI);
        */

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(Constants.threadAmmount);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("schedule");
//            StationService stationService = (StationService) ctx.getBean("stationService");
//            StationsRepository stationsRepository = (StationsRepository) ctx.getBean("stationsRepository");
//            List<Station> stationsFromAPIList = stationService.getStationsFromAPI();
//            System.out.println("start");
//            stationsRepository.saveAll(stationsFromAPIList);
//            System.out.println("stop");
//        }, Constants.allStationsDelayDays, Constants.allStationsPeriodDays, TimeUnit.DAYS);

        // For sensor service test
//        SensorService sensorService = (SensorService) ctx.getBean("sensorService");
//        List<Sensor> sensorsFromAPI = sensorService.getSensorsFromAPI();
    }
}

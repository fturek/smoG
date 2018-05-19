package com.slowiak.turek.smoG;

import com.slowiak.turek.smoG.database.StationDatabase;
import com.slowiak.turek.smoG.model.Station;
import com.slowiak.turek.smoG.repository.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SmoGApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SmoGApplication.class, args);

//        Wypisanie istniejacych beanow rozpoznanych przez springa
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        StationDatabase stationDatabase = (StationDatabase) ctx.getBean("stationDatabase");
        List<Station> all = stationDatabase.getStationsFromDatabase();
        all.forEach(System.out::println);
    }
}

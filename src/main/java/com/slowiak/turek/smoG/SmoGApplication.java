package com.slowiak.turek.smoG;

import com.slowiak.turek.smoG.database.StationDatabase;
import com.slowiak.turek.smoG.model.Station;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SmoGApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoGApplication.class, args);


		StationDatabase stationDatabase = new StationDatabase();
		List<Station> stationsFromDatabase = stationDatabase.getStationsFromDatabase();
		stationsFromDatabase.stream().forEach(station -> System.out.println(station.getStationName()));
	}
}

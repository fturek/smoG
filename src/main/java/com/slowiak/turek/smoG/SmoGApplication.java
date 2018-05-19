package com.slowiak.turek.smoG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmoGApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoGApplication.class, args);


//		StationDatabase stationDatabase = new StationDatabase();
//		List<Station> stationsFromDatabase = stationDatabase.getStationsFromDatabase();
//		stationsFromDatabase.forEach(station -> System.out.println(station.getStationName()));
	}
}

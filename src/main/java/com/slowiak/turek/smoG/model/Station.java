package com.slowiak.turek.smoG.model;

import lombok.Data;

@Data
public class Station {
    private final int id;
    private final String stationName;
    private final String gegrLat;
    private final String gegrLon;
    private final City city;
    private final String addressStreet;
}

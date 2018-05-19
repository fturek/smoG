package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "measuring_stations")
public class Station {

    @Id
    @Column(name = "station_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;

    @Column(name = "station_name")
    private final String stationName;

    @Column(name = "gegr_lat")
    private final String gegrLat;

    @Column(name = "gegr_lon")
    private final String gegrLon;

    @OneToMany(mappedBy = "city_id")
    private final City city;

    @Column(name = "address_street")
    private final String addressStreet;
}

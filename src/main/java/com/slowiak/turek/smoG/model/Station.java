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
    private int id;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "gegr_lat")
    private String gegrLat;

    @Column(name = "gegr_lon")
    private String gegrLon;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "address_street")
    private String addressStreet;
}

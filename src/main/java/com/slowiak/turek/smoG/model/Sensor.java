package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "measuring_sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private int id;

    @Column(name = "station_id")
    private int stationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "param_id")
    private Param param;
}

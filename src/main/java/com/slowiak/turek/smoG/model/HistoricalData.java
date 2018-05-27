package com.slowiak.turek.smoG.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "historical_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoricalData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sensor_id")
    private int sensor_id;

    @Column(name = "key")
    private String key;

    @Embedded
    @ElementCollection(targetClass = Values.class)
    private List<Values> values;
}

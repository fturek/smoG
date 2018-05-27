package com.slowiak.turek.smoG.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "historical_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoricalData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sensor_id")
    private Integer sensor_id;

    @Column(name = "my_key")
    private String key;

    @Embedded
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Values> values;
}

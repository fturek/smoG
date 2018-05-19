package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;

    @Column(name = "name")
    private final String name;

    @Column(name = "commune")
    private final Commune commune;
}

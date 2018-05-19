package com.slowiak.turek.smoG.model;

import lombok.Data;

@Data
public class City {
    private final int id;
    private final String name;
    private final Commune commune;
}

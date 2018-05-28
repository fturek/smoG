package com.slowiak.turek.smoG.model;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalDataTemplate {

    private String key;

    private List<Values> values;
}

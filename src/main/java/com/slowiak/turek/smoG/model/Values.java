package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
public class Values {

    private String date;

    private BigDecimal value;
}

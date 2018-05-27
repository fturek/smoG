package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Embeddable
public class Values {

    @Column(name = "my_date")
    private String date;

    @Column(name = "my_value")
    private BigDecimal value;

}

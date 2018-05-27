package com.slowiak.turek.smoG.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//
@Data
//@Entity
//@Table(name = "historical_data")
@Embeddable
public class Values {

//    @Id
//    @Column(name = "value_id")
//    private int value_id;

    @Column(name = "date", unique = true)
    private String date;

    @Column(name = "value")
    private BigDecimal value;

}

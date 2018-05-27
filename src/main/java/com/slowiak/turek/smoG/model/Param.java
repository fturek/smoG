package com.slowiak.turek.smoG.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "params")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Param {
    @Id
    @Column(name = "param_id")
    private int idParam;

    @Column(name = "param_name")
    private String paramName;

    @Column(name = "param_code")
    private String paramCode;
}

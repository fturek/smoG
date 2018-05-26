package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "params")
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "param_id")
    private int id;

    @Column(name = "param_name")
    private String paramName;

    @Column(name = "param_code")
    private String paramCode;
}

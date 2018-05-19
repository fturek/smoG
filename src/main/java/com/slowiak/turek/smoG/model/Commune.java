package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table( name = "communes")
public class Commune {

    @Column(name = "commune_name")
    private final String communeName;

    @Column(name = "district_name")
    private final String districtName;

    @Column(name = "province_name")
    private final String provinceName;
}

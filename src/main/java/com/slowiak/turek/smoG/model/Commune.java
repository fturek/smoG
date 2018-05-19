package com.slowiak.turek.smoG.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "communes")
public class Commune {

    @Id
    @Column(name = "commune_name")
    private String communeName;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "province_name")
    private String provinceName;
}

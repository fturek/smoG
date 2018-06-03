package com.slowiak.turek.smoG.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_cities")
public class UserCity {
    @Id
    @GeneratedValue
    @Column(name = "user_city_id")
    private Integer userCityId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "city_id")
    private Integer cityId;

    public UserCity() {
    }

    public UserCity(User user, Integer cityId) {
        this.user = user;
        this.cityId = cityId;
    }
}

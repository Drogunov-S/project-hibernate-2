package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "country")
    private String country;
    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

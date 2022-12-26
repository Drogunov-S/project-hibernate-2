package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "city")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id")
    private Integer Id;
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    
}

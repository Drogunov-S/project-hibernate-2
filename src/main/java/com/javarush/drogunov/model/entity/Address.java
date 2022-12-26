package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "address2")
    private String address2;
    
    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    
    @Column(name = "postal_code")
    private String postalCode;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

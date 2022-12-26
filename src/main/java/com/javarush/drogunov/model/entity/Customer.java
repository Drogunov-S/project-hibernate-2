package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    @Column(name = "active")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;
    
    @Column(name = "create_date")
    private Timestamp createDate;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

}

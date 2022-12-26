package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rental")
public class Rental {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private Integer id;
    
    @Column(name = "rental_date")
    private Timestamp rentalDate;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @Column(name = "return_date")
    private Timestamp returnDate;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

}

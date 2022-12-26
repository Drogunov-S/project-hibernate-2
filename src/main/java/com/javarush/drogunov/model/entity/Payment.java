package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @Column(name = "payment_date")
    private Timestamp paymentDate;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

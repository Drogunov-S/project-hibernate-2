package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "inventory")
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventory_id")
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

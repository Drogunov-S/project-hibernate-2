package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "language")
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "language_id")
    private Integer languageId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

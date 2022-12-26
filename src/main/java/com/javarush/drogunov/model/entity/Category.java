package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    )
    private List<Film> films;
    @Column(name = "last_update")
    @Basic(fetch = FetchType.EAGER)
    private Timestamp lastUpdate;
}

package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "actor")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "actor_id")
    private Integer actorId;
    
    @Column(name = "first_name")
    private String firstName;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    )
    private List<Film> films;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

}

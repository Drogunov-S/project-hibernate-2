package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "active")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                '}';
    }
}

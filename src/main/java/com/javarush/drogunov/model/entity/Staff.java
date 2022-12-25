package com.javarush.drogunov.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;
@NoArgsConstructor
//@Data
//TODO Непонятная ситуация с ломбоком
        //Получаю StackOverflow при включении у класса toString, причем не в зависимости ломбоком или нет.
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

    @OneToOne
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
    private Byte active;
    
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
                ", address=" + address +
                ", email='" + email + '\'' +
                ", store=" + store +
                ", active=" + active +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

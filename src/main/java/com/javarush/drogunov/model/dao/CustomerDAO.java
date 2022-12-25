package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.CustomerDTO;
import org.hibernate.SessionFactory;

public class CustomerDAO {
    private final SessionFactory sessionFactory;

    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(CustomerDTO customerDTO) {

    }
}

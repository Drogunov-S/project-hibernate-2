package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Country;
import org.hibernate.SessionFactory;

@SuppressWarnings("unused")
public class CountryDAO extends GenericDAO<Country> {
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}

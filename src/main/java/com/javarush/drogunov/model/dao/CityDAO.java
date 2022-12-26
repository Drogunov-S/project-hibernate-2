package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.CityDTO;
import com.javarush.drogunov.model.entity.City;
import com.javarush.drogunov.model.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;
import java.time.Instant;

public class CityDAO {
    private final SessionFactory sessionFactory;
    
    public CityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public City createAndGet(CityDTO cityDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        City city;
        try {
            transaction.begin();
            CountryDAO countryDAO = new CountryDAO(sessionFactory);
            Country country = countryDAO.createAndGet(cityDTO.getCountry());
            city = new City();
            city.setCity(cityDTO.getCity());
            city.setCountry(country);
            city.setLastUpdate(Timestamp.from(Instant.now()));
            session.save(city);
            transaction.commit();
            return city;
        } catch (RuntimeException e) {
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}

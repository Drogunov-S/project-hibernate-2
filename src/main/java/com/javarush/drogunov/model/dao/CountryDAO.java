package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.CityDTO;
import com.javarush.drogunov.model.dto.CountryDTO;
import com.javarush.drogunov.model.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;
import java.time.Instant;

import static java.util.Objects.nonNull;

public class CountryDAO {
    private final SessionFactory sessionFactory;
    
    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Country createAndGet(CountryDTO countryDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            Country country = session.createQuery(
                            "from Country c WHERE c.country = :countryDTO"
                            , Country.class
                    )
                    .setParameter("countryDTO", countryDTO.getCountry())
                    .uniqueResult();
            if (nonNull(country)) {
                return country;
            }
            transaction.begin();
            country = new Country();
            country.setCountry(countryDTO.getCountry());
            country.setLastUpdate(Timestamp.from(Instant.now()));
            session.save(country);
            transaction.commit();
            return country;
        } catch (Exception e) {
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}

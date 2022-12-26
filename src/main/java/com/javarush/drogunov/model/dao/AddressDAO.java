package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.AddressDTO;
import com.javarush.drogunov.model.entity.Address;
import com.javarush.drogunov.model.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;
import java.time.Instant;

public class AddressDAO {
    private final SessionFactory sessionFactory;
    
    public AddressDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Address createAndGet(AddressDTO addressDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            CityDAO cityDAO = new CityDAO(sessionFactory);
            City city = cityDAO.createAndGet(addressDTO.getCityDTO());
            Address address = new Address();
            address.setAddress(addressDTO.getAddress());
            address.setPhone(addressDTO.getPhone());
            address.setDistrict(addressDTO.getDistrict());
            address.setPostalCode(addressDTO.getPostalCode());
            address.setLastUpdate(Timestamp.from(Instant.now()));
            address.setCity(city);
            session.save(address);
            transaction.commit();
            return address;
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

package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.CustomerDTO;
import com.javarush.drogunov.model.entity.Address;
import com.javarush.drogunov.model.entity.Customer;
import com.javarush.drogunov.model.entity.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;

public class CustomerDAO {
    private final SessionFactory sessionFactory;
    
    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Customer create(CustomerDTO customerDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            AddressDAO addressDAO = new AddressDAO(sessionFactory);
            Address address = addressDAO.createAndGet(customerDTO.getAddressDTO());
            StoreDAO storeDAO = new StoreDAO(sessionFactory);
            Store store = storeDAO.get(customerDTO.getStoreId());
            Customer customer = new Customer();
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getFirstName());
            customer.setEmail(customerDTO.getEmail());
            customer.setAddress(address);
            customer.setStore(store);
            customer.setActive(true);
            customer.setCreateDate(new Timestamp(System.currentTimeMillis()));
            customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            session.save(customer);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    public Customer findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Customer.class, id);
        }
    }
}

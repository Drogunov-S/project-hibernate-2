package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.RentalDTO;
import com.javarush.drogunov.model.entity.Customer;
import com.javarush.drogunov.model.entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.Instant;

public class RentalDAO {
    private final SessionFactory sessionFactory;
    
    public RentalDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Rental rentMovie(RentalDTO rentalDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        CustomerDAO customerDAO = new CustomerDAO(sessionFactory);
        InventoryDAO inventoryDAO = new InventoryDAO(sessionFactory);
        
        try {
            transaction.begin();
            Customer customer = customerDAO.findById(rentalDTO.getCustomerId());
            StaffDAO staffDAO = new StaffDAO(sessionFactory);
            Rental rental = new Rental();
            rental.setCustomer(customer);
            rental.setReturnDate(rentalDTO.getReturnDate());
            rental.setRentalDate(Timestamp.from(Instant.now()));
            rental.setLastUpdate(Timestamp.from(Instant.now()));
            rental.setStaff(staffDAO
                    .findById(rentalDTO
                            .getStaffId()));
            rental.setInventory(inventoryDAO.findByid(rentalDTO.getInventoryId()));
            session.save(rental);
            transaction.commit();
            return rental;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public Rental getById(Integer rentalId) {
        return sessionFactory.openSession().get(Rental.class, rentalId);
    }
}

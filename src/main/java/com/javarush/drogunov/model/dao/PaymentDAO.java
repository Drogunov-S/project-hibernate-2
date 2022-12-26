package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.PaymentDTO;
import com.javarush.drogunov.model.entity.Payment;
import com.javarush.drogunov.model.entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.Instant;

public class PaymentDAO {
    private final SessionFactory sessionFactory;
    
    public PaymentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Payment pay(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            RentalDAO rentalDAO = new RentalDAO(sessionFactory);
            Rental rental = rentalDAO.getById(paymentDTO.getRentalId());
            payment.setAmount(paymentDTO.getAmount());
            payment.setStaff(rental.getStaff());
            payment.setRental(rental);
            payment.setPaymentDate(Timestamp.from(Instant.now()));
            payment.setLastUpdate(Timestamp.from(Instant.now()));
            payment.setCustomer(rental.getCustomer());
            session.save(payment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return payment;
    }
}

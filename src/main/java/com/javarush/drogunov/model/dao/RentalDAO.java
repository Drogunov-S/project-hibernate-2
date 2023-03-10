package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Rental;
import org.hibernate.SessionFactory;

public class RentalDAO extends GenericDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
    
    public Rental getNoReturnedInventory() {
        return getCurrentSession()
                .createQuery(
                        "FROM Rental r WHERE r.returnDate IS NULL"
                        , Rental.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}

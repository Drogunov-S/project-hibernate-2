package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Customer;
import com.javarush.drogunov.model.entity.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InventoryDAO {
    private final SessionFactory sessionFactory;
    
    public InventoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Inventory findByid(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Inventory.class, id);
        }
    }
}

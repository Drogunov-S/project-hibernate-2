package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Customer;
import com.javarush.drogunov.model.entity.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StaffDAO {
    private final SessionFactory sessionFactory;
    
    public StaffDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Staff findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Staff.class, id);
        }
    }
}

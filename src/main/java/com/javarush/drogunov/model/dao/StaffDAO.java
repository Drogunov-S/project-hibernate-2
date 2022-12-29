package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Staff;
import org.hibernate.SessionFactory;

@SuppressWarnings("unused")
public class StaffDAO extends GenericDAO<Staff> {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}

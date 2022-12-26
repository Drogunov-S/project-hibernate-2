package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO {
    private final SessionFactory sessionFactory;
    
    public StoreDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Store get(Integer storeId) {
        Store store;
            store = sessionFactory.openSession().get(Store.class, storeId);
        return store;
    }
}

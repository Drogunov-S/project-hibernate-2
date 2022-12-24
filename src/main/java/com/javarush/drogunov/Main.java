package com.javarush.drogunov;

import com.javarush.drogunov.entity.Store;
import com.javarush.drogunov.repository.MysqlDb;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = MysqlDb.getFactory()) {
            String query = "SELECT rating FROM film WHERE film_id = 1";
//            NativeQuery nativeQuery = sessionFactory.openSession().createNativeQuery(query);
//            Object singleResult = nativeQuery.getSingleResult();
//            System.out.println(singleResult);
            Query<Store> fromFilm = sessionFactory.openSession().createQuery(
                    "from Store"
                , Store.class);
            System.out.println(fromFilm.list().get(1));
        }
    }
}
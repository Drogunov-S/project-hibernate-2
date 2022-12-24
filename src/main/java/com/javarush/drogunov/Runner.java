package com.javarush.drogunov;

import com.javarush.drogunov.entity.Film;
import com.javarush.drogunov.repository.MysqlDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Runner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = MysqlDb.getFactory()) {
            Session session = sessionFactory.openSession();
            Film singleResult = session.createQuery(
                    "from Film fi WHERE fi.id = 5", Film.class
            ).getSingleResult();

            System.out.println(singleResult.getCategories());
        }
    }
}

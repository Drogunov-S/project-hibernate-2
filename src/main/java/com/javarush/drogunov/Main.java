package com.javarush.drogunov;

import com.javarush.drogunov.entity.Film;
import com.javarush.drogunov.repository.MysqlDb;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = MysqlDb.getFactory();) {
            Query<Film> fromFilm = sessionFactory.openSession().createQuery("from Film", Film.class);
            System.out.println(fromFilm.list());
        }
    }
}
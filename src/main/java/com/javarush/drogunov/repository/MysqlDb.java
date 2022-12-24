package com.javarush.drogunov.repository;

import com.javarush.drogunov.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

import static java.util.Objects.isNull;

public class MysqlDb implements Repository {
    private static MysqlDb MYSQL_DB;
    private final SessionFactory sessionFactory;

    public MysqlDb() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/film");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        sessionFactory = new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(Film.class)
                .buildSessionFactory();
        MYSQL_DB = this;
    }

    public static SessionFactory getFactory() {
        if (isNull(MYSQL_DB)) {
            new MysqlDb();
        }
        return MYSQL_DB.sessionFactory;
    }
}

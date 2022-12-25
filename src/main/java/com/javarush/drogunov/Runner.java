package com.javarush.drogunov;

import com.javarush.drogunov.model.entity.Address;
import com.javarush.drogunov.model.entity.City;
import com.javarush.drogunov.model.entity.Inventory;
import com.javarush.drogunov.model.entity.Staff;
import com.javarush.drogunov.repository.mysql.MysqlDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = MysqlDb.getFactory()) {
            Session session = sessionFactory.openSession();
            Staff singleResult = session.createQuery(
                    "from Staff c WHERE c.id = 2"
                    , Staff.class
            ).getSingleResult();
            System.out.println("\n_________________________________________________\n");
            System.out.println(singleResult);
            System.out.println("\n_________________________________________________\n");

            System.out.println(singleResult.getAddress());
            System.out.println(singleResult.getStore());
        }
    }

    private static void nativeQuery(Object singleResult) {
        String query = "";


    }

    private static void printArray(List list) {
        for (
                Object o : list) {
            System.out.println(list);
        }
    }
}


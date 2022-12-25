package com.javarush.drogunov;

import com.javarush.drogunov.model.entity.*;
import com.javarush.drogunov.repository.mysql.MysqlDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = MysqlDb.getFactory()) {
            Session session = sessionFactory.openSession();
         /*   Store singleResult = session.createQuery(
                    "from Store c WHERE c.id = 2"
                    , Store.class
            ).getSingleResult();
            System.out.println("\n_________________________________________________\n");
            System.out.println(singleResult);
            System.out.println("\n_________________________________________________\n");

            System.out.println(singleResult.getAddress());
            System.out.println(singleResult.getStore());*/

//            printArray(session.createQuery("from Staff", Staff.class).setMaxResults(1).list());
            System.out.println(session.get(Address.class, 2));
            System.out.println(session.get(Store.class, 2));
            Staff staff = session.get(Staff.class, 1);
            System.out.println(staff);
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


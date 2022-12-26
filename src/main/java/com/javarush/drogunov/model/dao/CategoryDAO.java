package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.CategoryDTO;
import com.javarush.drogunov.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO {
    private final SessionFactory sessionFactory;
    
    public CategoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Category createAndGet(CategoryDTO categoryDTO) {
        Optional<Category> byName = findByName(categoryDTO);
        if (byName.isPresent()) {
            return byName.get();
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Category category = new Category();
        try {
            transaction.begin();
            category.setName(categoryDTO.getName());
            category.setLastUpdate(Timestamp.from(Instant.now()));
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return category;
    }
    
    public List<Category> getCategories(List<CategoryDTO> categoriesDTO) {
        List<Category> categories = new ArrayList<>();
        for (CategoryDTO categoryDTO : categoriesDTO) {
            categories.add(createAndGet(categoryDTO));
        }
        return categories;
    }
    public Optional<Category> findByName(CategoryDTO categoryDTO) {
        Session session = sessionFactory.openSession();
        Query<Category> query = session.createQuery(
                "from Category c where c.name = :findName"
        , Category.class
        );
        query.setParameter("findName", categoryDTO.getName());
        return query.uniqueResultOptional();
    }
}


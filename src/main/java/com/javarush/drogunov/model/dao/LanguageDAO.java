package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.LanguageDTO;
import com.javarush.drogunov.model.entity.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class LanguageDAO {
    private final SessionFactory sessionFactory;
    
    public LanguageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Language get(LanguageDTO languageDTO) {
        Session session = sessionFactory.openSession();
            Query<Language> query = session.createQuery(
                    "from Language l where l.name = :findLanguage"
                    , Language.class);
            Query<Language> findLanguage = query
                    .setParameter("findLanguage", languageDTO.getName());
            return findLanguage.getSingleResult();
    }
}

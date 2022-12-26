package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.FilmDTO;
import com.javarush.drogunov.model.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class FilmDAO {
    
    private final SessionFactory sessionFactory;
    public FilmDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Film createAndGet(FilmDTO filmDTO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Film film = new Film();
        try {
            CategoryDAO categoryDAO = new CategoryDAO(sessionFactory);
            List<Category> categories = categoryDAO.getCategories(filmDTO.getCategories());
            LanguageDAO languageDAO = new LanguageDAO(sessionFactory);
            Language language = languageDAO.get(filmDTO.getLanguage());
            ActorDAO actorDAO = new ActorDAO(sessionFactory);
            List<Actor> actors = actorDAO.getActors(filmDTO.getActors());
            
            transaction.begin();
            film.setTitle(filmDTO.getTitle());
            film.setRating(Rating.fromCode(filmDTO.getRating()));
            film.setRentalDuration(filmDTO.getRentalDuration());
            film.setDescription(filmDTO.getDescription());
            film.setLength(filmDTO.getLength());
            film.setRentalRate(filmDTO.getRentalRate());
            film.setReleaseYear(filmDTO.getReleaseYear());
            film.setReplacementCost(filmDTO.getReplacementCost());
//            film.setSpecialFeatures(filmDTO.getSpecialFeatures());
            film.setLastUpdate(Timestamp.from(Instant.now()));
            film.setCategories(categories);
            film.setLanguage(language);
            film.setActors(actors);
            session.save(film);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return film;
    }
    
}

package com.javarush.drogunov.model.dao;

import com.javarush.drogunov.model.dto.ActorDTO;
import com.javarush.drogunov.model.entity.Actor;
import com.javarush.drogunov.model.entity.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorDAO {
    private final SessionFactory sessionFactory;
    
    public ActorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Actor createAndGet(ActorDTO actorDTO) {
        Optional<Actor> byName = findByName(actorDTO);
        if (byName.isPresent()) {
            return byName.get();
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Actor actor = new Actor();
        try {
            transaction.begin();
            actor.setFirstName(actorDTO.getFirstName());
            actor.setLastName(actorDTO.getLastName());
            actor.setLastUpdate(Timestamp.from(Instant.now()));
            session.save(actor);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return actor;
    }
    
    public List<Actor> getActors(List<ActorDTO> actorDTOs) {
        List<Actor> actors = new ArrayList<>();
        for (ActorDTO ActorDTO : actorDTOs) {
            actors.add(createAndGet(ActorDTO));
        }
        return actors;
    }
    public Optional<Actor> findByName(ActorDTO actorDTO) {
        Session session = sessionFactory.openSession();
        Query<Actor> query = session.createQuery(
                "from Actor a where a.firstName = :firstName and a.lastName = :lastName"
                , Actor.class
        );
        query.setParameter("firstName", actorDTO.getFirstName());
        query.setParameter("lastName", actorDTO.getLastName());
        return query.uniqueResultOptional();
    }
}

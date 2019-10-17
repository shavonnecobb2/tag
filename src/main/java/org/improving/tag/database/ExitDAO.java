package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ExitDAO {

    public List<Exit> findAll() {
        EntityManager em = JPAUtility.getEntityManager();
            List<Exit> exits = em.createQuery("SELECT exit FROM org.improving.tag.Exit exit").getResultList();
            return exits;
        }
    }


package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class ExitDAO {

    public List<Exit> findAll() {
        EntityManager em = JPAUtility.getEntityManager();
            List<Exit> exits = em.createQuery("SELECT exit FROM org.improving.tag.Exit exit").getResultList();
            return exits;
        }
    }


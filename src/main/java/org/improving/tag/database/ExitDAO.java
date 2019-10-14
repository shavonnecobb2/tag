package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ExitDAO {
    private final JdbcTemplate jdbcTemplate;

    public ExitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exit> findByOriginId(int originId) {
        try {
            List<Exit> exits = jdbcTemplate.query("SELECT * FROM exits WHERE OriginId = ?",
                    new Object[]{originId},
                    (result, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setName(result.getString("Name"));
                        exit.setDestinationId(result.getInt("DestinationId"));
                        String aliases = result.getString("Aliases");
                        if (null != aliases) {
                            Arrays.stream(aliases.replace(" ", "").split(",")).forEach(alias -> exit.addAlias(alias));
                        }

                        return exit;
                    });
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}

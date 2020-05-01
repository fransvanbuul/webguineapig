package com.example.webguineapig.sink;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class JdbcSqlSink {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    public JdbcSqlSink(DataSource dataSource, JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public void simpleSqlI(String payload) {
        try(Connection c = dataSource.getConnection()) {
            try(Statement s = c.createStatement()) {
                s.execute(payload);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }
    }

    public void jdbcTemplateSqlI(String payload) {
        jdbcTemplate.execute(payload);
    }

    /* Creates a FN for SonarQube AND Fortify */
    public void jdbcTemplateSqlI2(String payload) {
        jdbcTemplate.execute(new StatementCallback<Object>() {
            @Override
            public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
                statement.execute(payload);
                return null;
            }
        });
    }

    public void jpaSqli(String payload) {
        entityManager.createNativeQuery(payload).executeUpdate();
    }
}

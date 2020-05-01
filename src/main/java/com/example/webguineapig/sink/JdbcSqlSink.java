package com.example.webguineapig.sink;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class JdbcSqlSink {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public JdbcSqlSink(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
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

}

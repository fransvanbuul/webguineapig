package com.example.webguineapig.sink;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class JdbcSqlSink {

    private final DataSource dataSource;

    public JdbcSqlSink(DataSource dataSource) {
        this.dataSource = dataSource;
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

}

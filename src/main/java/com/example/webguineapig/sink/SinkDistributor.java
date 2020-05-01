package com.example.webguineapig.sink;

import com.example.webguineapig.sink.JdbcSqlSink;
import org.springframework.stereotype.Component;

@Component
public class SinkDistributor {

    private final JdbcSqlSink jdbcSqlSink;

    public SinkDistributor(JdbcSqlSink jdbcSqlSink) {
        this.jdbcSqlSink = jdbcSqlSink;
    }

    public void proceed(String payload) {
//        jdbcSqlSink.simpleSqlI(payload);
//        jdbcSqlSink.jdbcTemplateSqlI(payload);
//        jdbcSqlSink.jdbcTemplateSqlI2(payload);
        jdbcSqlSink.jpaSqli(payload);
    }

}

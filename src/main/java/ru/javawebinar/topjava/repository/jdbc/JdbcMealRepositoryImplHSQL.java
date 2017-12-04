package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static ru.javawebinar.topjava.Profiles.HSQL_DB;

@Repository
@Profile({HSQL_DB})
public class JdbcMealRepositoryImplHSQL extends AbstractJdbcMealRepositoryImpl {


    @Override
    Timestamp getDateTime(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }

    @Autowired
    public JdbcMealRepositoryImplHSQL(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(dataSource,jdbcTemplate,namedParameterJdbcTemplate);
    }

}

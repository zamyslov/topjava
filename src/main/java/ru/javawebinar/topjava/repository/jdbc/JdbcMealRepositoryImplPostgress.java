package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;

import static ru.javawebinar.topjava.Profiles.POSTGRES_DB;

@Repository
@Profile({POSTGRES_DB})
public class JdbcMealRepositoryImplPostgress extends AbstractJdbcMealRepositoryImpl {


    @Autowired
    public JdbcMealRepositoryImplPostgress(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(dataSource,jdbcTemplate,namedParameterJdbcTemplate);
    }

    @Override
    LocalDateTime getDateTime(LocalDateTime dateTime) {
        return dateTime;
    }

}

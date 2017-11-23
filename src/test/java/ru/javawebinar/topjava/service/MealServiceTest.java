package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.MEAL_3;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;
import static ru.javawebinar.topjava.MealTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        Meal meal = service.get(START_SEQ + 4, USER_ID);
        assertMatch(meal, MEAL_3);
    }

    @Test(expected = NotFoundException.class)
    public void notFoundGet() throws Exception {
        service.get(START_SEQ + 4, ADMIN_ID);
    }

    @Test
    public void delete() throws Exception {
        service.delete(START_SEQ + 4, USER_ID);
        assertMatch(service.getAll(USER_ID), MEAL_6, MEAL_5, MEAL_4, MEAL_2, MEAL_1);

    }

    @Test(expected = NotFoundException.class)
    public void notFoundDelete() throws Exception {
        service.delete(START_SEQ + 4, ADMIN_ID);
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        LocalDateTime startTime = LocalDateTime.parse("2015-05-31 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endTime = LocalDateTime.parse("2015-05-31 23:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<Meal> all = service.getBetweenDateTimes(startTime, endTime, USER_ID);
        assertMatch(all, MEAL_6, MEAL_5, MEAL_4);

    }

    @Test
    public void getAll() throws Exception {
        List<Meal> all = service.getAll(USER_ID);
        assertMatch(all, MEAL_6, MEAL_5, MEAL_4, MEAL_3, MEAL_2, MEAL_1);
    }

    @Test
    public void update() throws Exception {
        Meal updated = new Meal(START_SEQ + 2, MEAL_1.getDateTime(), MEAL_1.getDescription(), MEAL_1.getCalories());
        updated.setCalories(330);
        service.update(updated, USER_ID);
        assertMatch(service.get(START_SEQ + 2, USER_ID), updated);
    }

    @Test(expected = NotFoundException.class)
    public void notFoundUpdate() throws Exception {
        Meal updated = new Meal(START_SEQ + 2, MEAL_1.getDateTime(), MEAL_1.getDescription(), MEAL_1.getCalories());
        updated.setCalories(330);
        service.update(updated, ADMIN_ID);
    }

    @Test
    public void create() throws Exception {
        Meal newMeal = new Meal(null, LocalDateTime.parse("2015-05-31 22:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Ужин", 500);
        Meal created = service.create(newMeal, USER_ID);
        newMeal.setId(created.getId());
        assertMatch(service.getAll(USER_ID), newMeal, MEAL_6, MEAL_5, MEAL_4, MEAL_3, MEAL_2, MEAL_1);
    }

}
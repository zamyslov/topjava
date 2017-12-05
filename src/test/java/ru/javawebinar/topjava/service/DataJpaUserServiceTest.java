package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.ActiveDbProfileResolver;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
public class DataJpaUserServiceTest extends AbstractUserServiceTest{
    @Test
    @Transactional
    public void getWithMeal() throws Exception {
        User user = service.getWithMeal(USER_ID);
        assertMatch(user, USER);
        assertMatch(user.getMeals(),Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1));
    }
}
package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;


public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final Meal MEAL_1 = new Meal(START_SEQ + 2, LocalDateTime.parse("2015-05-30 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Завтрак", 500);
    public static final Meal MEAL_2 = new Meal(START_SEQ + 3, LocalDateTime.parse("2015-05-30 13:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Обед", 1000);
    public static final Meal MEAL_3 = new Meal(START_SEQ + 4, LocalDateTime.parse("2015-05-30 20:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Ужин", 500);
    public static final Meal MEAL_4 = new Meal(START_SEQ + 5, LocalDateTime.parse("2015-05-31 10:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Завтрак", 500);
    public static final Meal MEAL_5 = new Meal(START_SEQ + 6, LocalDateTime.parse("2015-05-31 13:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Обед", 1000);
    public static final Meal MEAL_6 = new Meal(START_SEQ + 7, LocalDateTime.parse("2015-05-31 20:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Ужин", 500);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}

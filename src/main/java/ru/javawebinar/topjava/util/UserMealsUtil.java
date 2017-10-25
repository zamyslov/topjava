package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesPerDayMap = new HashMap<>();
        for (UserMeal usermeal : mealList) {
            LocalDate key = usermeal.getDateTime().toLocalDate();
            if (caloriesPerDayMap.containsKey(key)) {
                caloriesPerDayMap.put(key, usermeal.getCalories() + caloriesPerDayMap.get(key));
            } else {
                caloriesPerDayMap.put(key, usermeal.getCalories());
            }
        }

        List<UserMealWithExceed> list = new ArrayList<>();
        for (UserMeal usermeal : mealList) {
            LocalDate key = usermeal.getDateTime().toLocalDate();
            LocalTime time = usermeal.getDateTime().toLocalTime();
            if (time.isAfter(startTime) && time.isBefore(endTime)) {
                UserMealWithExceed mealWithExceed;
                if (caloriesPerDayMap.get(key) > caloriesPerDay) {
                    mealWithExceed = new UserMealWithExceed(usermeal.getDateTime(),
                            usermeal.getDescription(), usermeal.getCalories(), true);
                } else {
                    mealWithExceed = new UserMealWithExceed(usermeal.getDateTime(),
                            usermeal.getDescription(), usermeal.getCalories(), false);
                }
                list.add(mealWithExceed);
            }
        }
        return list;
    }
}

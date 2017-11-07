package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class MealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        getFilteredWithExceededStream(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    private static LocalDate toLocalDate(UserMeal p) {
        return p.getDateTime().toLocalDate();
    }

    private static LocalTime toLocalTime(UserMeal p) {
        return p.getDateTime().toLocalTime();
    }


    private static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesPerDayMap = new HashMap<>();
        for (UserMeal usermeal : mealList) {
            caloriesPerDayMap.put(toLocalDate(usermeal),
                    usermeal.getCalories() + caloriesPerDayMap.getOrDefault(toLocalDate(usermeal), 0));
        }
        List<UserMealWithExceed> list = new ArrayList<>();
        for (UserMeal usermeal : mealList) {
            if (TimeUtil.isBetween(toLocalTime(usermeal), startTime, endTime)) {
                list.add(new UserMealWithExceed(usermeal.getDateTime(),
                        usermeal.getDescription(), usermeal.getCalories(),
                        caloriesPerDayMap.get(toLocalDate(usermeal)) > caloriesPerDay));
            }
        }
        return list;
    }

    private static List<UserMealWithExceed> getFilteredWithExceededStream(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesPerDayMap = mealList.stream()
                .collect(Collectors.toMap(MealsUtil::toLocalDate, UserMeal::getCalories,
                        (oldValue, newValue) -> oldValue + newValue));

        return mealList.stream().filter(x -> (TimeUtil.isBetween(toLocalTime(x), startTime, endTime))
        ).map(p -> new UserMealWithExceed(p.getDateTime(), p.getDescription(), p.getCalories(),
                caloriesPerDayMap.get(toLocalDate(p)) > caloriesPerDay))
                .collect(Collectors.toList());

    }
}

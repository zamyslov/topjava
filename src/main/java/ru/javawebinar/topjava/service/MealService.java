package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public interface MealService {
    Meal create(Meal user);

    void delete(int id) throws NotFoundException;

    Meal get(int id) throws NotFoundException;

    void update(Meal user);

    Collection<MealWithExceed> getAll(int userId, int caloriesPerDay);

    Collection<MealWithExceed> getDateTimeFiltered(int userId, LocalDate startDate, LocalDate endDate,
                                                   LocalTime startTime, LocalTime endTime, int caloriesPerDay);
}
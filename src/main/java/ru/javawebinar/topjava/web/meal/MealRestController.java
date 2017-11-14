package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Controller
public class MealRestController {

    @Autowired
    private MealService service;

    public Collection<MealWithExceed> getAll() {
        return service.getAll(AuthorizedUser.id(), AuthorizedUser.getCaloriesPerDay());
    }

    public Collection<MealWithExceed> getDateTimeFiltered(LocalDate startDate, LocalDate endDate
            , LocalTime startTime, LocalTime endTime) {
        return service.getDateTimeFiltered(AuthorizedUser.id(), startDate, endDate, startTime, endTime
                , AuthorizedUser.getCaloriesPerDay());
    }

    public Meal get(int id) {
        return service.get(id);
    }

    public Meal create(Meal meal) {
        return service.create(meal);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void update(Meal meal) {
        service.update(meal);
    }

}
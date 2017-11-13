package ru.javawebinar.topjava.web.meal;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

public class MealRestController {
    private MealService service;

    public List<Meal> getAll() {
        return service.getAll();
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
package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

@Controller
public class MealRestController {

    @Autowired
    private MealService service;

    public List<Meal> getAll(int userId) {
        return service.getAll(userId);
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
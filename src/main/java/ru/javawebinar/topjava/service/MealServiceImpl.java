package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

public class MealServiceImpl implements MealService {

    private MealRepository repository;

    @Override
    public Meal create(Meal user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public void update(Meal user) {

    }

    @Override
    public List<Meal> getAll() {
        return null;
    }
}
package ru.javawebinar.topjava.dao.impl;


import ru.javawebinar.topjava.dao.api.Dao;
import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class MealIMDaoImpl implements Dao<Integer,Meal>{
    private ConcurrentHashMap<Integer, Meal> mealMap;
    private AtomicInteger idCounter = new AtomicInteger(1);
    private static MealIMDaoImpl crudDAO;

    private MealIMDaoImpl() {
        mealMap = new ConcurrentHashMap<>();
    }

    public static synchronized MealIMDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new MealIMDaoImpl();
        }
        return crudDAO;  }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(mealMap.values());
    }

    @Override
    public Meal getById(Integer key) {
        return mealMap.getOrDefault(key,null);
    }

    @Override
    public void delete(Integer key) {
        mealMap.remove(key);
    }

    @Override
    public Integer create(Meal entity) {
        Integer id = idCounter.getAndIncrement();
        entity.setId(id);
        mealMap.put(id,entity);
        return id;
    }

    @Override
    public void update(Meal entity) {
        mealMap.put(entity.getId(),entity);
    }

}

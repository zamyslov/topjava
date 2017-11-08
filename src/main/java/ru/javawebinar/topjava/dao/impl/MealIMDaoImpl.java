package ru.javawebinar.topjava.dao.impl;


import ru.javawebinar.topjava.dao.api.Dao;
import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class MealIMDaoImpl implements Dao<Integer,Meal>{
    private static ConcurrentHashMap<Integer, Meal> mealMap;
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
    public void save(Meal entity) {
        mealMap.put(entity.getId(),entity);
    }

    @Override
    public void delete(Integer key) {
        mealMap.remove(key);
    }

    @Override
    public void update(Meal entity) {
        mealMap.put(entity.getId(),entity);
    }

}

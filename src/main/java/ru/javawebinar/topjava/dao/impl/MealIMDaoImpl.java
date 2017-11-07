package ru.javawebinar.topjava.dao.impl;


import ru.javawebinar.topjava.dao.api.Dao;

import java.util.List;

public final class MealIMDaoImpl implements Dao{
    private static MealIMDaoImpl crudDAO;

    public static synchronized MealIMDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new MealIMDaoImpl();
        }
        return crudDAO;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(Object key) {
        return null;
    }

    @Override
    public Object getBy(String fieldName, String key) {
        return null;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public void delete(Object key) {

    }

    @Override
    public void update(Object entity) {

    }
}

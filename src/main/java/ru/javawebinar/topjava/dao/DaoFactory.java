package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.dao.api.Dao;
import ru.javawebinar.topjava.dao.impl.MealIMDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.PropertyHolder;


public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Meal> mealDao;

    private DaoFactory() {
        loadDaos();
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
        if (PropertyHolder.getInstance().getTypeOfDB().equals("InMemoryDB")) {
            mealDao = MealIMDaoImpl.getInstance();
        } else {
            //mealDao = MealDaoImpl.getInstance();
        }
    }



}

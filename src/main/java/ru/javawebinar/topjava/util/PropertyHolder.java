package ru.javawebinar.topjava.util;

import java.io.IOException;
import java.util.Properties;


public final class PropertyHolder {

    private static PropertyHolder propertyHolder;

    private String typeOfDB;

    private PropertyHolder() {
        loadProperties();
    }

    public static synchronized PropertyHolder getInstance() {
        if (propertyHolder == null) {
            propertyHolder = new PropertyHolder();
        }
        return propertyHolder;
    }

    private void loadProperties() {
        Properties prop = new Properties();

        try {
            prop.load(PropertyHolder.class.getClassLoader().getResourceAsStream("application.properties"));

            this.typeOfDB = prop.getProperty("typeOfDB");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getTypeOfDB() {
        return typeOfDB;
    }
}

package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MealWithExceed {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean exceed;

    public LocalDate getLocalDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getLocalTime() {
        return dateTime.toLocalTime();
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExceed() {
        return exceed;
    }

    public MealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
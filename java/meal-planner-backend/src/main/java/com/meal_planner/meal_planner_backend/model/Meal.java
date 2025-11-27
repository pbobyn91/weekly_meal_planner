package com.meal_planner.meal_planner_backend.model;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class Meal {
    private Map<String, String> meals = new HashMap<>();

    public Meal() {
        for (Day day : Day.values()) {
            meals.put(day.getValue(), "");
        }
    }

    public void setMeal(String day, String meal) {
        meals.put(day, meal);
    }

    public Map<String, String> getMeals() {
        return meals;
    }

    public String getMeal(String day) {
        return meals.get(day);
    }
}

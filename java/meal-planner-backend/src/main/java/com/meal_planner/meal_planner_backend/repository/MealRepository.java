package com.meal_planner.meal_planner_backend.repository;

import com.meal_planner.meal_planner_backend.model.Day;
import com.meal_planner.meal_planner_backend.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class MealRepository {

    @Autowired
    private Meal meal;

    public Meal getMealPlan() {
        return meal;
    }

    public String getMeal(String day) {
        validateDay(day);
        return meal.getMeal(day);
    }

    public void updateMeal(String day, String mealName) {
        validateDay(day);
        meal.setMeal(day, mealName);
    }

    private void validateDay(String day) {
        boolean isValid = Arrays.stream(Day.values())
                .anyMatch(d -> d.getValue().equals(day));

        if (!isValid) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }
}

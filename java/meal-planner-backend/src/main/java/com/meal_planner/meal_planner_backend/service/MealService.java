package com.meal_planner.meal_planner_backend.service;

import com.meal_planner.meal_planner_backend.model.Meal;
import com.meal_planner.meal_planner_backend.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Map<String, String> getAllMeals() {
        return mealRepository.getMealPlan().getMeals();
    }

    public void updateMeal(String day, String meal) {
        mealRepository.updateMeal(day, meal);
    }

    public void deleteMeal(String day) {
        mealRepository.updateMeal(day, "");
    }
}

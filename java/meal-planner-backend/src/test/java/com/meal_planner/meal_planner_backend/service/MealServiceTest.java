package com.meal_planner.meal_planner_backend.service;

import com.meal_planner.meal_planner_backend.model.Day;
import com.meal_planner.meal_planner_backend.model.Meal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MealServiceTest {

    @Autowired
    private MealService mealService;

    @Autowired
    private Meal meal;

    @Test
    void testGetAllMeals() {
        assertEquals(meal.getMeals(), mealService.getAllMeals());
    }

    @DirtiesContext
    @ParameterizedTest
    @EnumSource(Day.class)
    void testUpdateMeal(Day day) {
        mealService.updateMeal(day.getValue(), "Updated Meal");
        assertEquals("Updated Meal", meal.getMeal(day.getValue()));
    }

    @Test
    void testUpdateMealWithInvalidDay() {
        assertThrows(IllegalArgumentException.class, () ->
                mealService.updateMeal("Invalid Day", "Updated Meal"));
    }

    @ParameterizedTest
    @EnumSource(Day.class)
    void testDeleteMeal(Day day) {
        mealService.updateMeal(day.getValue(), "Updated Meal");
        mealService.deleteMeal(day.getValue());
        assertEquals("", meal.getMeal(day.getValue()));
    }

    @Test
    void testDeleteMealWithInvalidDay() {
        assertThrows(IllegalArgumentException.class, () ->
                mealService.deleteMeal("Invalid Day"));
    }
}

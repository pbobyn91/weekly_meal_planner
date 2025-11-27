package com.meal_planner.meal_planner_backend.repository;

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
public class MealRepositoryTest {

    @Autowired
    private Meal meal;

    @Autowired
    private MealRepository mealRepository;

    @Test
    void testGetMealPlan() {
        assertEquals(meal, mealRepository.getMealPlan());
    }

    @ParameterizedTest
    @EnumSource(Day.class)
    void testGetMeal(Day day) {
        assertEquals("", mealRepository.getMeal(day.getValue()));
    }

    @Test
    void testGetMealInvalid() {
        assertThrows(IllegalArgumentException.class, () -> mealRepository.getMeal("InvalidDay"));
    }

    @DirtiesContext
    @ParameterizedTest
    @EnumSource(Day.class)
    void testUpdateMeal(Day day) {
        mealRepository.updateMeal(day.getValue(), "New Meal");
        assertEquals("New Meal", mealRepository.getMeal(day.getValue()));
    }

    @Test
    void testUpdateMealInvalid() {
        assertThrows(IllegalArgumentException.class, () -> mealRepository.updateMeal("InvalidDay", "New Meal"));
    }
}

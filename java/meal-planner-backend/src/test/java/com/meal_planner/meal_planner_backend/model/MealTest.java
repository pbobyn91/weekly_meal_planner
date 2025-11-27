package com.meal_planner.meal_planner_backend.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MealTest {

    @Autowired
    private Meal meal;
    private Day day;

    @ParameterizedTest
    @EnumSource(Day.class)
    void testGetMeal(Day day){
        assertEquals("", meal.getMeal(day.getValue()));
    }

    @Test
    void testAllDays(){
        for (Day day : Day.values()) {
            assertTrue(meal.getMeals().containsKey(day.getValue()));
        }
    }

    @Test
    void testSetMeal(){
        meal.setMeal("monday", "Pasta");
        assertEquals("Pasta", meal.getMeal("monday"));
    }

    @Test
    void testInvalidDay(){
        assertNull(meal.getMeal("InvalidDay"));
    }
}

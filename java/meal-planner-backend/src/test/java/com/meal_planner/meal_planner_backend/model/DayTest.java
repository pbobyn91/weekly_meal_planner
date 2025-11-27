package com.meal_planner.meal_planner_backend.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayTest {

    @ParameterizedTest
    @EnumSource(Day.class)
    void testGetValue(Day day){
        assertEquals(day.toString().toLowerCase(), day.getValue());
    }

    @Test
    void invalidDay() {
        assertThrows(IllegalArgumentException.class, () -> Day.valueOf("invalidDay"));
    }
}

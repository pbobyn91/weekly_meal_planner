package com.meal_planner.meal_planner_backend.controller;

import com.meal_planner.meal_planner_backend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public Map<String, String> getMeals() {
        return mealService.getAllMeals();
    }

    @PutMapping("/{day}")
    public void updateMeal(@PathVariable String day, @RequestParam String meal) {
        mealService.updateMeal(day, meal);
    }

    @DeleteMapping("/{day}")
    public void deleteMeal(@PathVariable String day) {
        mealService.deleteMeal(day);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidDay(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}

package com.meal_planner.meal_planner_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MealControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetMeals() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/meals", Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(7, response.getBody().size());
    }

    @Test
    void testUpdateMeal() {
        ResponseEntity<Void> response = restTemplate.exchange("/meals/monday?meal=Pizza",
                HttpMethod.PUT, null, Void.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteMeal() {
        restTemplate.delete("/meals/monday");
        // Verify it was deleted by getting it
        ResponseEntity<Map> getResponse = restTemplate.getForEntity("/meals", Map.class);
        assertEquals("", getResponse.getBody().get("monday"));
    }

    @Test
    void testInvalidDay() {
        ResponseEntity<String> response = restTemplate.exchange("/meals/invalidday?meal=Pizza",
                HttpMethod.PUT, null, String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}

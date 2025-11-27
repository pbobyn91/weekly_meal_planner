package com.meal_planner.meal_planner_backend.model;

public enum Day {
    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday");

    private final String value;

    Day(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

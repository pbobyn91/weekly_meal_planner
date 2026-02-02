using MealPlanner.Core.Models;

namespace MealPlanner.Core.Interfaces;

public interface IMealRepository
{
    Meal GetMealPlan();
    string GetMeal(string day);
    void UpdateMeal(string day, string mealName);
}
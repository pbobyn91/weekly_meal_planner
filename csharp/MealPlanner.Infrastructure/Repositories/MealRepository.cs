using MealPlanner.Core.Interfaces;
using MealPlanner.Core.Models;
using System.Linq;

namespace MealPlanner.Infrastructure.Repositories;

public class MealRepository : IMealRepository
{
    private readonly Meal _meal = new();

    public Meal GetMealPlan() => _meal;

    public string GetMeal(string day)
    {
        ValidateDay(day);
        return _meal.GetMeal(day);
    }

    public void UpdateMeal(string day, string mealName)
    {
        ValidateDay(day);
        _meal.SetMeal(day, mealName);
    }

    private static void ValidateDay(string day)
    {
        var isValid = Enum.GetValues<Day>().Any(d => d.ToString().ToLower() == day);

        if (!isValid) throw new ArgumentException("Invalid day", nameof(day));
    }
}
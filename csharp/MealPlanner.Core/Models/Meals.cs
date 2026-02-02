namespace MealPlanner.Core.Models;

public class Meal
{
    private readonly Dictionary<string, string> _meals = new();

    public Meal()
    {
        foreach (Day day in Enum.GetValues<Day>())
        {
            _meals[day.ToString().ToLower()] = string.Empty;
        }
    }

    public void SetMeal(string day, string meal)
    {
        _meals[day] = meal;
    }

    public Dictionary<string, string> GetMeals()
    {
        return _meals;
    }

    public string GetMeal(string day){
        return _meals.GetValueOrDefault(day, string.Empty);
    }
}
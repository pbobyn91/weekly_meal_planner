namespace MealPlanner.Core.Interfaces;

public interface IMealService
{
    Dictionary<string, string> GetAllMeals();
    void UpdateMeal(string day, string meal);
    void DeleteMeal(string day);
}

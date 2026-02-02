using MealPlanner.Core.Interfaces;

namespace MealPlanner.Infrastructure.Services;

public class MealService : IMealService
{
    private readonly IMealRepository _mealRepository;

    public MealService(IMealRepository mealRepository)
    {
        _mealRepository = mealRepository;
    }

    public Dictionary<string, string> GetAllMeals()
    {
        return _mealRepository.GetMealPlan().GetMeals();
    }

    public void UpdateMeal(string day, string meal)
    {
        _mealRepository.UpdateMeal(day, meal);
    }

    public void DeleteMeal(string day)
    {
        _mealRepository.UpdateMeal(day, string.Empty);
    }
}
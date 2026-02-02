using MealPlanner.Core.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace MealPlanner.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class MealsController : ControllerBase
{
    private readonly IMealService _mealService;

    public MealsController(IMealService mealService)
    {
        _mealService = mealService;
    }

    [HttpGet]
    public ActionResult<Dictionary<string, string>> GetMeals()
    {
        return Ok(_mealService.GetAllMeals());
    }

    [HttpPut("{day}")]
    public IActionResult UpdateMeal(string day, [FromQuery] string meal)
    {
        try
        {
            _mealService.UpdateMeal(day, meal);
            return Ok();
        }
        catch (ArgumentException ex)
        {
            return NotFound(ex.Message);
        }
    }

    [HttpDelete("{day}")]
    public IActionResult DeleteMeal(string day)
    {
        try
        {
            _mealService.DeleteMeal(day);
            return Ok();
        }
        catch (ArgumentException ex)
        {
            return NotFound(ex.Message);
        }
    }
}
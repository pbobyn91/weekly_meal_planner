using MealPlanner.Core.Models;
using Xunit;

namespace MealPlanner.Tests.Models;

public class MealTests
{
    [Fact]
    public void Constructor_ShouldInitializeAllSevenDays()
    {
        var meal = new Meal();
        var meals = meal.GetMeals();

        Assert.Equal(7, meals.Count);
        Assert.True(meals.ContainsKey("sunday"));
        Assert.True(meals.ContainsKey("monday"));
        Assert.True(meals.ContainsKey("saturday"));
        Assert.All(meals.Values, value => Assert.Equal(string.Empty, value));
    }

    [Fact]
    public void SetMeal_ShouldUpdateSpecificDay()
    {
        var meal = new Meal();

        meal.SetMeal("monday", "pasta");

        Assert.Equal("pasta", meal.GetMeals()["monday"]);
        Assert.Equal(string.Empty, meal.GetMeals()["sunday"]);
    }

    [Fact]
    public void GetMeal_WithInvalidDay_ShouldReturnEmpty()
    {
        // Arrange
        var meal = new Meal();

        // Act & Assert
        Assert.Equal(string.Empty, meal.GetMeal("invalidday"));
    }

    [Fact]
    public void SetMeal_WithNullMeal_ShouldSetNull()
    {
        // Arrange
        var meal = new Meal();

        // Act
        meal.SetMeal("wednesday", null);

        // Assert
        Assert.Null(meal.GetMeal("wednesday"));
    }
}
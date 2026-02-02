using MealPlanner.Api.Controllers;
using MealPlanner.Core.Interfaces;
using Microsoft.AspNetCore.Mvc;
using Moq;
using Xunit;

namespace MealPlanner.Tests.Controllers;

public class MealsControllerTests
{
    [Fact]
    public void GetMeals_ShouldReturnOkWithMeals()
    {
        // Arrange
        var mockService = new Mock<IMealService>();
        var expectedMeals = new Dictionary<string, string> { { "monday", "Salmon" } };
        mockService.Setup(s => s.GetAllMeals()).Returns(expectedMeals);
        
        var controller = new MealsController(mockService.Object);

        // Act
        var result = controller.GetMeals();

        // Assert
        var okResult = Assert.IsType<OkObjectResult>(result.Result);
        Assert.Equal(expectedMeals, okResult.Value);
    }

    [Fact]
    public void UpdateMeal_WithValidDay_ShouldReturnOk()
    {
        // Arrange
        var mockService = new Mock<IMealService>();
        var controller = new MealsController(mockService.Object);

        // Act
        var result = controller.UpdateMeal("monday", "Pasta");

        // Assert
        Assert.IsType<OkResult>(result);
        mockService.Verify(s => s.UpdateMeal("monday", "Pasta"), Times.Once);
    }

    [Fact]
    public void UpdateMeal_WithInvalidDay_ShouldReturnNotFound()
    {
        // Arrange
        var mockService = new Mock<IMealService>();
        mockService.Setup(s => s.UpdateMeal("invalidday", "Pasta"))
                   .Throws(new ArgumentException("Invalid day"));
        
        var controller = new MealsController(mockService.Object);

        // Act
        var result = controller.UpdateMeal("invalidday", "Pasta");

        // Assert
        var notFoundResult = Assert.IsType<NotFoundObjectResult>(result);
        Assert.Equal("Invalid day", notFoundResult.Value);
    }

    [Fact]
    public void DeleteMeal_ShouldCallService()
    {
        // Arrange
        var mockService = new Mock<IMealService>();
        var controller = new MealsController(mockService.Object);

        // Act
        var result = controller.DeleteMeal("tuesday");

        // Assert
        Assert.IsType<OkResult>(result);
        mockService.Verify(s => s.DeleteMeal("tuesday"), Times.Once);
    }
}

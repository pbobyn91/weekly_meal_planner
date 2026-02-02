using MealPlanner.Core.Interfaces;
using MealPlanner.Infrastructure.Services;
using Moq;
using Xunit;

namespace MealPlanner.Tests.Services;

public class MealServiceTests
{
    [Fact]
    public void UpdateMeal_ShouldCallRepository()
    {
        // Arrange
        var mockRepo = new Mock<IMealRepository>();
        var service = new MealService(mockRepo.Object);

        // Act
        service.UpdateMeal("monday", "Salmon");

        // Assert
        mockRepo.Verify(r => r.UpdateMeal("monday", "Salmon"), Times.Once);
    }

    [Fact]
    public void DeleteMeal_ShouldUpdateWithEmptyString()
    {
        // Arrange
        var mockRepo = new Mock<IMealRepository>();
        var service = new MealService(mockRepo.Object);

        // Act
        service.DeleteMeal("tuesday");

        // Assert
        mockRepo.Verify(r => r.UpdateMeal("tuesday", string.Empty), Times.Once);
    }
}

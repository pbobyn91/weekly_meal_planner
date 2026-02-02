using MealPlanner.Infrastructure.Repositories;
using Xunit;

namespace MealPlanner.Tests.Repositories;

public class MealRepositoryTests
{
    [Fact]
    public void GetMeal_WithValidDay_ShouldReturnMeal()
    {
        var repository = new MealRepository();
        repository.UpdateMeal("monday", "Salmon");
        
        Assert.Equal("Salmon", repository.GetMeal("monday"));
    }

    [Fact]
    public void UpdateMeal_WithInvalidDay_ShouldThrowException()
    {
        var repository = new MealRepository();
        
        Assert.Throws<ArgumentException>(() => repository.UpdateMeal("invalidday", "Pasta"));
    }
}

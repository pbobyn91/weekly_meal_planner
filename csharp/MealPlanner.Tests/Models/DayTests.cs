using MealPlanner.Core.Models;
using Xunit;

namespace MealPlanner.Tests.Models;

public class DayTests
{
    [Fact]
    public void Day_ShouldHaveSevenValues()
    {
        // Act
        var days = Enum.GetValues<Day>();

        // Assert
        Assert.Equal(7, days.Length);
    }

    [Theory]
    [InlineData(Day.Monday, "monday")]
    [InlineData(Day.Sunday, "sunday")]
    public void Day_ToString_ShouldMatchExpectedFormat(Day day, string expected)
    {
        // Act
        var result = day.ToString().ToLower();

        // Assert
        Assert.Equal(expected, result);
    }
}

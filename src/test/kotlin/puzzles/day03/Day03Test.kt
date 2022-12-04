package puzzles.day03

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.parseDay03Input
import puzzles.solve3Task
import puzzles.solve3Task2Part

internal class Day03Test {

    @Test
    fun `success parse input`() {
        val actual = parseDay03Input(Day03DataProvider.inputData)
        val expected = listOf(
            Day03DataProvider.firstRucksackLeftCompartments to Day03DataProvider.firstRucksackRightCompartments,
            Day03DataProvider.secondRucksackLeftCompartments to Day03DataProvider.secondRucksackRightCompartments
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task`() {
        val actual = solve3Task(Day03DataProvider.inputData)
        val expected = Day03DataProvider.sumOfPriorities
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task 2 part`() {
        val actual = solve3Task2Part(Day032PartDataProvider.inputData)
        val expected = Day032PartDataProvider.sumOfPriorities
        Assertions.assertEquals(expected, actual)
    }
}

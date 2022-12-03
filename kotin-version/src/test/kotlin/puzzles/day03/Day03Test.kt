package puzzles.day03

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.parseInput
import puzzles.solveTask
import puzzles.solveTask2Part

internal class Day03Test {

    @Test
    fun `success parse input`() {
        val actual = parseInput(Day03DataProvider.inputData)
        val expected = listOf(
            Day03DataProvider.firstRucksackLeftCompartments to Day03DataProvider.firstRucksackRightCompartments,
            Day03DataProvider.secondRucksackLeftCompartments to Day03DataProvider.secondRucksackRightCompartments
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task`() {
        val actual = solveTask(Day03DataProvider.inputData)
        val expected = Day03DataProvider.sumOfPriorities
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task 2 part`() {
        val actual = solveTask2Part(Day032PartDataProvider.inputData)
        val expected = Day032PartDataProvider.sumOfPriorities
        Assertions.assertEquals(expected, actual)
    }
}

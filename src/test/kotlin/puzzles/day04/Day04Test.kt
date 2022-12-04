package puzzles.day04

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.parseDay04Input
import puzzles.solve4Task
import puzzles.solve4Task2Part

internal class Day04Test {

    @Test
    fun `success parse input`() {
        val actual = parseDay04Input(Day04DataProvider.testData)
        val expected = listOf(
            Day04DataProvider.firstLeftRange to Day04DataProvider.firstRightRange,
            Day04DataProvider.secondLeftRange to Day04DataProvider.secondRightRange
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task`() {
        val actual = solve4Task(Day04DataProvider.testData)
        val expected = Day04DataProvider.fullyContainCount
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task 2 part`() {
        val actual = solve4Task2Part(Day04DataProvider.testData)
        val expected = Day04DataProvider.fullyContainCount
        Assertions.assertEquals(expected, actual)
    }
}

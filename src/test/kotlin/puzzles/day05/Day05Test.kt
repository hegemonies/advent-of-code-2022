package puzzles.day05

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.parseInputStepsDay05
import puzzles.parseStackInputDay05
import puzzles.solveDay05Task

internal class Day05Test {

    @Test
    fun `success parse stack input`() {
        val actual = parseStackInputDay05(Day05DataProvider.testStackInput)
        val expected = mapOf(
            1 to Day05DataProvider.firstStack,
            2 to Day05DataProvider.secondStack
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success parse steps input`() {
        val actual = parseInputStepsDay05(Day05DataProvider.testStepsInput)
        val expected = listOf(
            Day05DataProvider.firstStep,
            Day05DataProvider.secondStep
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success solve task`() {
        val actual = solveDay05Task(
            stackInput = Day05DataProvider.testStackInput,
            stepsInput = Day05DataProvider.testStepsInput
        )
        val expected = Day05DataProvider.firstTaskAnswer
        Assertions.assertEquals(expected, actual)
    }
}

package puzzles.day01

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.separateInputToElves
import puzzles.solve1Task

internal class `1TaskTest` {

    @Test
    fun `success separate input`() {
        val expected = listOf(`1TaskDataProvider`.firstElfCalories, `1TaskDataProvider`.secondElfCalories)
        val actual = `1TaskDataProvider`.testData.separateInputToElves()
        Assertions.assertTrue(expected == actual)
    }

    @Test
    fun `success find max carrying of elf calories`() {
        val expected = `1TaskDataProvider`.firstElfCalories
        val actual = solve1Task(`1TaskDataProvider`.testData)
        Assertions.assertTrue(expected == actual)
    }
}
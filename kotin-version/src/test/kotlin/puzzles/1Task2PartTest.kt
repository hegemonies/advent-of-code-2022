package puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class `1Task2PartTest` {

    @Test
    fun `success find total of top 3 elf carrying calories `() {
        val expected = `1TaskDataProvider`.firstElfCalories + `1TaskDataProvider`.secondElfCalories + `1TaskDataProvider`.fourthElfCalories
        val actual = solve1Task2Part(`1TaskDataProvider`.testData)
        Assertions.assertTrue(expected == actual)
    }
}

package puzzles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FirstTest {
    private val firstElfCalories = 48559
    private val secondElfCalories = 41560
    private val testData = """
        10062
        15651
        1271
        14355
        7220

        4878
        1754
        8466
        4741
        2582
        3003
        5327
        3172
        1327
        6310
    """.trimIndent()

    @Test
    fun `success separate input`() {
        val expected = listOf(firstElfCalories, secondElfCalories)
        val actual = testData.separateInputToElves()
        Assertions.assertTrue(expected == actual)
    }

    @Test
    fun `success find max carrying of elf calories`() {
        val expected = firstElfCalories
        val actual = solveFirst(testData)
        Assertions.assertTrue(expected == actual)
    }
}
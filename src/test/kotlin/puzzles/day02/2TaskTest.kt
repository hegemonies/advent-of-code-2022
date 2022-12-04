package puzzles.day02

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.parse2TaskInput
import puzzles.play
import puzzles.play2part

internal class `2TaskTest` {

    @Test
    fun `success parse input string`() {
        val actual = parse2TaskInput(`2TaskDataProvider`.testInput)
        val expected = listOf(
            `2TaskDataProvider`.firstPair,
            `2TaskDataProvider`.secondPair,
            `2TaskDataProvider`.thirdPair
        )
        Assertions.assertTrue(actual == expected)
    }

    @Test
    fun `success play`() {
        val strategyGuide = parse2TaskInput(`2TaskDataProvider`.testInput)
        val actual = play(strategyGuide)
        val expected = `2TaskDataProvider`.totalScore
        Assertions.assertTrue(actual == expected)
    }

    @Test
    fun `success play 2 part`() {
        val strategyGuide = parse2TaskInput(`2TaskDataProvider`.testInput)
        val actual = play2part(strategyGuide)
        val expected = `2TaskDataProvider`.totalScore2part
        Assertions.assertTrue(actual == expected)
    }
}

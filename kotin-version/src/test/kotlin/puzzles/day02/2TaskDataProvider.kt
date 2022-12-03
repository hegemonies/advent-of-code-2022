package puzzles.day02

import puzzles.StrategyGuide

internal object `2TaskDataProvider` {

    val testInput = """
        B Z
        C Z
        B X
    """.trimIndent()
    val firstPair = StrategyGuide.B to StrategyGuide.Z
    val secondPair = StrategyGuide.C to StrategyGuide.Z
    val thirdPair = StrategyGuide.B to StrategyGuide.X
    const val totalScore = (6 + 3) + (3 + 3) + (0 + 1)
    const val totalScore2part = (6 + 3) + (6 + 1) + (0 + 1)
}

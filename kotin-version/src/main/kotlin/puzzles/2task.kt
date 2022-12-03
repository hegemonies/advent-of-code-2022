package puzzles

import java.lang.Exception

fun solve2Task(input: String): Int {
    val strategyGuideList = parse2TaskInput(input)
    return play(strategyGuideList)
}

fun solve2Task2Part(input: String): Int {
    val strategyGuideList = parse2TaskInput(input)
    return play2part(strategyGuideList)
}

fun parse2TaskInput(input: String): List<Pair<StrategyGuide, StrategyGuide>> {
    return input.split("\n").map { raw ->
        val (left, right) = raw.trim().split(" ")
        StrategyGuide.valueOf(left) to StrategyGuide.valueOf(right)
    }
}

fun play(strategyGuideList: List<Pair<StrategyGuide, StrategyGuide>>): Int {
    var sum = 0

    strategyGuideList.forEach { (left, right) ->
        val turnResult = right.isBeat(left)
        sum += turnResult.getScore() + right.getScore()
    }

    return sum
}

fun play2part(strategyGuideList: List<Pair<StrategyGuide, StrategyGuide>>): Int {
    var sum = 0

    strategyGuideList.forEach { (left, right) ->
        val needTurnResult = right.toTurnResult()
        val needStrategy = when (needTurnResult) {
            TurnResult.DRAW -> left.getOpponentStrategyForDraw()
            TurnResult.WIN -> left.getOpponentStrategyForWin()
            TurnResult.LOOSE -> left.getOpponentStrategyForLoose()
        }
        sum += needTurnResult.getScore() + needStrategy.getScore()
    }

    return sum
}

enum class StrategyGuide {
    A, // Rock
    B, // Paper
    C, // Scissors
    X, // Rock
    Y, // Paper
    Z; // Scissors

    fun isBeat(other: StrategyGuide): TurnResult =
        when (this) {
            other -> throw Exception("There are similar shapes could not be")

            X -> {
                when (other) {
                    A -> TurnResult.DRAW
                    B -> TurnResult.LOOSE
                    C -> TurnResult.WIN
                    else -> throw Exception("There are similar shapes could not be")
                }
            }

            Y -> {
                when (other) {
                    A -> TurnResult.WIN
                    B -> TurnResult.DRAW
                    C -> TurnResult.LOOSE
                    else -> throw Exception("There are similar shapes could not be")
                }
            }

            Z -> {
                when (other) {
                    A -> TurnResult.LOOSE
                    B -> TurnResult.WIN
                    C -> TurnResult.DRAW
                    else -> throw Exception("There are similar shapes could not be")
                }
            }

            else -> throw Exception("There are similar shapes could not be")
        }

    fun getScore(): Int =
        when (this) {
            X -> 1
            Y -> 2
            Z -> 3
            else -> throw Exception("Failed to get score")
        }

    fun toTurnResult(): TurnResult =
        when (this) {
            X -> TurnResult.LOOSE
            Y -> TurnResult.DRAW
            Z -> TurnResult.WIN
            else -> throw Exception("Failed to get turn result from strategy")
        }

    fun getOpponentStrategyForDraw(): StrategyGuide =
        when (this) {
            A -> X
            B -> Y
            C -> Z
            else -> throw Exception("Failed to get opponent strategy for draw")
        }

    fun getOpponentStrategyForLoose(): StrategyGuide =
        when (this) {
            A -> Z
            B -> X
            C -> Y
            else -> throw Exception("Failed to get opponent strategy for loose")
        }

    fun getOpponentStrategyForWin(): StrategyGuide =
        when (this) {
            A -> Y
            B -> Z
            C -> X
            else -> throw Exception("Failed to get opponent strategy for win")
        }
}

enum class TurnResult {
    WIN, LOOSE, DRAW;

    fun getScore(): Int =
        when (this) {
            TurnResult.LOOSE -> 0
            TurnResult.DRAW -> 3
            TurnResult.WIN -> 6
        }
}

fun main() {
    println("first part = ${solve2Task(inputs.`2taskInput`)}")
    println("second part = ${solve2Task2Part(inputs.`2taskInput`)}")
}

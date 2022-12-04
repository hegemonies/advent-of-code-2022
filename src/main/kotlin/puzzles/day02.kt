package puzzles

import java.lang.Exception

/**
 * https://adventofcode.com/2022/day/2
 *
 * --- Day 2: Rock Paper Scissors ---
 * The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage, a giant Rock Paper Scissors tournament is already in progress.
 *
 * Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players each simultaneously choose one of Rock, Paper, or Scissors using a hand shape. Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same shape, the round instead ends in a draw.
 *
 * Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that they say will be sure to help you win. "The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.
 *
 * The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious, so the responses must have been carefully chosen.
 *
 * The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores for each round. The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
 *
 * Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get if you were to follow the strategy guide.
 *
 * For example, suppose you were given the following strategy guide:
 *
 * A Y
 * B X
 * C Z
 * This strategy guide predicts and recommends the following:
 *
 * In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
 * In the second round, your opponent will choose Paper (B), and you should choose Rock (X). This ends in a loss for you with a score of 1 (1 + 0).
 * The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
 * In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
 *
 * What would your total score be if everything goes exactly according to your strategy guide?
 */
fun solve2Task(input: String): Int {
    val strategyGuideList = parse2TaskInput(input)
    return play(strategyGuideList)
}

/**
 * --- Part Two ---
 * The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round needs to end: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win. Good luck!"
 *
 * The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round ends as indicated. The example above now goes like this:
 *
 * In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
 * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
 * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
 * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
 *
 * Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?
 */
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
    println("first part = ${solve2Task(inputs.day02Input)}")
    println("second part = ${solve2Task2Part(inputs.day02Input)}")
}

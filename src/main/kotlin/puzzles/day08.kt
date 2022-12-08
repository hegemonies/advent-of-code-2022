package puzzles

import inputs.day08Input
import inputs.day08TestInput

fun main() {
    println("day 08 test = " + solveDay08Task(day08TestInput))
    println("day 08 = " + solveDay08Task(day08Input))
    println("day 08 2 part test = " + solveDay08Part2Task(day08TestInput))
    println("day 08 2 part = " + solveDay08Part2Task(day08Input))
}

/**
 * https://adventofcode.com/2022/day/8
 *
 * --- Day 8: Treetop Tree House ---
 * The expedition comes across a peculiar patch of tall trees all planted carefully in a grid. The Elves explain that a previous expedition planted these trees as a reforestation effort. Now, they're curious if this would be a good location for a tree house.
 *
 * First, determine whether there is enough tree cover here to keep a tree house hidden. To do this, you need to count the number of trees that are visible from outside the grid when looking directly along a row or column.
 *
 * The Elves have already launched a quadcopter to generate a map with the height of each tree (your puzzle input). For example:
 *
 * 30373
 * 25512
 * 65332
 * 33549
 * 35390
 * Each tree is represented as a single digit whose value is its height, where 0 is the shortest and 9 is the tallest.
 *
 * A tree is visible if all of the other trees between it and an edge of the grid are shorter than it. Only consider trees in the same row or column; that is, only look up, down, left, or right from any given tree.
 *
 * All of the trees around the edge of the grid are visible - since they are already on the edge, there are no trees to block the view. In this example, that only leaves the interior nine trees to consider:
 *
 * The top-left 5 is visible from the left and top. (It isn't visible from the right or bottom since other trees of height 5 are in the way.)
 * The top-middle 5 is visible from the top and right.
 * The top-right 1 is not visible from any direction; for it to be visible, there would need to only be trees of height 0 between it and an edge.
 * The left-middle 5 is visible, but only from the right.
 * The center 3 is not visible from any direction; for it to be visible, there would need to be only trees of at most height 2 between it and an edge.
 * The right-middle 3 is visible from the right.
 * In the bottom row, the middle 5 is visible, but the 3 and 4 are not.
 * With 16 trees visible on the edge and another 5 visible in the interior, a total of 21 trees are visible in this arrangement.
 *
 * Consider your map; how many trees are visible from outside the grid?
 */
fun solveDay08Task(input: String): Int {
    val grid = parseDay08Input(input)
    val N = grid[0].size
    val M = grid.size

    fun Int.isVisible(i: Int, j: Int): Boolean {
        if (i - 1 == 0) { // edge corner of top
            if (grid[0][j] < this) {
                return true
            }
        }
        if (i + 1 == M - 1) { // edge corner of down
            if (grid[M - 1][j] < this) {
                return true
            }
        }
        if (j - 1 == 0) { // edge corner of left
            if (grid[i][0] < this) {
                return true
            }
        }
        if (j + 1 == N - 1) { // edge corner of right
            if (grid[i][N - 1] < this) {
                return true
            }
        }

        // check top
        if (i - 1 != 0) {
            var isVisible = true
            (0 until i).forEach { k ->
                if (grid[k][j] >= this) {
                    isVisible = false
                }
            }
            if (isVisible) {
                return true
            }
        }
        // check down
        if (i + 1 != M - 1) {
            var isVisible = true
            (i + 1 until M).forEach { k ->
                if (grid[k][j] >= this) {
                    isVisible = false
                }
            }
            if (isVisible) {
                return true
            }
        }
        // check left
        if (j - 1 != 0) {
            var isVisible = true
            (0 until j).forEach { k ->
                if (grid[i][k] >= this) {
                    isVisible = false
                }
            }
            if (isVisible) {
                return true
            }
        }
        // check right
        if (j + 1 != N - 1) {
            var isVisible = true
            (j + 1 until N).forEach { k ->
                if (grid[i][k] >= this) {
                    isVisible = false
                }
            }
            if (isVisible) {
                return true
            }
        }

        return false
    }

    var sum = 0
    (1 until M - 1).forEach { i -> // line, y
        (1 until N - 1).forEach { j -> // row, x
            if (grid[i][j].isVisible(i, j)) {
                sum++
            }
        }
    }

    sum += M * 2 + (N - 2) * 2 // add corners

    return sum
}

/**
 * --- Part Two ---
 * Content with the amount of tree cover available, the Elves just need to know the best spot to build their tree house: they would like to be able to see a lot of trees.
 *
 * To measure the viewing distance from a given tree, look up, down, left, and right from that tree; stop if you reach an edge or at the first tree that is the same height or taller than the tree under consideration. (If a tree is right on the edge, at least one of its viewing distances will be zero.)
 *
 * The Elves don't care about distant trees taller than those found by the rules above; the proposed tree house has large eaves to keep it dry, so they wouldn't be able to see higher than the tree house anyway.
 *
 * In the example above, consider the middle 5 in the second row:
 *
 * 30373
 * 25512
 * 65332
 * 33549
 * 35390
 * Looking up, its view is not blocked; it can see 1 tree (of height 3).
 * Looking left, its view is blocked immediately; it can see only 1 tree (of height 5, right next to it).
 * Looking right, its view is not blocked; it can see 2 trees.
 * Looking down, its view is blocked eventually; it can see 2 trees (one of height 3, then the tree of height 5 that blocks its view).
 * A tree's scenic score is found by multiplying together its viewing distance in each of the four directions. For this tree, this is 4 (found by multiplying 1 * 1 * 2 * 2).
 *
 * However, you can do even better: consider the tree of height 5 in the middle of the fourth row:
 *
 * 30373
 * 25512
 * 65332
 * 33549
 * 35390
 * Looking up, its view is blocked at 2 trees (by another tree with a height of 5).
 * Looking left, its view is not blocked; it can see 2 trees.
 * Looking down, its view is also not blocked; it can see 1 tree.
 * Looking right, its view is blocked at 2 trees (by a massive tree of height 9).
 * This tree's scenic score is 8 (2 * 2 * 1 * 2); this is the ideal spot for the tree house.
 *
 * Consider each tree on your map. What is the highest scenic score possible for any tree?
 */
fun solveDay08Part2Task(input: String): Int {
    val grid = parseDay08Input(input)
    val N = grid[0].size
    val M = grid.size
    val scenicScores = mutableListOf<Int>()

    fun Int.findScenicScore(i: Int, j: Int) {
        var scenicScoreTop = 0
        var scenicScoreBottom = 0
        var scenicScoreLeft = 0
        var scenicScoreRight = 0

        // check top
//        for (k: Int in (0 until i).reversed()) {
        for (k: Int in (0 until i).reversed()) {
            scenicScoreTop++
            if (grid[k][j] >= this) {
                break
            }
        }
        // check down
        for (k: Int in i + 1 until M) {
            scenicScoreBottom++
            if (grid[k][j] >= this) {
                break
            }
        }
        // check left
//        for (k: Int in 0 until j) {
        for (k: Int in (0 until j).reversed()) {
            scenicScoreLeft++
            if (grid[i][k] >= this) {
                break
            }
        }
        // check right
        for (k: Int in j + 1 until N) {
            scenicScoreRight++
            if (grid[i][k] >= this) {
                break
            }
        }

        scenicScores.add(scenicScoreTop * scenicScoreBottom * scenicScoreLeft * scenicScoreRight)
    }

    (1 until M - 1).forEach { i -> // line, y
        (1 until N - 1).forEach { j -> // row, x
            grid[i][j].findScenicScore(i, j)
        }
    }

    return scenicScores.max()
}

fun parseDay08Input(input: String): List<List<Int>> {
    return input.lines()
        .map { line ->
            line.split("")
                .filter { ch ->
                    ch.isNotEmpty()
                }
                .map { ch ->
                    ch.toInt()
                }
        }
}

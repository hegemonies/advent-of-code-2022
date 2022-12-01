package puzzles

import inputs.firstInputData

/**
 * https://adventofcode.com/2022/day/1
 */
fun solveFirst(input: String): Int {
    val elfCalories = input.separateInputToElves()

    return elfCalories.max()
}

fun String.separateInputToElves(): List<Int> {
    var buffer = 0
    val result = mutableListOf<Int>()
    this.split("\n").forEach { line ->
        if (line.isEmpty()) {
            result.add(buffer)
            buffer = 0
            return@forEach
        }

        buffer += line.toInt()
    }

    result.add(buffer)

    return result
}

fun main() {
    println(solveFirst(firstInputData))
}

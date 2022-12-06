package puzzles.day05

import puzzles.TaskStep
import java.util.*

internal object Day05DataProvider {
    val testStackInput = """
[P]    
[F] [N]
        """.trimIndent()
    val firstStack = Stack<String>().apply {
        push("F")
        push("P")
    }
    val secondStack = Stack<String>().apply {
        push("N")
    }

    val testStepsInput = """
        move 1 from 2 to 1
        move 3 from 1 to 2
    """.trimIndent()
    val firstStep = TaskStep(1, 2, 1)
    val secondStep = TaskStep(3, 1, 2)

    const val firstTaskAnswer = "F"
}

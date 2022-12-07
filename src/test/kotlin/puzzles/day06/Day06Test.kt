package puzzles.day06

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import puzzles.isUniqueString
import puzzles.solveDay06Task

internal class Day06Test {

    @Test
    fun `success test of isUniqueString`() {
        val firstActual = isUniqueString("abc")
        val firstExpected = true
        Assertions.assertEquals(firstExpected, firstActual)

        val secondActual = isUniqueString("abcc")
        val secondExpected = false
        Assertions.assertEquals(secondExpected, secondActual)

        val thirdActual = isUniqueString("abcqwera")
        val thirdExpected = false
        Assertions.assertEquals(thirdExpected, thirdActual)
    }

    @Test
    fun `success solve task`() {
        val firstActual = solveDay06Task(Day06DataProvider.firstCode)
        val firstExpected = Day06DataProvider.firstMarker
        Assertions.assertEquals(firstExpected, firstActual)

        val secondActual = solveDay06Task(Day06DataProvider.secondCode)
        val secondExpected = Day06DataProvider.secondMarker
        Assertions.assertEquals(secondExpected, secondActual)

        val thirdActual = solveDay06Task(Day06DataProvider.thirdCode)
        val thirdExpected = Day06DataProvider.thirdMarker
        Assertions.assertEquals(thirdExpected, thirdActual)
    }

    @Test
    fun `success solve task part 2`() {
        val actual = solveDay06Task(Day06DataProvider.firstCode)
        val expected = Day06DataProvider.firstMarker
        Assertions.assertEquals(expected, actual)
    }
}

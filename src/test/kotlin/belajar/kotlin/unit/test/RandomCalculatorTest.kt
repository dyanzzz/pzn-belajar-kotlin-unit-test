package belajar.kotlin.unit.test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

// pada child class
// hanya memanggil ParentCalculatorClass(), nanti otomatis dia akan mengextends semua fitur JUnit yg ada di kalkulator test
// termasuk ada unit testnya juga akan diturunkan di childnya
class RandomCalculatorTest : ParentCalculatorTest() {

    @Test
    fun testRandom(random: Random){
        val first = random.nextInt(1000)
        val second = random.nextInt(1000)

        val result = calculator.add(first, second)
        assertEquals(first + second, result)

        println(first)
        println(second)
        println(result)
    }

    @DisplayName("Test Calculator Random")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandomRepeated(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo){
        println("${testInfo.displayName} ke ${repetitionInfo.currentRepetition} dari ${repetitionInfo.totalRepetitions}")

        val first = random.nextInt(1000)
        val second = random.nextInt(1000)

        val result = calculator.add(first, second)
        assertEquals(first + second, result)

        println(first)
        println(second)
        println(result)
    }

    // menggunakan parameterize test dengan valueSource(parameter berupa, string, int, dl)
    @DisplayName("Test calculator with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [
        10, 20, 30, 40, 50
    ])
    fun testWithParameter(value: Int){
        val result = calculator.add(value, value)
        assertEquals(value + value, result)

        println(result)
    }

    companion object {
        @JvmStatic
        fun parameterSource(): List<Int>{
            return listOf(10, 20, 30, 40, 50)
        }
    }

    // menggunakan parameterize test dengan methodSource
    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value: Int){
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
        println(result)
    }
}
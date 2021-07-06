package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException

// @DisplayName("Test for Calculator Class")
// memanggil class display name generator yg sudah dibuat sebelumnya
// jika membuat display name generator ini, maka tidak perlu lagi membuat display name pada masing" function, karena sudah dibuat pada generator classnya
@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class CalculatorTest {

    // jika hanya ingin menjalankan 1 kali sebelum semua unit test berjalan. gunakan
    // @BeforeAll / @AfterAll
    // syaratnya harus membuat static function/ object function
    // scopenya hanya pada class function yg sama
    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll(){
            println("Sebelum unit test BeforeAll dijalankan")
        }

        @JvmStatic
        @AfterAll
        fun afterAll(){
            println("Setelah unit test AfterAll dijalankan")
        }
    }

    private val calculator = Calculator()

    //@DisplayName("Test for function Calculator.add(10, 10)")
    @Test
    fun testAddSuccess(){
        println("Unit test testAddSuccess")
        val result = calculator.add(10, 10)
        // menggunakan assertEquals pada kotlin
        assertEquals(20, result, "Hasil harusnya 20")
    }

    // testing sukses divide ketika sencond value not zero
    //@DisplayName("Test for function Calculator.divide(20, 10)")
    @Test
    fun testDivideSuccess(){
        println("Unit test testDivideSuccess")
        val result = calculator.divide(20, 10)
        assertEquals(2, result, "Hasilnya harusnya 2")
    }

    // testing dengan memastikian masuk ke dalam kondisi throw exception
    //@DisplayName("Test for function assetThrowException")
    @Test
    fun testDivideFailed(){
        println("Unit test testDivideFailed")
        assertThrows<IllegalArgumentException> {
            calculator.divide(0, 0)
        }
    }

    // menonaktifkan test / ignore test
    @Disabled("Coming Soon!")
    @Test
    fun testComingSoon() {
        println("Unit test testComingDSoon")
        println("Under Construction")
    }

    // function testing yg dilakukan sebelum function test lain dijalankan, dijalankan terus berulang ulang
    // @BeforeEach
    @Test
    @Disabled("Before each ga dipake dulu")
    fun beforeEach(){
        println("Sebelum unit test dijalankan")
    }

    // function testing yg dilakukan setelah function test lain dijalankan, dijalankan terus berulang ulang
    // @AfterEach
    @Test
    @Disabled("After each ga dipake dulu")
    fun afterEach(){
        println("Setelah unit test dijalankan")
    }

    @Test
    fun testAborted(){
        val profile = System.getenv()["PROFILE"]

        if("DEV" != profile) {
            // membatalkan unit test. dengan throw exception TestAbortedException()
            throw TestAbortedException()
        }

        println("Test Not Aborted because Dev Profile.")
    }

    @Test
    fun testAssumptions(){
        val profile = System.getenv()["PROFILE"]

        // jika true, maka tidak dibatalkan
        // jika false, maka unit testnya akan dibatalkan
        assumeTrue("DEV" == profile)

        println("Test Not Aborted because Dev Profile.")
    }

}
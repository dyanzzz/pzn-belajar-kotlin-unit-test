package belajar.kotlin.unit.test

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

// unit test didalam unit test
// class seperti biasanya, tapi harus pake annotation @Nested
// dan class yg di buat di dalam class, harus menggunakan interface inner class
class NestedTest {
    @Test
    fun test1(){

    }

    @Nested
    inner class MyNestedTest{
        @Test
        fun test2(){

        }
    }
}
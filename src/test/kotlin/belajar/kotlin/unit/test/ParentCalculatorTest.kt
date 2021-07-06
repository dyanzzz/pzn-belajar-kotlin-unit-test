package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.resolver.RandomParameterResolver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

// membuat pewarisan di JUnit/ Inheritance
// parent calculator test
@Extensions(value = [
    ExtendWith(RandomParameterResolver::class)
])
// karena parent, menjadikan abstract
abstract class ParentCalculatorTest {

    // mendefined class calculator
    val calculator = Calculator();

    @BeforeEach
    fun beforeEach(){
        println("before each")
    }
}
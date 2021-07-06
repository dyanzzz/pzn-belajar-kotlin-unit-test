package belajar.kotlin.unit.test

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

// membuat anotation tag untuk unit test
// setup untuk grouping unit test di build.gradle
@Tag("integration-test")
class SampleIntegrationTest {

    @Test
    fun tagSample1(){

    }

    @Test
    fun tagSample2(){

    }
}
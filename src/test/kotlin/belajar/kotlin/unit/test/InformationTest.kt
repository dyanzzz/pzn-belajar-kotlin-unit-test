package belajar.kotlin.unit.test

import org.junit.jupiter.api.*

@DisplayName("Test with TestInfo")
class InformationTest {

    @Test
    @Tags(value = [
        Tag("contohTag1"),
        Tag("contohTag2")
    ])
    @DisplayName("sample test function 1")
    fun sampleTestFunction(testInfo: TestInfo){
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testClass)
        println(testInfo.testMethod)
    }
}
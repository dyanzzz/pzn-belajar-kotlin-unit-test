package belajar.kotlin.unit.test.generator

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

// membuat display description name generator
class SimpleDisplayNameGenerator : DisplayNameGenerator{
    override fun generateDisplayNameForClass(testClass: Class<*>?): String {
        return "Test ${testClass?.simpleName}"
    }

    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>?): String {
        return "Test ${nestedClass?.simpleName}"
    }

    override fun generateDisplayNameForMethod(testClass: Class<*>?, testMethod: Method?): String {
        return "Tes ${testClass?.simpleName}.${testMethod?.name}"
    }
}
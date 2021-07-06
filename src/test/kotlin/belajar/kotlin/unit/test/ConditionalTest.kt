package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.WINDOWS])
    fun enabledOnWindows(){
        // only run in windows
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun disabledOnWindows(){
        // cannot run on windows
    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_11])
    fun enabledOnJre11(){

    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_11])
    fun disabledOnJre11(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    fun enabledOnJreRange8To11(){

    }

    @Test
    fun printSystemProperties(){
        // melihat system properties
        System.getProperties().forEach { key, value ->
            println("$key => $value")
        }
    }

    @Test
    // jika hanya 1 variable
    //@EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    // jika lebih dari 1 variable
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun enabledOnOracle(){

    }

    @Test
    // jika hanya 1 variable
    //@DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    // jika lebih dari 1 variable
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnOracle(){

    }

    @Test
    // jika hanya 1 variable
    //@EnabledIfEnvironmentVariable(named = "java.vendor", matches = "Oracle Corporation")
    // jika lebih dari 1 variable
    @EnabledIfEnvironmentVariables(value = [
        EnabledIfEnvironmentVariable(named = "PROFILE", matches = "Dev")
    ])
    fun enabledOnDev(){

    }

    @Test
    // DisabledIfEnvironmentVariable // jika hanya 1 variable
    //@DisabledIfEnvironmentVariable(named = "java.vendor", matches = "Oracle Corporation")
    // DisabledIfEnvironmentVariables // jika lebih dari 1 variable
    @DisabledIfEnvironmentVariables(value = [
        DisabledIfEnvironmentVariable(named = "PROFILE", matches = "Dev")
    ])
    fun disabledOnDev(){

    }
}
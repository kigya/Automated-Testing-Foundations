package assumptions

import Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

internal class Assumptions {
    private val calculator = Calculator()

    @Test
    fun testOnlyOnCiServer() {
        Assumptions.assumeTrue("CI" == System.getenv("ENV"))
    }

    fun testOnlyOnDeveloperWorkstation() {
        Assumptions.assumeTrue("DEV" == System.getenv("ENV")) {
            "Aborting test: not on developer workstation"
        }
    }

    @Test
    @RepeatedTest(2)
    fun testInAllEnvironments() {
        println(System.getenv())
        System.setProperty("ENV", "CI");

        Assumptions.assumingThat("CI" == System.getProperty("ENV")) {
            Assertions.assertEquals(4, calculator.divide(4, 2))
        }

        Assertions.assertEquals(42, calculator.multiply(6, 7))
    }
}
package assertions

import Calculator
import Gender
import Person
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.function.Executable
import org.opentest4j.AssertionFailedError
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.Duration
import kotlin.test.assertFailsWith

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Assertions {
    private lateinit var calculator: Calculator
    private lateinit var person: Person

    @BeforeAll
    fun beforeAll() {
        calculator = Calculator()
        person = Person("Jane", "Doe")
    }

    @Test
    @Tag("feature-168")
    @DisplayName("Standart Operations")
    fun standardAssertions() {
        Assertions.assertEquals(2, calculator.add(1, 1))
        Assertions.assertEquals(0, calculator.subtract(1, 1))
        Assertions.assertEquals(1, calculator.divide(1, 1))
        Assertions.assertEquals(4, calculator.multiply(2, 2), "Error when multiplying 2 by 2!")
    }

    @Test
    @Tag("feature-429")
    @DisplayName("Grouped Operations")
    fun groupedAssertions() {
        Assertions.assertAll("person",
            Executable { Assertions.assertEquals("Jane", person.firstName) },
            Executable { Assertions.assertEquals("Doe", person.lastName) }
        )
    }

    @Test
    @Tag("feature-402")
    @DisplayName("Dependent Operations")
    fun dependentAssertions() {
        Assertions.assertAll("properties",
            Executable {
                val firstName = person.firstName
                Assertions.assertNotNull(firstName)
                Assertions.assertAll("first name",
                    Executable { Assertions.assertTrue(firstName.startsWith("J")) },
                    Executable { Assertions.assertTrue(firstName.endsWith("e")) }
                )
            },
            Executable {
                val lastName = person.lastName
                Assertions.assertNotNull(lastName)
                Assertions.assertAll("last name",
                    Executable { Assertions.assertTrue(lastName!!.startsWith("D")) },
                    Executable { Assertions.assertTrue(lastName!!.endsWith("e")) }
                )
            }
        )
    }

    @Test
    @Tag("feature-162")
    @DisplayName("Exception Testing")
    fun exceptionTesting() {
        val exception: Exception = Assertions.assertThrows(ArithmeticException::class.java) {
            calculator.divide(1, 0)
        }
        Assertions.assertEquals("/ by zero", exception.message)
    }

    @Test
    @DisplayName("Timeout Not Exceeded")
    fun timeoutNotExceeded() {
        Assertions.assertTimeout(Duration.ofNanos(2)) {}
        Assertions.assertTimeout(Duration.ofMillis(2)) {}
        Assertions.assertTimeout(Duration.ofSeconds(2)) {}
        Assertions.assertTimeout(Duration.ofMinutes(2)) {}
        Assertions.assertTimeout(Duration.ofDays(2)) {}
    }

    @Test
    fun `timeout not exceeded with result`() {
        val actualResult = Assertions.assertTimeout<String>(Duration.ofMinutes(2)) {
            "a result"
        }
        Assertions.assertEquals("a result", actualResult)
    }

    @Test
    @DisplayName("Timeout Not Exceeded With Method")
    fun timeoutNotExceededWithMethod() {
        val actualGreeting = Assertions.assertTimeout<String>(Duration.ofMinutes(2)) {
            greeting()
        }
        Assertions.assertEquals("Hello, World!", actualGreeting)
    }

    @Test
    @DisplayName("Timeout Exception")
    fun timeoutExceeded() {

        assertFailsWith<AssertionFailedError> {
            Assertions.assertTimeout(Duration.ofMillis(10)) {
                Thread.sleep(100)
            }

            Assertions.assertTimeout(Duration.ofMillis(10), {
                Thread.sleep(100)
            }, "Timeout exceeded!")
        }
    }

    // Data Driven
    @TestFactory
    @DisplayName("Dynamic Tests")
    fun dynamicTests(): List<DynamicTest> {
        return listOf(
            dynamicTest("1st dynamic test") {
                Assertions.assertTrue(true)
            },
            dynamicTest("2nd dynamic test") {
                Assertions.assertEquals(4, calculator.multiply(2, 2))
            }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["F", "M"])
    @DisplayName("Parameterized Test")
    @Tag("feature-112")
    fun genders(word: String) {
        Assertions.assertTrue(word == Gender.F.name || word == Gender.M.name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["F", "M", "X"])
    @DisplayName("Parameterized Test New")
    @Disabled
    fun gendersUpdate(word: String) {
        Assertions.assertTrue(word == Gender.F.name || word == Gender.M.name)
    }

    companion object {
        private fun greeting(): String {
            return "Hello, World!"
        }
    }
}
package tests

import driver.Driver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver

open class CommonConditions {
    private var _driver: WebDriver? = null
    protected val driver: WebDriver
        get() = _driver!!

    @BeforeEach
    fun setUp() {
        _driver = Driver.get()
    }

    @AfterEach
    fun stopBrowser() {
        Driver.closeDriver()
    }
}
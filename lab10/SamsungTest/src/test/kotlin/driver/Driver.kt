package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.jetbrains.annotations.TestOnly
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

object Driver {

    private var driver: WebDriver? = null

    @TestOnly
    fun get(): WebDriver {
        if (driver == null) {
            val browser = System.getProperty(SystemProperty.BROWSER)
            driver = when (browser) {
                Chrome.name -> getChromeDriver()
                Firefox.name -> getFirefoxDriver()
                else -> getChromeDriver()
            }
        }
        driver?.manage()?.window()?.size = Dimension(1920, 1080)
        return driver!!
    }

    @TestOnly
    private fun getChromeDriver(): WebDriver {
        val options = ChromeOptions().apply {
            addArguments("--window-size=1920,1080")
        }
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(options)
    }

    private fun getFirefoxDriver(): WebDriver {
        val options = FirefoxOptions().apply {
            addArguments("--window-size=1920,1080")
        }
        WebDriverManager.firefoxdriver().setup()
        return FirefoxDriver(options)
    }

    @TestOnly
    fun closeDriver() {
        driver?.quit()
        driver = null
    }
}
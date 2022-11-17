package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


object Driver {

    private var driver: WebDriver? = null

    fun get(): WebDriver {
        driver = getChromeDriver()
        driver!!.manage().window().maximize()
        return driver!!
    }

    private fun getChromeDriver(): WebDriver {
        val options = ChromeOptions().apply {
            addArguments("--window-size=1920,1080")
        }
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(options)
    }

    fun closeDriver() {
        driver?.quit()
        driver = null
    }
}
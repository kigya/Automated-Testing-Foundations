package page.main

import conditions.PageLoadedCondition
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.common.Page
import page.cart.CartPage
import page.devices.GalaxyZFold4Page
import page.links.Url
import utils.Const
import utils.Logger
import java.time.Duration

class MainPage(driver: WebDriver) : Page(driver) {

    fun openPage(): MainPage {
        Logger.info("Opening main page")
        driver[Url.MAIN]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }

    fun clickSearch(): MainPage {
        Logger.info("Clicking search button")
        searchIcon.click()
        return this
    }

    fun enterSearchText(text: String): MainPage {
        Logger.info("Entering search text: $text")
        searchField.clear()
        searchField.sendKeys(text)
        return this
    }

    fun clickSubmit(): GalaxyZFold4Page {
        Logger.info("Clicking submit button")
        searchField.sendKeys(Keys.ENTER)
        return GalaxyZFold4Page(driver).openPage()
    }

    fun navigateToCart(): CartPage {
        Logger.info("Navigating to cart page")
        сartIcon.click()
        return CartPage(driver).openPage()
    }

}
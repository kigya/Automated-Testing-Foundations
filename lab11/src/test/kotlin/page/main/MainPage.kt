package page.main

import conditions.PageLoadedCondition
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.common.Page
import page.cart.CartPage
import page.utils.ClassName
import utils.constants.Url
import utils.constants.Const
import utils.extensions.getElementByClassName
import utils.logger.Logger
import java.time.Duration

class MainPage(driver: WebDriver) : Page(driver) {

    private val errorBlock by lazy {
        Logger.info("Error block has been initialized")
        driver.getElementByClassName(ClassName.MainPage.TRY_AGAIN)
    }

    override fun openPage(): MainPage {
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

    fun <T : Page> clickSubmit(page: T): Page {
        Logger.info("Clicking submit button")
        searchField.sendKeys(Keys.ENTER)
        return page.openPage()
    }

    fun navigateToCart(): CartPage {
        Logger.info("Navigating to cart page")
        сartIcon.click()
        return CartPage(driver).openPage()
    }

    fun isErrorDisplayed(): Boolean {
        Logger.info("Checking that error is displayed")
        return errorBlock.isDisplayed
    }

}
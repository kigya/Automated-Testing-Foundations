package page.search

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.common.Page
import page.utils.ClassName
import utils.constants.Const
import utils.constants.Url
import utils.extensions.getElementByClassName
import utils.logger.Logger
import java.time.Duration

class SearchPage(driver: WebDriver, private val endPoint: String) : Page(driver) {

    private val controlBarResults by lazy {
        Logger.info("Control bar results has been initialized")
        driver.getElementByClassName(ClassName.SearchPage.CONTROL_BAR_RESULTS)
    }

    private val productsCheckbox by lazy {
        Logger.info("Products checkbox has been initialized")
        driver.getElementByClassName(ClassName.SearchPage.CATEGORY_PRODUCTS_CHECKBOX)
    }

    override fun openPage(): Page {
        Logger.info("Opening search page")
        driver[Url.SEARCH_BASE + endPoint]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }

    fun isResultsNotEmpty(): Boolean {
        Logger.info("Checking that results are not empty")
        return controlBarResults.isDisplayed
    }

    fun clickProductsCheckbox(): SearchPage {
        Logger.info("Clicking products checkbox")
        productsCheckbox.click()
        return this
    }
}
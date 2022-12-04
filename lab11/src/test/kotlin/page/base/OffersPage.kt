package page.base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import page.base.common.Page
import page.checkout.CheckoutPage
import page.utils.XPath
import utils.extensions.getElementByXPath
import utils.logger.Logger

abstract class OffersPage(driver: WebDriver) : Page(driver) {

    private val title: WebElement by lazy {
        Logger.info("Title has been initialized")
        driver.getElementByXPath(XPath.OffersPage.PAGE_TITLE)
    }

    private val skipButton: WebElement by lazy {
        Logger.info("Skip button has been initialized")
        driver.getElementByXPath(XPath.OffersPage.SKIP_ADDONS_BUTTON)
    }

    fun clickSkipButton(): CheckoutPage {
        Logger.info("Clicking skip button")
        skipButton.click()
        return CheckoutPage(driver).openPage()
    }

}
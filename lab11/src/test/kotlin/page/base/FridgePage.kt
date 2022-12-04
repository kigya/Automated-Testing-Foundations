package page.base

import org.openqa.selenium.WebDriver
import page.base.common.Page
import page.bundle.BuildBundlePage
import page.utils.XPath
import utils.extensions.getElementByXPath
import utils.logger.Logger

abstract class FridgePage(driver: WebDriver) : Page(driver) {

    private val completeKitchenButton by lazy {
        Logger.info("Complete kitchen button has been initialized")
        driver.getElementByXPath(XPath.FridgePage.BUNDLE_BUTTON)
    }

    fun clickCompleteKitchenButton(): BuildBundlePage {
        Logger.info("Clicking complete kitchen button")
        completeKitchenButton.click()
        return BuildBundlePage(driver).openPage()
    }

}
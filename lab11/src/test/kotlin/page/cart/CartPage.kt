package page.cart

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import page.base.common.Page
import page.utils.ClassName
import utils.logger.Logger
import utils.extensions.getElementByClassName

class CartPage(driver: WebDriver) : Page(driver) {

    private val itemsCounter: WebElement by lazy {
        Logger.info("Items counter has been initialized")
        driver.getElementByClassName(ClassName.CartPage.ITEMS_COUNTER)
    }

    override fun openPage(): CartPage {
        Logger.info("Opened cart page")
        return this
    }

    fun isNoItemsDisplayed(): Boolean {
        Logger.info("Checked that no items in cart")
        return itemsCounter.text.isEmpty()
    }

    fun isItemsDisplayed(): Boolean {
        Logger.info("Checked that no items in cart")
        return itemsCounter.isDisplayed
    }

}
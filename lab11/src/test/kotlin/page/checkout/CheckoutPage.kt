package page.checkout

import org.openqa.selenium.WebDriver
import page.base.common.Page
import page.utils.ClassName
import utils.extensions.getElementByClassName
import utils.extensions.getElementsByClassName
import utils.logger.Logger

class CheckoutPage(driver: WebDriver) : Page(driver) {

    private val checkoutList by lazy {
        Logger.info("Checkout list has been initialized")
        driver.getElementsByClassName(ClassName.CheckoutPage.CHECKOUT_LIST)
    }

    private val cartIcon by lazy {
        Logger.info("Cart icon has been initialized")
        driver.getElementByClassName(ClassName.CheckoutPage.CART_ICON)
    }

    override fun openPage(): CheckoutPage {
        Logger.info("Opened checkout page")
        return this
    }

    fun isCheckoutTitleDisplayed(): Boolean {
        Logger.info("Checked that checkout title is displayed")
        return checkoutList.isNotEmpty()
    }

    fun checkIfCartIsNotEmpty(): Boolean {
        Logger.info("Checked that cart is not empty")
        return cartIcon.isDisplayed
    }


}
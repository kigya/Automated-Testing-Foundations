package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import utils.getElement

class CartPage(driver: WebDriver) : Page(driver) {

    @FindBy(xpath = XPath.Cart.CONTINUE_SHOPPING_BUTTON)
    private lateinit var statusText: WebElement

    fun openPage(): CartPage {
        return this
    }

    fun isContinueButtonDisplayed(): Boolean {
        return driver.getElement(XPath.Cart.CONTINUE_SHOPPING_BUTTON).isDisplayed
    }

}
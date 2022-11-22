package page.cart

import net.thucydides.core.annotations.WhenPageOpens
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import page.common.Page
import page.utils.XPath
import ru.yandex.qatools.htmlelements.annotations.Name
import utils.Logger

class CartPage(driver: WebDriver) : Page(driver) {

    @Name("Continue shopping button visible on empty cart page")
    @FindBy(xpath = XPath.Cart.CONTINUE_SHOPPING_BUTTON)
    private lateinit var continueButton: WebElement

    fun openPage(): CartPage {
        Logger.info("Opened cart page")
        return this
    }

    @WhenPageOpens
    fun isContinueButtonDisplayed(): Boolean {
        Logger.info("Checked that continue shopping button is displayed")
        return continueButton.isDisplayed
    }

}
package page

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait
import utils.Const
import java.time.Duration

class MainPage(driver: WebDriver) : Page(driver) {

    @FindBy(xpath = XPath.Main.PROFILE_ICON)
    private lateinit var profileIcon: WebElement

    @FindBy(xpath = XPath.Main.SIGN_IN_BUTTON)
    private lateinit var signInButton: WebElement

    @FindBy(xpath = XPath.Main.CART_ICON)
    private lateinit var сartIcon: WebElement

    fun openPage(): MainPage {
        driver[Const.Url.MAIN]
        WebDriverWait(
            driver,
            Duration.ofSeconds(5)
        ).until(PageLoadedCondition())
        return this
    }

    fun navigateToCart(): CartPage {
        сartIcon.click()
        return CartPage(driver).openPage()
    }

}
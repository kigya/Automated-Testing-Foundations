package page

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait
import utils.Const
import java.time.Duration

class GalaxyZFold4OffersPage(driver: WebDriver) : Page(driver) {

    @FindBy(xpath = XPath.Galaxy_Z_Fold4_Offers.PAGE_TITLE)
    private lateinit var title: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4_Offers.SKIP_ADDONS_BUTTON)
    private lateinit var skipButton: WebElement

    fun openPage(): GalaxyZFold4OffersPage {
        driver[Const.Url.GALAXY_Z_FOLD4_OFFERS]
        WebDriverWait(
            driver,
            Duration.ofSeconds(5)
        ).until(PageLoadedCondition())
        return this
    }

    fun clickSkip(): GalaxyZFold4OffersPage {
        skipButton.click()
        return this
    }

    fun isTitleNotEmpty(): Boolean {
        return title.text.isNotEmpty()
    }
}
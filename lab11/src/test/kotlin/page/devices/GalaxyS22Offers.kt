package page.devices

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.OffersPage
import utils.constants.Url
import utils.constants.Const
import utils.logger.Logger
import java.time.Duration

class GalaxyS22Offers(driver: WebDriver) : OffersPage(driver) {

    override fun openPage(): GalaxyS22Offers {
        Logger.info("Opening main page")
        driver[Url.GALAXY_S22_OFFERS]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }
}
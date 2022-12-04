package page.refrigerator

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.FridgePage
import utils.constants.Const
import utils.constants.Url
import utils.logger.Logger
import java.time.Duration

class BespokeCounterPage(driver: WebDriver) : FridgePage(driver) {

    override fun openPage(): BespokeCounterPage {
        Logger.info("Opening main page")
        driver[Url.BESPOKE]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }
}
package page.devices

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.DevicePage
import utils.constants.Url
import utils.constants.Const
import utils.logger.Logger
import java.time.Duration

class GalaxyS22Page(driver: WebDriver) : DevicePage(driver) {

    override fun openPage(): GalaxyS22Page {
        Logger.info("Opening main page")
        driver[Url.GALAXYS22]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }
}
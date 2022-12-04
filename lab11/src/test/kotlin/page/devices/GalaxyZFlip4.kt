package page.devices

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.DevicePage
import page.base.common.Page
import utils.constants.Const
import utils.logger.Logger
import utils.constants.Url
import java.time.Duration

class GalaxyZFlip4(driver: WebDriver) : DevicePage(driver) {

    override fun openPage(): Page {
        Logger.info("Opening main page")
        driver[Url.GALAXY_Z_FLIP4]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }
}
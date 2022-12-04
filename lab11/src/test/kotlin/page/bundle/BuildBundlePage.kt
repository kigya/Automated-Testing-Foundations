package page.bundle

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.base.common.Page
import page.utils.ClassName
import utils.constants.Const
import utils.constants.Url
import utils.extensions.getElementByClassName
import utils.logger.Logger
import java.time.Duration

class BuildBundlePage(driver: WebDriver) : Page(driver) {

    private val title by lazy {
        Logger.info("Title has been initialized")
        driver.getElementByClassName(ClassName.BundlePage.TITLE)
    }

    override fun openPage(): BuildBundlePage {
        Logger.info("Opening main page")
        driver[Url.BUNDLE]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }

    fun getTitle(): String {
        Logger.info("Getting title")
        return title.text
    }
}
package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class Page(protected val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

}
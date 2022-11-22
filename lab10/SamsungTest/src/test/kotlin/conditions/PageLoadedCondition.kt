package conditions

import org.jetbrains.annotations.TestOnly
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition

class PageLoadedCondition : ExpectedCondition<Boolean> {
    @TestOnly
    override fun apply(driver: WebDriver?): Boolean =
        (driver as JavascriptExecutor).executeScript("return document.readyState") == "complete"
}
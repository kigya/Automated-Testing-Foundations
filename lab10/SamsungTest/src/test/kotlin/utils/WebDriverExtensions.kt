package utils

import org.jetbrains.annotations.TestOnly
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

@TestOnly
fun WebDriver.getElement(xpath: String): WebElement {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))
}

@TestOnly
fun WebDriver.getElements(xpath: String): List<WebElement> {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)))
}
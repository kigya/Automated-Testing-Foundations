package utils.extensions

import org.jetbrains.annotations.TestOnly
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.constants.Const
import java.time.Duration

@TestOnly
fun WebDriver.getElementByXPath(xpath: String): WebElement {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))
}

@TestOnly
fun WebDriver.getElementsByXpath(xpath: String): List<WebElement> {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)))
}

@TestOnly
fun WebDriver.getElementByClassName(className: String): WebElement {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfElementLocated(By.className(className)))
}

@TestOnly
fun WebDriver.getElementsByClassName(className: String): List<WebElement> {
    return WebDriverWait(this, Duration.ofSeconds(Const.DEFAULT_TIMEOUT))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(className)))
}
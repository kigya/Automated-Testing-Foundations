package page.base.common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import page.utils.XPath
import utils.extensions.getElementByXPath

@Suppress("LeakingThis")
abstract class Page(protected val driver: WebDriver): Header {

    override val profileIcon: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.PROFILE_ICON)
    }

    override val signInButton: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.SIGN_IN_BUTTON)
    }

    override val сartIcon: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.CART_ICON)
    }

    override val searchIcon: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.SEARCH_ICON)
    }

    override val searchField: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.SEARCH_FIELD)
    }

    override val submitSearch: WebElement by lazy {
        driver.getElementByXPath(XPath.Header.SEARCH_FIELD_SUBMIT)
    }

    abstract fun openPage(): Page

    init {
        PageFactory.initElements(driver, this)
    }

}
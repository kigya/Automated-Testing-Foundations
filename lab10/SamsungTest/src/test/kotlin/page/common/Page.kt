package page.common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import page.utils.XPath
import ru.yandex.qatools.htmlelements.annotations.Name

abstract class Page(protected val driver: WebDriver): Header {

    @Name("Header profile icon")
    @FindBy(xpath = XPath.Header.PROFILE_ICON)
    override lateinit var profileIcon: WebElement

    @Name("Header sign in button")
    @FindBy(xpath = XPath.Header.SIGN_IN_BUTTON)
    override lateinit var signInButton: WebElement

    @Name("Header cart icon")
    @FindBy(xpath = XPath.Header.CART_ICON)
    override lateinit var сartIcon: WebElement

    @Name("Header search icon")
    @FindBy(xpath = XPath.Header.SEARCH_ICON)
    override lateinit var searchIcon: WebElement

    @Name("Header search field")
    @FindBy(xpath = XPath.Header.SEARCH_FIELD)
    override lateinit var searchField: WebElement

    @Name("Header search field submit")
    @FindBy(xpath = XPath.Header.SEARCH_FIELD_SUBMIT)
    override lateinit var submitSearch: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

}
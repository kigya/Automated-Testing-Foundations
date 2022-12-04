package page.base.common

import org.openqa.selenium.WebElement

interface Header {
    val profileIcon: WebElement
    val signInButton: WebElement
    val сartIcon: WebElement
    val searchIcon: WebElement
    val searchField: WebElement
    val submitSearch: WebElement
}
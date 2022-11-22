package page.common

import org.openqa.selenium.WebElement

interface Header {
    var profileIcon: WebElement
    var signInButton: WebElement
    var сartIcon: WebElement
    var searchIcon: WebElement
    var searchField: WebElement
    var submitSearch: WebElement
}
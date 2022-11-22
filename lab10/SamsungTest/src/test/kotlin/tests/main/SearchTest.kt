package tests.main

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import page.main.MainPage
import tests.CommonConditions
import utils.Const
import utils.annotations.ExpectedResult

@Tag("search")
class SearchTest : CommonConditions() {


    /*
     * --- Preconditions:
     *      Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/
     * --- Steps:
     *      1. Click search icon in header
     *      2. Type "Galaxy Z Flip4" and press Enter for searching for a query
     */
    @Test
    @Tag("search-1")
    @DisplayName("Searching for an existent item")
    @ExpectedResult("Page with Galaxy Z Flip4 device has been successfully opened")
    @Execution(ExecutionMode.CONCURRENT)
    fun `searching for an item`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        val expectedTitle = Const.Search.GALAXY_Z_FOL4_TITLE
        mainPage.enterSearchText(expectedTitle)
        val fold = mainPage.clickSubmit()
        assertThat(fold.getTitle(), `is`(expectedTitle))
    }

}
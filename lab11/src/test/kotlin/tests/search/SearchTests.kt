package tests.search

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import page.base.DevicePage
import page.devices.GalaxyS22Page
import page.devices.GalaxyZFlip4

import page.main.MainPage
import page.search.SearchPage
import tests.CommonConditions
import utils.constants.Const
import utils.annotations.ExpectedResult
import utils.annotations.Id
import utils.annotations.Tag
import utils.generateRandomString

@Tag("search")
class SearchTests : CommonConditions() {

    @Test
    @Id("TC-1")
    @ExpectedResult("Page with Galaxy s22 via query has been successfully opened")
    @Execution(ExecutionMode.CONCURRENT)
    fun `searching for an item`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        val expectedTitle = Const.Search.GALAXYS22_TITLE
        mainPage.enterSearchText(expectedTitle)
        val s22 = mainPage.clickSubmit(GalaxyS22Page(driver)) as DevicePage
        assertThat(s22.getTitle(), `is`(expectedTitle))
    }

    @Test
    @Id("TC-2")
    @ExpectedResult("Page with Galaxy Z Flip4 device has been successfully opened by empty query")
    @Execution(ExecutionMode.CONCURRENT)
    fun `searching for a default item`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        val expectedTitle = Const.Search.GALAXY_Z_FLIP4
        val emptyQuery = ""
        mainPage.enterSearchText(emptyQuery)
        val flip = mainPage.clickSubmit(GalaxyZFlip4(driver)) as DevicePage
        assertThat(flip.getTitle(), `is`(expectedTitle))
    }

    @Test
    @Id("TC-3")
    @ExpectedResult("Invalid searching for result does not display any items")
    @Execution(ExecutionMode.CONCURRENT)
    fun `searching for non-existing item`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        mainPage.enterSearchText(generateRandomString(20))
        val page = mainPage.clickSubmit(MainPage(driver))
        assertThat(page !is DevicePage,`is`(true))
    }

    @Test
    @Id("TC-4")
    @ExpectedResult("Control bar is not empty")
    @Execution(ExecutionMode.CONCURRENT)
    fun `check a query that does not give accurate results`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        val query = "iphone"
        mainPage.enterSearchText(query)
        val search = mainPage.clickSubmit(SearchPage(driver, query)) as SearchPage
        val expectedResult = true
        assertThat(search.isResultsNotEmpty(),`is`(expectedResult))
    }

    @Test
    @Id("TC-5")
    @ExpectedResult("Filtering search have been successfully applied")
    @Execution(ExecutionMode.CONCURRENT)
    fun `check filtering`() {
        val mainPage = MainPage(driver).openPage()
        mainPage.clickSearch()
        val query = "galaxy"
        mainPage.enterSearchText(query)
        val search = mainPage.clickSubmit(SearchPage(driver, query)) as SearchPage
        search.clickProductsCheckbox()
        val expectedResult = true
        assertThat(search.isResultsNotEmpty(),`is`(expectedResult))
    }

}

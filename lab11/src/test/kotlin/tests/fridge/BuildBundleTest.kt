package tests.fridge

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import page.refrigerator.BespokeCounterPage
import tests.CommonConditions
import utils.annotations.ExpectedResult
import utils.annotations.Id
import utils.annotations.Tag

@Tag("fridge")
class BuildBundleTest : CommonConditions() {

    @Test
    @Id("TC-1")
    @ExpectedResult("Bespoke counter page is opened")
    @Execution(ExecutionMode.CONCURRENT)
    fun `check build your bundle feature`() {
        val fridgePage = BespokeCounterPage(driver).openPage()
        val bundle = fridgePage.clickCompleteKitchenButton()
        val expectedTitle = "Build Your Own Bundle"
        MatcherAssert.assertThat(bundle.getTitle(), `is`(expectedTitle))
    }
}
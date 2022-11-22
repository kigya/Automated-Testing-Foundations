package tests.cart

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import page.main.MainPage
import tests.CommonConditions
import utils.annotations.ExpectedResult

@Tag("cart")
class CartTests : CommonConditions() {

    /*
     * --- Preconditions:
     *      Internet connection, Browser Google Chrome v.106.0.5249.119,
     *      opened https://www.samsung.com/us/, user is pre-registered on the site, no items on cart added
     * --- Steps:
     *      1. Click Cart icon
     */
    @Test
    @Tag("cart-3")
    @DisplayName("Viewing Samsung empty bag page")
    @ExpectedResult("Continue shopping button is displayed")
    @Execution(ExecutionMode.CONCURRENT)
    fun `viewing empty bag`() {
        val mainPage = MainPage(driver).openPage()
        val cartPage = mainPage.navigateToCart()
        val expectedDisplayStatus = true
        assertThat(cartPage.isContinueButtonDisplayed(), `is`(expectedDisplayStatus))
    }

}



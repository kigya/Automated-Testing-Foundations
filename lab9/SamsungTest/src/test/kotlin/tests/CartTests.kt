package tests

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import page.MainPage

class CartTests : CommonConditions() {

    /*
     * Id:
     *      Cart-3
     * Name:
     *      Viewing empty bag
     * Preconditions:
     *      Internet connection, Browser Google Chrome v.106.0.5249.119,
     *      opened https://www.samsung.com/us/, user is pre-registered on the site, no items on cart added
     * Steps:
     *      1. Click Cart icon
     * Expected result:
     *      Your cart is empty message shown
     */
    @Test
    fun viewingEmptyCart() {
        val mainPage = MainPage(driver)
            .openPage()
        val cartPage = mainPage.navigateToCart()
        val expectedDisplayStatus = true
        assertThat(cartPage.isContinueButtonDisplayed(), `is`(expectedDisplayStatus))
    }

}



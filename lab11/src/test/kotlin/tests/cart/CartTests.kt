package tests.cart


import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import page.devices.GalaxyS22Offers
import page.devices.GalaxyS22Page
import page.main.MainPage
import tests.CommonConditions
import utils.annotations.ExpectedResult
import utils.annotations.Id
import utils.annotations.Tag

@Tag("cart")
class CartTests : CommonConditions() {

    @Test
    @Id("TC-1")
    @ExpectedResult("Empty counter displayed")
    @Execution(ExecutionMode.CONCURRENT)
    fun `viewing empty bag`() {
        val mainPage = MainPage(driver).openPage()
        val cartPage = mainPage.navigateToCart()
        val expectedEmpty = true
        assertThat(cartPage.isNoItemsDisplayed(), `is`(expectedEmpty))
    }

    @Test
    @Id("TC-2")
    @ExpectedResult("Checkout title displayed")
    @Execution(ExecutionMode.CONCURRENT)
    fun `viewing checkout payment page`() {
        val devicePage = GalaxyS22Page(driver).openPage()
        devicePage.clickNoTradeInDevices()
        val offersPage = devicePage.openOffersPage<GalaxyS22Offers>()
        val checkoutPage = offersPage.clickSkipButton()
        val expectedDisplayStatus = true
        assertThat(expectedDisplayStatus, `is`(checkoutPage.isCheckoutTitleDisplayed()))
    }

    @Test
    @Id("TC-3")
    @ExpectedResult("Cart is not empty")
    @Execution(ExecutionMode.CONCURRENT)
    fun `viewing item on bag`() {
        val devicePage = GalaxyS22Page(driver).openPage()
        devicePage.clickNoTradeInDevices()
        val offersPage = devicePage.openOffersPage<GalaxyS22Offers>()
        val checkoutPage = offersPage.clickSkipButton()
        val isNotEmpty = true
        assertThat(isNotEmpty, `is`(checkoutPage.checkIfCartIsNotEmpty()))
    }

}



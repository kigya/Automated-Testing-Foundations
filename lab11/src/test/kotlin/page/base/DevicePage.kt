package page.base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import page.utils.XPath
import page.base.common.Page
import utils.extensions.getElementByXPath
import utils.logger.Logger

abstract class DevicePage(driver: WebDriver) : Page(driver) {

    private val title: WebElement by lazy {
        Logger.info("Title has been initialized")
        driver.getElementByXPath(XPath.DevicePage.TITLE)
    }

    private val verizonCarrierOption: WebElement by lazy {
        Logger.info("Verizon carrier option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.VERIZON_CARRIER)
    }

    private val storageMiddleOption: WebElement by lazy {
        Logger.info("Storage middle option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.STORAGE_512)
    }

    private val grayGreenColorOption by lazy {
        Logger.info("Gray green color option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.GRAYGREEN_COLOR)
    }

    private val noTradeInDevicesOption by lazy {
        Logger.info("No trade in devices option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.NO_TRADE_IN_DEVICES)
    }

    private val noCoverageOption by lazy {
        Logger.info("No coverage option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.NO_COVERAGE)
    }

    private val oneTimePaymentOption by lazy {
        Logger.info("One time payment option has been initialized")
        driver.getElementByXPath(XPath.DevicePage.ONE_TIME_PAYMENT_OPTION)
    }

    private val continueButton by lazy {
        Logger.info("Continue button has been initialized")
        driver.getElementByXPath(XPath.DevicePage.CONTINUE_BUTTON)
    }

    fun getTitle(): String {
        Logger.info("Getting title")
        return title.text
    }

    fun clickVerizon(): DevicePage {
        Logger.info("Clicking Verizon carrier option")
        verizonCarrierOption.click()
        return this
    }

    fun clickStorage(): DevicePage {
        Logger.info("Clicking storage middle option")
        storageMiddleOption.click()
        return this
    }

    fun clickGraygreen(): DevicePage {
        Logger.info("Clicking gray green color option")
        grayGreenColorOption.click()
        return this
    }

    fun clickNoTradeInDevices(): DevicePage {
        Logger.info("Clicking no trade in devices option")
        noTradeInDevicesOption.click()
        return this
    }

    fun clickNoCoverage(): DevicePage {
        Logger.info("Clicking no coverage option")
        noCoverageOption.click()
        return this
    }

    fun clickOneTimePayment(): DevicePage {
        Logger.info("Clicking one time payment option")
        oneTimePaymentOption.click()
        return this
    }

    fun clickContinue(): DevicePage {
        Logger.info("Clicking continue button")
        continueButton.click()
        return this
    }

    inline fun <reified T : OffersPage> openOffersPage(): OffersPage {
        Logger.info("Opening offers page")
        clickContinue()
        return T::class.java.getConstructor(WebDriver::class.java).newInstance(`access$driver`)
    }

    @PublishedApi
    internal val `access$driver`: WebDriver
        get() = driver

}
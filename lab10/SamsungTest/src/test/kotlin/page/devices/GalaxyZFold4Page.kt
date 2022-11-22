package page.devices

import conditions.PageLoadedCondition
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.WebDriverWait
import page.utils.XPath
import page.common.Page
import page.links.Url
import utils.Const
import java.time.Duration

class GalaxyZFold4Page(driver: WebDriver) : Page(driver){

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.TITLE)
    private lateinit var title: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.VERIZON_CARRIER)
    private lateinit var verizonCarrierOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.STORAGE_512)
    private lateinit var storageMiddleOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.GRAYGREEN_COLOR)
    private lateinit var grayGreenColorOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.NO_TRADE_IN_DEVICES)
    private lateinit var noTradeInDevicesOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.NO_COVERAGE)
    private lateinit var noCoverageOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.ONE_TIME_PAYMENT_OPTION)
    private lateinit var oneTimePaymentOption: WebElement

    @FindBy(xpath = XPath.Galaxy_Z_Fold4.CONTINUE_BUTTON)
    private lateinit var continueButton: WebElement

    fun openPage(): GalaxyZFold4Page {
        driver[Url.GALAXY_Z_FOLD4]
        WebDriverWait(
            driver,
            Duration.ofSeconds(Const.DEFAULT_TIMEOUT)
        ).until(PageLoadedCondition())
        return this
    }

    fun getTitle(): String {
        return title.text
    }

    fun clickVerizon(): GalaxyZFold4Page {
        verizonCarrierOption.click()
        return this
    }

    fun clickStorage(): GalaxyZFold4Page {
        storageMiddleOption.click()
        return this
    }

    fun clickGraygreen(): GalaxyZFold4Page {
        grayGreenColorOption.click()
        return this
    }

    fun clickNoTradeInDevices(): GalaxyZFold4Page {
        noTradeInDevicesOption.click()
        return this
    }

    fun clickNoCoverage(): GalaxyZFold4Page {
        noCoverageOption.click()
        return this
    }

    fun clickOneTimePayment(): GalaxyZFold4Page {
        oneTimePaymentOption.click()
        return this
    }

    private fun clickContinue(): GalaxyZFold4Page {
        continueButton.click()
        return this
    }

    fun openOffersPage(): GalaxyZFold4OffersPage {
        clickContinue()
        return GalaxyZFold4OffersPage(driver)
    }

}
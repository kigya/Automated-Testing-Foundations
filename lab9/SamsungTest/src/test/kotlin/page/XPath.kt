package page

object XPath {
    object Galaxy_Z_Fold4 {
        const val VERIZON_CARRIER = "//*[@id='verizon']"
        const val STORAGE_512 = "//*[@id='512gb']"
        const val GRAYGREEN_COLOR = "//*[@id='graygreen-']"
        const val NO_TRADE_IN_DEVICES = "//*[@id='tradeinOptionNo']"
        const val NO_COVERAGE = "//*[@id='minipremiumcare']/div[4]"
        const val ONE_TIME_PAYMENT_OPTION = "//*[@id='PaymentContainer_top']/div[2]/div[1]/div[1]/div[3]/div[1]/div"
        const val CONTINUE_BUTTON = "//*[@id='homeCTA']/div/div/div"
    }

    object Galaxy_Z_Fold4_Offers {
        const val PAGE_TITLE = "//*[@id='add-on-heading']/div/div"
        const val SKIP_ADDONS_BUTTON = "//*[@id='add-ons-wrapper']/div[5]/div"
    }

    object Main {
        const val PROFILE_ICON = "//*[@id='wrap']/div[2]/nav/div/div/div[2]/div/div[2]/ul[2]/li[3]/a"
        const val SIGN_IN_BUTTON = "//*[@id='wrap']/div[2]/nav/div/div/div[2]/div/div[2]/ul[2]/li[3]/div/ul/li[1]/a"
        const val CART_ICON = "//*[@id='wrap']/div[2]/nav/div/div/div[2]/div/div[2]/ul[2]/li[2]/a"
    }

    object Cart {
        const val CONTINUE_SHOPPING_BUTTON = "//*[@id=\"viewcart_continue_shopping\"]"
    }
}
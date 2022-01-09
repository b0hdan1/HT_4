package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {
    public static final String SEARCHING_WORD = "планшет";
    private static final long WAITING_TIME = 10;
    public static final String CHECK_STOCK = "До завершення акції";
    private static final String EXPECTED_LANGUAGE_WORD = "ru";


    @Test
    public void checkAddingAndRemovingToCart() {
        getHomePage().clickOnSearchField();
        getHomePage().enterTheTextToSearchField(SEARCHING_WORD);
        getHomePage().clickToSearchButton();

        getSearchResultsPage().clickOnFirstProduct();

        getProductPage().clickBuyButton();

        getCartPopUpWindow().waitToCertainTime(WAITING_TIME);
        getCartPopUpWindow().clickToFirstStore();
        getCartPopUpWindow().clickToPickUpTomorrowButton();

        assertTrue(getCartPopUpWindow().isCartNotEmpty());

        getCartPopUpWindow().deleteProductFromCart();

        assertTrue(getCartPopUpWindow().isCartEmpty());
    }

    @Test
    public void checkRelevanceOfStocks() {
        getHomePage().clickToStockButton();
        List<WebElement> listOfStocksElements = getSearchResultsPage().getStockResults();
        for(WebElement element : listOfStocksElements) {
            assertTrue(element.getText().contains(CHECK_STOCK));
        }

        List<WebElement> listOfStocksDays = getSearchResultsPage().getStocksDays();
        for(WebElement element : listOfStocksDays) {
            if(Integer.parseInt(element.getText()) >= 1) {
                assertTrue(true);
            }else{
                assertTrue(false);
            }
        }
    }

    @Test
    public void checkSwitchLanguage() {
        Actions action = new Actions(getDriver());
        action.click(getHomePage().clickToSwitchLanguageButton()).pause(2000).build().perform();

        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_LANGUAGE_WORD));
    }
}

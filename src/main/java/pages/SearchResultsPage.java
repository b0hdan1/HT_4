package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Планшет Samsung Galaxy Tab A7')]")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//a[@class='promo-list__item']")
    private List<WebElement> listOfStockItems;

    @FindBy(xpath = "//span[@class='promo-list__days-label']")
    private List<WebElement> listOfStocksDays;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProduct() {
        listOfProducts.get(0).click();
    }

    public List<WebElement> getStockResults() {
        return listOfStockItems;
    }

    public List<WebElement> getStocksDays() {
        return listOfStocksDays;
    }

}

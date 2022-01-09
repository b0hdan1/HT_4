package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='product-buy-button']")
    private WebElement getBuyButton;

    public void clickBuyButton() {
        getBuyButton.click();
    }
}

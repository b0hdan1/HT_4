package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPopUpWindow extends BasePage {

    public CartPopUpWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='stores-list__store-item stores-list__store-item--adress']")
    private List<WebElement> listOfAddresses;

    @FindBy(xpath = "//button[contains(text(), 'Забрати')]")
    private WebElement pickUpTomorrowButton;

    @FindBy(xpath = "//button[contains(text(), 'Оформити замовлення')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='title']//*[name()='svg' and @class='v-icon sprite-shared remove v-icon v-icon__close']")
    private WebElement removeSelectedProduct;

    @FindBy(xpath = "//p[contains(text(), 'Ваш кошик порожній')]")
    private WebElement emptyCart;

    public void clickToFirstStore() {
        listOfAddresses.get(0).click();
    }

    public void clickToPickUpTomorrowButton() {
        pickUpTomorrowButton.click();
    }

    public boolean isCartNotEmpty() {
        return checkoutButton.isDisplayed();
    }

    public void deleteProductFromCart() {
        removeSelectedProduct.click();
    }

    public boolean isCartEmpty() {
        return emptyCart.isDisplayed();
    }
}

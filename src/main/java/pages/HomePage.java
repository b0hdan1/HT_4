package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='search-form__input']")
    private WebElement getSearchField;

    @FindBy(xpath = "//button[@class='search-form__submit-button']")
    private WebElement getSearchButton;

    @FindBy(xpath = "//a[contains(text(), 'Акції')]")
    private WebElement getStockButton;

    @FindBy(xpath = "//span[@class='mh-lang__item'][contains(text(), 'RU')]")
    private WebElement changeLanguageButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSearchField() {
        getSearchField.click();
    }

    public void enterTheTextToSearchField(String searchingWord) {
        getSearchField.sendKeys(searchingWord);
    }

    public void clickToSearchButton() {
        getSearchButton.click();
    }

    public void clickToStockButton() {
        getStockButton.click();
    }

    public WebElement clickToSwitchLanguageButton() {
        return changeLanguageButton;
    }

}

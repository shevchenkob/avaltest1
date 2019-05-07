package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log;

public class OneProductPage extends BasePage{
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='toOrder ng-star-inserted']")
    private WebElement buyButton;

    public OneProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckOutPage buy (){
        buyButton.click();
        Log.info("Click buy button");
        return new CheckOutPage (driver);
    }

    public boolean isPageLoaded() {
        return buyButton.isDisplayed()
                && driver.getTitle().contains("Ноутбук");
    }
}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='toOrder ng-star-inserted']")
    private WebElement checkOutButton;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return checkOutButton.isDisplayed();
    }
}

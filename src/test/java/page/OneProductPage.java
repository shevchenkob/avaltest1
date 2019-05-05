package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneProductPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='toOrder ng-star-inserted']")
    private WebElement buyButton;

    public OneProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buy (){
        buyButton.click();
    }
    public boolean isPageLoaded() {
        return buyButton.isDisplayed()
                && driver.getTitle().contains("Ноутбук");
    }
}

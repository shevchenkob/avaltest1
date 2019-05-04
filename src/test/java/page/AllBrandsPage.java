package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllBrandsPage {
    private WebDriver driver;

    @FindBy (xpath = ".//div[contains(@param, 'processor')]//a[@name='show_more_parameters']")
    private WebElement moreProcessors;

    @FindBy (xpath = "//a[@name='20861_6308']")
    private WebElement diagonal;

    @FindBy (xpath = "//a[@name='20863_48089']")
    private WebElement ram;

    @FindBy (xpath = "//div[@name='more_goods']")
    private WebElement moreGoods;

    public AllBrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public CartPage selectParams (WebElement brand, WebElement processor, String minPrice, String maxPrice) {
        moreProcessors.click();
        diagonal.click();
        ram.click();

    return new CartPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

public class AllBrandsPage extends BasePage{


    @FindBy (xpath = ".//div[contains(@param, 'processor')]//a[@name='show_more_parameters']")
    private WebElement moreProcessors;

    @FindBy (xpath = "//a[@name='20861_6308']")
    private WebElement diagonal;

    @FindBy (xpath = "//a[@name='20863_48089']")
    private WebElement ram;

    @FindBy (xpath = "//div[@name='more_goods']")
    private WebElement moreGoods;

    @FindBy (xpath = "//input[@id='price[min]']")
    private WebElement minPriceField;

    @FindBy (xpath = "//input[@id='price[max]']")
    private WebElement maxPriceField;

    @FindBy (xpath = "//button[@id='submitprice']")
    private WebElement submitPrice;

    @FindBy (xpath = "//div[@class='toOrder']")
    //@FindBy (xpath = "//span[@class='g-buy-submit-link']")
    private WebElement oneNotebook;

    @FindBy (xpath = "//ul[@id='sort_producer']")
    private WebElement producerListRoot;

    @FindBy (xpath = "//ul[@id='sort_processor']")
    private WebElement processorsListRoot;

    public AllBrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


public OneProductPage selectParams (String brand, String processor, String minPrice, String maxPrice) {
    producerListRoot.findElement(By.xpath("//ul[@id='sort_producer']//*[contains(text(),'"+brand+"')]/ancestor:: a")).click();
    Log.startLog("Select brand according to test parameters");
    waitUntilElementIsVisible(diagonal, 20);
    diagonal.click();
    Log.startLog("Select screen diagonal according to test parameters");
    waitUntilElementIsVisible(moreProcessors, 20);
    moreProcessors.click();
    Log.startLog("Extend list of processors to show all");
    waitUntilElementIsVisible(processorsListRoot, 20);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", processorsListRoot);
    Log.startLog("Scroll down to necessary processor checkbox will be visible");
    processorsListRoot.findElement(By.xpath("//ul[@id='sort_processor']//*[contains(text(),'"+processor+"')]/ancestor:: a")).click();
    Log.startLog("Select processor according to test parameters");
    waitUntilElementIsVisible(processorsListRoot, 20);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ram);
    Log.startLog("Scroll down to necessary ram checkbox will be visible");
    ram.click();
    Log.startLog("Select ram according to test parameters");
    waitUntilElementIsVisible(ram, 20);
    minPriceField.sendKeys(minPrice);
    Log.startLog("Fill minPrice field with value according to test parameters");
    maxPriceField.sendKeys(maxPrice);
    Log.startLog("Fill maxPrice field with value according to test parameters");
    submitPrice.click();
    Log.startLog("Click submit price button");
    waitUntilElementIsVisible(oneNotebook, 20);
    oneNotebook.click();
    Log.startLog("Click on the first notebook that fit selected criteria");

    return new OneProductPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

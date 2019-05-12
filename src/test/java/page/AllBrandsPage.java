package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    Log.info("Select brand according to test parameters");
    waitUntilElementIsVisible(diagonal, 5);
    waitUntilElementIsClickable(diagonal, 5);
    diagonal.click();
    Log.info("Select screen diagonal according to test parameters");
    waitUntilElementIsVisible(moreProcessors, 5);
    waitUntilElementIsClickable(moreProcessors, 5);
    moreProcessors.click();
    Log.info("Extend list of processors to show all");
    waitUntilElementIsVisible(processorsListRoot, 5);
    waitUntilElementIsClickable(processorsListRoot, 5);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", processorsListRoot);
    Log.info("Scroll down to necessary processor checkbox will be visible");
    processorsListRoot.findElement(By.xpath("//ul[@id='sort_processor']//*[contains(text(),'"+processor+"')]/ancestor:: a")).click();
    Log.info("Select processor according to test parameters");
    waitUntilElementIsVisible(processorsListRoot, 5);
    waitUntilElementIsClickable(processorsListRoot, 5);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ram);
    Log.info("Scroll down to necessary ram checkbox will be visible");
    ram.click();
    Log.info("Select ram according to test parameters");
    waitUntilElementIsVisible(ram, 5);
    waitUntilElementIsClickable(ram, 5);
    minPriceField.sendKeys(minPrice);
    Log.info("Fill minPrice field with value according to test parameters");
    maxPriceField.sendKeys(maxPrice);
    Log.info("Fill maxPrice field with value according to test parameters");
    submitPrice.click();
    Log.info("Click submit price button");
    waitUntilElementIsVisible(oneNotebook, 5);
    waitUntilElementIsClickable(oneNotebook, 5);
    oneNotebook.click();
    Log.info("Click on the first notebook that fit selected criteria");

    return new OneProductPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

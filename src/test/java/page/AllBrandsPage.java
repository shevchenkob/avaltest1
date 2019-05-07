package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

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

public OneProductPage selectParams (String brand, String processor, String minPrice, String maxPrice) throws InterruptedException

{
    producerListRoot.findElement(By.xpath("//ul[@id='sort_producer']//*[contains(text(),'"+brand+"')]/ancestor:: a")).click();
    waitUntilElementIsWisible(diagonal, 15);
    diagonal.click();
    waitUntilElementIsWisible(moreProcessors, 15);
    moreProcessors.click();
    waitUntilElementIsWisible(processorsListRoot, 15);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", processorsListRoot);
    processorsListRoot.findElement(By.xpath("//ul[@id='sort_processor']//*[contains(text(),'"+processor+"')]/ancestor:: a")).click();
    waitUntilElementIsWisible(processorsListRoot, 15);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ram);
    ram.click();
    waitUntilElementIsWisible(ram, 15);
    minPriceField.sendKeys(minPrice);
    maxPriceField.sendKeys(maxPrice);
    submitPrice.click();
    waitUntilElementIsWisible(oneNotebook, 15);
    oneNotebook.click();

    return new OneProductPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

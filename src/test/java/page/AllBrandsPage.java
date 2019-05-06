package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

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

    //START - Will be part of input in dataprovider//
//    @FindBy (xpath = "//a[@name='producer_4']")
//    public WebElement asus;
//
//    @FindBy (xpath = "//a[@name='processor_6268']")
//    private WebElement intelCoreI7;
//
    @FindBy (xpath = "//input[@id='price[min]']")
    private WebElement minPriceField;

    @FindBy (xpath = "//input[@id='price[max]']")
    private WebElement maxPriceField;

    @FindBy (xpath = "//button[@id='submitprice']")
    private WebElement submitPrice;

    @FindBy (xpath = "//div[@class='g-i-tile-i-title clearfix']")
    private WebElement oneNotebook;

    @FindBy (xpath = "//ul[@id='sort_producer']")
    private WebElement producerListRoot;

    @FindBy (xpath = "//ul[@id='sort_processor']")
    private WebElement processorsListRoot;

    //END - Will be part of input in dataprovider//

    public AllBrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public OneProductPage selectParams (String brand, String processor, String minPrice, String maxPrice) throws InterruptedException

{
    producerListRoot.findElement(By.xpath("//ul[@id='sort_producer']//*[contains(text(),'"+brand+"')]/ancestor:: a")).click();
    Thread.sleep(3000);
    diagonal.click();
    Thread.sleep(3000);
    moreProcessors.click();
    Thread.sleep(3000);
    processorsListRoot.findElement(By.xpath("//ul[@id='sort_processor']//*[contains(text(),'"+processor+"')]/ancestor:: a")).click();
    Thread.sleep(3000);
    ram.click();
    Thread.sleep(3000);
    minPriceField.sendKeys(minPrice);
    maxPriceField.sendKeys(maxPrice);
    submitPrice.click();
    Thread.sleep(3000);
    oneNotebook.click();

    return new OneProductPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

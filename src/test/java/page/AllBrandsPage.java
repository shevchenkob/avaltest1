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

    //END - Will be part of input in dataprovider//

    public AllBrandsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public OneProductPage selectParams (WebElement brand, WebElement processor, String minPrice) throws InterruptedException

{

        moreProcessors.click();
        Thread.sleep(3000);
        diagonal.click();
        Thread.sleep(3000);
        ram.click();
        Thread.sleep(3000);

    brand.click();
    Thread.sleep(3000);
    processor.click();
    Thread.sleep(3000);
    minPriceField.sendKeys(minPrice);

       // asus.click();
        //Thread.sleep(3000);
       // intelCoreI7.click();
       // Thread.sleep(3000);
       // minPrice.sendKeys("25000");
        maxPriceField.sendKeys("55000");
        submitPrice.click();
        Thread.sleep(3000);
        oneNotebook.click();

    return new OneProductPage (driver);
}

    public boolean isPageLoaded() {
        return moreGoods.isDisplayed();
    }
}

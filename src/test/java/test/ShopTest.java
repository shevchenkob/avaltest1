package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AllBrandsPage;
import page.AllNotebooksPage;
import page.CheckOutPage;
import page.OneProductPage;

import javax.xml.xpath.XPath;


public class ShopTest extends BaseTest {


    @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {asus, intelCoreI7, "25000"},
                {dell, intelCoreI5, "35000"},

        };
    }
    @Test(dataProvider = "ValidData", priority = 1)
    public void shopping(WebElement brand, WebElement processor, String minPrice) throws InterruptedException {


        Assert.assertTrue(startPage.isPageLoaded(), "Page https://rozetka.com.ua is not loaded.");
        AllNotebooksPage allNotebooksPage = startPage.navigateToNotebooks();
        Assert.assertTrue(allNotebooksPage.isPageLoaded(), "Page with all notebooks is not loaded.");
        AllBrandsPage allBrandsPage = allNotebooksPage.navigateToNotebooks();
        Assert.assertTrue(allBrandsPage.isPageLoaded(), "Page with all brands of notebooks is not loaded.");
        OneProductPage oneProductPage = allBrandsPage.selectParams(brand, processor, minPrice);
        Assert.assertTrue(oneProductPage.isPageLoaded(), "Page with selected notebook is not loaded.");
        CheckOutPage checkOutPage = oneProductPage.buy();
        Assert.assertTrue(checkOutPage.isPageLoaded(), "Checkout page is not displayed.");
    }
}

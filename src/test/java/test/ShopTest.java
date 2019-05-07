package test;

import base.SetupTestDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;


import java.net.MalformedURLException;


public class ShopTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();
        startPage = new StartPage(driver);
    }
    @DataProvider
    public Object[][] ValidData() {
       return new Object[][]{
                {"Asus", "Intel Core i7", "25000", "55000"},
                {"Dell", "Intel Core i5", "35000", "55000"},

        };
    }
    @Test(dataProvider = "ValidData", priority = 1)
    public void testShopping(String brand, String processor, String minPrice, String maxPrice) throws InterruptedException {

        Assert.assertTrue(startPage.isPageLoaded(), "Page https://rozetka.com.ua is not loaded.");
        AllNotebooksPage allNotebooksPage = startPage.navigateToNotebooks();
        Assert.assertTrue(allNotebooksPage.isPageLoaded(), "Page with all notebooks is not loaded.");
        AllBrandsPage allBrandsPage = allNotebooksPage.navigateToNotebooks();
        Assert.assertTrue(allBrandsPage.isPageLoaded(), "Page with all brands of notebooks is not loaded.");
        OneProductPage oneProductPage = allBrandsPage.selectParams(brand, processor, minPrice, maxPrice);
        Assert.assertTrue(oneProductPage.isPageLoaded(), "Page with selected notebook is not loaded.");
        CheckOutPage checkOutPage = oneProductPage.buy();
        Assert.assertTrue(checkOutPage.isPageLoaded(), "Checkout page is not displayed.");
    }

}

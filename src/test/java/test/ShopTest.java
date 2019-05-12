package test;


import org.testng.Assert;
import org.testng.annotations.*;
import page.*;
import utilities.Log;



public class ShopTest extends BaseTest {


    @DataProvider
    public Object[][] ValidData() {
       return new Object[][]{
                {"Asus", "Intel Core i7", "25000", "55000"},
                {"Dell", "Intel Core i5", "35000", "55000"},

        };
    }
    @Test(dataProvider = "ValidData", priority = 1)
    public void testShopping(String brand, String processor, String minPrice, String maxPrice){

        Assert.assertTrue(startPage.isPageLoaded(), "Page https://rozetka.com.ua is not loaded.");
        Log.info("Start page https://rozetka.com.ua is loaded.");
        AllNotebooksPage allNotebooksPage = startPage.navigateToNotebooks();
        Assert.assertTrue(allNotebooksPage.isPageLoaded(), "Page with all notebooks is not loaded.");
        Log.info("All notebooks page is loaded.");
        AllBrandsPage allBrandsPage = allNotebooksPage.navigateToNotebooks();
        Assert.assertTrue(allBrandsPage.isPageLoaded(), "Page with all brands of notebooks is not loaded.");
        Log.info("All brands of notebooks page is loaded.");
        OneProductPage oneProductPage = allBrandsPage.selectParams(brand, processor, minPrice, maxPrice);
        Assert.assertTrue(oneProductPage.isPageLoaded(), "Page with selected notebook is not loaded.");
        Log.info("Page of selected notebook is loaded");
        CheckOutPage checkOutPage = oneProductPage.buy();
        Assert.assertTrue(checkOutPage.isPageLoaded(), "Checkout page is not displayed.");
        Log.info("Shopping cart is appear");
    }

}

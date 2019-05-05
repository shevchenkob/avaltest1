package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.AllBrandsPage;
import page.AllNotebooksPage;
import page.OneProductPage;

@Test
public class ShopTest extends BaseTest {

    public void shoping() throws InterruptedException {
        Assert.assertTrue(startPage.isPageLoaded(), "Page https://rozetka.com.ua is not loaded.");
        AllNotebooksPage allNotebooksPage = startPage.navigateToNotebooks();
        Assert.assertTrue(allNotebooksPage.isPageLoaded(), "Page with all notebooks is not loaded.");
        AllBrandsPage allBrandsPage = allNotebooksPage.navigateToNotebooks();
        Assert.assertTrue(allBrandsPage.isPageLoaded(), "Page with all brands of notebooks is not loaded.");
        OneProductPage oneProductPage = allBrandsPage.selectParams();
        Assert.assertTrue(oneProductPage.isPageLoaded(), "Page with selected notebook is not loaded.");
        oneProductPage.buy();
    }
}

package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.AllNotebooksPage;

@Test
public class ShopTest extends BaseTest {

    public void shoping() {
        Assert.assertTrue(startPage.isPageLoaded(), "Page https://rozetka.com.ua is not loaded.");
        AllNotebooksPage allNotebooksPage = startPage.navigateToNotebooks();

    }
}

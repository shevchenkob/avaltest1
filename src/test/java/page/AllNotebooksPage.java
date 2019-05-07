package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log;

public class AllNotebooksPage extends BasePage{


    @FindBy (xpath = ".//div[contains(@class, 'p-auto-block p-auto-block-1')]//span[@class='arrow-link-inner']")
    private WebElement allBrands;

    public AllNotebooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllBrandsPage navigateToNotebooks (){
        allBrands.click();
        Log.startLog("Click to All Notebooks to navigate into table view");
        return new AllBrandsPage (driver);
    }

    public boolean isPageLoaded() {
        return allBrands.isDisplayed()
                && driver.getCurrentUrl().contains("notebooks")
                && driver.getTitle().contains("Ноутбуки");
    }
}

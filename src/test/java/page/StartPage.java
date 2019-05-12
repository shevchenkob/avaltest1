package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log;

public class StartPage extends BasePage{


    @FindBy(xpath = "//span[@class='menu-toggler__text']")
    private WebElement catalogue;

    @FindBy (xpath = "/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[1]/fat-menu/div/ul/li[1]/div/div[2]/div[1]/div[1]/ul[1]/li/a")
    private WebElement allNotebooks;


    public StartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public AllNotebooksPage navigateToNotebooks (){
        catalogue.click();
        Log.info("Navigate and click catalogue");
        allNotebooks.click();
        Log.info("Click to notebooks directory in catalogue");
        return new AllNotebooksPage (driver);
}

    public boolean isPageLoaded() {
        return catalogue.isDisplayed()
                && driver.getCurrentUrl().contains("rozetka.com.ua")
                && driver.getTitle().contains("ROZETKA");

    }
}

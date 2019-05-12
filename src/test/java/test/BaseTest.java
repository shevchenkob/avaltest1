package test;

import SetUp.SetupTestDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import page.StartPage;
import utilities.Log;

import java.net.MalformedURLException;


public class BaseTest {
        public static WebDriver driver;
        StartPage startPage;
        @BeforeMethod(alwaysRun = true)
        @Parameters({"os", "browser", "url", "node"})
        public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
                SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
                driver = setupTestDriver.getDriver();
                startPage = new StartPage(driver);
        }
        @AfterMethod
        public void afterMethod() {
        driver.quit();
                Log.endLog("The test is finished!");
    }
}

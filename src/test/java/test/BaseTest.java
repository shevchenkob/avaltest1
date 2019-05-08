package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import page.StartPage;
import utilities.Log;


public class BaseTest {
        public static WebDriver driver;
        StartPage startPage;
        @AfterMethod
        public void afterMethod() {
        driver.quit();
                Log.endLog("The test is finished!");
    }
}

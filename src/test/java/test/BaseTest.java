package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import page.StartPage;


public class BaseTest {
        public static WebDriver driver;
        StartPage startPage;

//        @BeforeMethod
//        public void beforeMethod() throws Exception {

//            DesiredCapabilities capability = DesiredCapabilities.chrome();
//            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),
//                    capability);
//            //baseUrl = "http://phy05:8080";
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//            driver.manage().window().setSize(new Dimension(1920, 1080));
//            driver.get("https://rozetka.com.ua");
//            startPage = new StartPage(driver);
//        }
        @AfterMethod
        public void afterMethod() {
        driver.quit();
    }
}

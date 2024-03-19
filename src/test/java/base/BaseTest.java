package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUpEnv()
    {
        driver=new ChromeDriver();
        driver.get("https://demo-m2.bird.eu/home");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

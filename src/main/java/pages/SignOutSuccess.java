package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutSuccess {
    private WebDriver driver;
    private By signOutSuccessfully= By.cssSelector("[data-ui-id=\"page-title-wrapper\"]");
    private By homePageButton=By.id("ui-id-3");
    public SignOutSuccess(WebDriver driver)
    {
        this.driver=driver;
    }
    public String bannerSignOutSuccess()
    {
        String logOutSuccess=driver.findElement(signOutSuccessfully).getText();
        return logOutSuccess;
    }
    public HomePage clickOnHomeButton()
    {
        driver.findElement(homePageButton).click();
        return new HomePage(driver);
    }

}

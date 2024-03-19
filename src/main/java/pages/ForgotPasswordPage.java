package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField=By.name("email");
    private By capthcaImg=By.cssSelector("[alt=\"Please type the letters and numbers below\"]");
    private By captchaField=By.id("captcha_user_forgotpassword");
    private By resetMyPasswordButton=By.id("send2");
    private By errorFieldRequired=By.id("email_address-error");
    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setEmailField(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCaptchaField(String captcha)
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20000));
        driver.findElement(captchaField).sendKeys(captcha);
    }
    public SignInPage clickOnResetPasswordButton()
    {
        driver.findElement(resetMyPasswordButton).click();
        return new SignInPage(driver);
    }
    public String errorFieldsAreRequired()
    {
        String fieldAreRequired=driver.findElement(errorFieldRequired).getText();
        return fieldAreRequired;
    }

}

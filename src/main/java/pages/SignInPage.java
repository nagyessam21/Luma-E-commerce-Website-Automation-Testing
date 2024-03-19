package pages;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public SignInPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By emailField=By.id("email");
    private By passwordField=By.id("pass");
    private By showPassword=By.id("show-password");
    private By signInButton=By.id("send2");
    private By forgotPasswordLink=By.linkText("Forgot Your Password?");
    private By invalidEmailFormat=By.id("email-error");
    private By fieldsAreRequired=By.id("email-error");
    private By resetPasswordIsSuccessfully=By.cssSelector("[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    private By errMssgforInvalidLoginData=By.cssSelector("[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    public void setEmailField(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPasswordField(String pass)
    {
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clickShowPasswordField()
    {
        driver.findElement(showPassword).click();
    }

    public boolean errorMssgWhenEnterInvalidDataForLogin()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMssgforInvalidLoginData));
        boolean errorMssg=driver.findElement(errMssgforInvalidLoginData).getText().contains("The account sign-in was incorrect");
        return errorMssg;
    }

    public String errMssgWhenEnterSqlInjectionsInputs()
    {
        String errorMsg=driver.findElement(invalidEmailFormat).getText();
        return errorMsg;
    }
    public boolean chkShowPassword()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        boolean isDisplayed=driver.findElement(passwordField).isDisplayed();
        return isDisplayed;
    }
    public String errorFieldRequired()
    {
        String error=driver.findElement(fieldsAreRequired).getText();
        return error;
    }
    public ForgotPasswordPage clickOnForgotPasswordLink()
    {
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }
    public String resetPasswordSuccess()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordIsSuccessfully));
        String resetPass=driver.findElement(resetPasswordIsSuccessfully).getText();
        return resetPass;
    }
    public MyAccountPage isLogin(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new MyAccountPage(driver);
    }
    public HomePage isLoginToHomePage(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }

    public void loginInvalid(String email, String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
    public void loginInvalid()
    {
        driver.findElement(signInButton).click();
    }
}

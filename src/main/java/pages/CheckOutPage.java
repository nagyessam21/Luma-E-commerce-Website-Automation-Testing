package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    WebDriverWait wait;
    private By cstEmail=By.id("customer-email");
    private By firstName=By.name("firstname");
    private By lastName=By.name("lastname");
    private By companyName=By.name("company");
    private By address=By.name("street[0]");
    private By country=By.name("country_id");
    private By state=By.name("region_id");
    private By city=By.name("city");
    private By zipCode=By.name("postcode");
    private By phoneNumber=By.name("telephone");
    private By freeShipping=By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input[1]");
    private By nameOfShipping=By.id("label_carrier_flatrate_flatrate");
    private By nextButton=By.cssSelector("[data-role=\"opc-continue\"]");
    private By errorFieldsRequired=By.xpath("//span[text()=\"This is a required field.\"][1]");
    private By invalidFormatForZipCode=By.cssSelector("[data-bind=\"text: element.warn\"]");
    private By addressClass=By.className("class=\"shipping-address-item\"");
    public CheckOutPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public PaymentPage clickOnNextButton()
    {
        driver.findElement(nextButton).click();
        return new PaymentPage(driver);
    }

    public void setFreeShipping()
    {
        driver.findElement(freeShipping).click();
    }
    public void waitUntilElementsLocated()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfShipping));
    }
    public String getShippingMethod()
    {
        return driver.findElement(nameOfShipping).getText();
    }
    public String getFieldsRequired()
    {
        return driver.findElement(errorFieldsRequired).getText();
    }
    public String errorInvalidZipCode()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidFormatForZipCode));
        return driver.findElement(invalidFormatForZipCode).getText();
    }
    public void enterValidDataForFields(String zpCode)
    {
        driver.findElement(zipCode).sendKeys(zpCode);
    }
    public void enterValidDataForFieldsInCaseSignUp(String cmpnyName
            ,String usrAddress,String usrCountry, String usrState,String usrCity,String zpCode,String usrPhone)
    {
            driver.findElement(companyName).clear();
            driver.findElement(companyName).sendKeys(cmpnyName);
            driver.findElement(address).clear();
            driver.findElement(address).sendKeys(usrAddress);
            Select drpDownCountry=new Select(driver.findElement(country));
            drpDownCountry.selectByVisibleText(usrCountry);
            Select drpDownState=new Select(driver.findElement(state));
            drpDownState.selectByVisibleText(usrState);
            driver.findElement(city).clear();
            driver.findElement(city).sendKeys(usrCity);
            driver.findElement(zipCode).clear();
            driver.findElement(zipCode).sendKeys(zpCode);
            driver.findElement(phoneNumber).clear();
            driver.findElement(phoneNumber).sendKeys(usrPhone);
    }
}

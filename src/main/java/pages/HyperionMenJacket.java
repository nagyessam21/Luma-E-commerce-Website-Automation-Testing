package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HyperionMenJacket {
    private WebDriver driver;
    private WebDriverWait wait;
    public HyperionMenJacket(WebDriver driver)
    {
        this.driver=driver;
    }
    private By hyperionJacketTitle=By.cssSelector("[data-ui-id=\"page-title-wrapper\"]");
    private By selectColor=By.id("option-label-color-93-item-53");
    private By setSize=By.xpath("//div[@aria-label=\"XS\"]");
    private By setQuantity=By.id("qty");
    private By addToCartButton=By.cssSelector("[title=\"Add to Cart\"]");
    private By cart=By.className("showcart");
    private By editCart=By.className("viewcart");
    private By totalPrice=By.xpath("/html/body/div[6]/main/div[2]/div/div[1]/div[4]/span[2]/span/span");
    private By youAddedProductsSuccessfullyBanner=By.cssSelector("[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    public void clickOnAddToCartButton()
    {
        driver.findElement(addToCartButton).click();
    }
    public String getTitleName()
    {
        return driver.findElement(hyperionJacketTitle).getText();
    }
    public boolean productsAddedToCart()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        boolean added=wait.until(ExpectedConditions.textToBe(addToCartButton,"Added"));
        return added;
    }
    public String getTotalPrice()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return driver.findElement(totalPrice).getText();
    }
    public CartPage navigateToCartPage()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        driver.findElement(cart).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(editCart));
        driver.findElement(editCart).click();
        return new CartPage(driver);
    }
    public void addItemsToCart(String quantity)
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectColor));
        driver.findElement(selectColor).click();
        driver.findElement(setSize).click();
        driver.findElement(setQuantity).clear();
        driver.findElement(setQuantity).sendKeys(quantity);
        clickOnAddToCartButton();
    }
}

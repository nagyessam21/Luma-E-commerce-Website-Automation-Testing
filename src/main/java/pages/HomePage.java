package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By createAccount = By.linkText("Create an Account");
    private By signIn = By.linkText("Sign In");
    private By menButton=By.id("ui-id-13");
    private By topsButton= By.id("ui-id-14");
    private By jacketsButton= By.id("ui-id-15");
    private By searchBar=By.id("search");
    private By searchButton=By.cssSelector("[title=\"Search\"]");
    private By outOfStockItem=By.cssSelector("[alt=\"Josie Yoga Jacket\"]");
    private By drpDownMenu=By.cssSelector("[data-action=\"customer-menu-toggle\"]");
    private By signOutButton=By.linkText("Sign Out");
    private By cartIcon=By.className("showcart");
    private By deleteItems=By.cssSelector("[title=\"Remove item\"]");
    private By clickOnOkToDelete=By.xpath("//span[text()=\"OK\"]");
    private By checkOutButton=By.id("top-cart-btn-checkout");
    private By noItemsFound=By.xpath("//strong[text()=\"You have no items in your shopping cart.\"]");
    private By closeDialogue=By.id("btn-minicart-close");
    private By quantityNumber=By.xpath("//*[@id=\"html-body\"]/div[6]/header/div[2]/div[1]/a/span[2]");
    private By dialogue=By.id("ui-id-1");
    private By homeButton=By.xpath("//span[text()=\"Home\"]");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public SignInPage clickOnSignInButton()
    {
        driver.findElement(signIn).click();
        return new SignInPage(driver);
    }
    public CreateAccountPage clickOnCreateAccountButton()
    {
        driver.findElement(createAccount).click();
        return new CreateAccountPage(driver);
    }
    public MenJacketsPage clickOnMenTopsJacketsCategory()
    {
        WebElement menButtonCategory=driver.findElement(menButton);
        WebElement topsButtonCategory=driver.findElement(topsButton);
        WebElement jacketsButtonCategory=driver.findElement(jacketsButton);
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(menButton));
        Actions actions=new Actions(driver);
        actions.moveToElement(menButtonCategory).perform();
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(topsButtonCategory));
        actions.moveToElement(topsButtonCategory).perform();
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(jacketsButtonCategory));
        actions.moveToElement(jacketsButtonCategory).click().perform();
        return new MenJacketsPage(driver);
    }
    public void searchForItem(String item)
    {
        driver.findElement(searchBar).sendKeys(item);
    }
    public ResultPage clickOnSearchButton()
    {
        driver.findElement(searchButton).click();
        return new ResultPage(driver);
    }
    public ProductOutStock moveToProductOutOfStock()
    {
        driver.findElement(outOfStockItem).click();
        return new ProductOutStock(driver);
    }
    public SignOutSuccess clickOnSignOutButton()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(drpDownMenu));
        driver.findElement(drpDownMenu).click();
        driver.findElement(signOutButton).click();
        return new SignOutSuccess(driver);
    }
    public void cleanUpCart()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityNumber));
        driver.findElement(cartIcon).click();
            wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItems));
            driver.findElement(deleteItems).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnOkToDelete));
            driver.findElement(clickOnOkToDelete).click();
    }

}

package outofstockitemnotify;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenJacketsPage;
import pages.ProductOutStock;
import pages.SignInPage;

public class NotifyTests extends BaseTest {

    //verify when usr click on notify me when product avail , website enable alert
    @Test(priority = 0)
    public void notifyUsrSuccess()
    {
        ProductOutStock productOutStock=homePage.moveToProductOutOfStock();
        productOutStock.clickOnNotifyButton();
        productOutStock.setusrEmail("peterpet600100@gmail.com");
        productOutStock.clickOnNotifyMe();
        String success=productOutStock.getSubscribeSuccess();
        Assert.assertTrue(success.contains("has been correctly registred."));
    }
    //verify when usr click on notify me with email already subscriber , an error appears
    @Test (priority = 1)
    public void notifyUsrAlreadySubscribed()
    {
        ProductOutStock productOutStock=homePage.moveToProductOutOfStock();
        productOutStock.clickOnNotifyButton();
        productOutStock.setusrEmail("peterpet600100@gmail.com");
        productOutStock.clickOnNotifyMe();
        String success=productOutStock.getAlertAlreadySubscribed();
        Assert.assertTrue(success.contains("You already had subscribed"));
    }
    @BeforeMethod
    public void login()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        homePage=signInPage.isLoginToHomePage("peterpet600100@gmail.com","peter_pet123");
    }
}

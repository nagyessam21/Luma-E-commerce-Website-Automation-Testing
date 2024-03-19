package addToWishList;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;


public class AddToWishListFunction extends BaseTest{

    @Test
    public void addToWishListSuccessfully()
    {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        String productName=menJacketsPage.getProductName();
        MyWishList myWishList=menJacketsPage.addToWishList();
        String productNameFromWishList=myWishList.getProductName();
        Assert.assertTrue(productNameFromWishList.contains("Hyperion Elements"),"error, items aren't matched");
    }
    @BeforeMethod
    public void login()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        homePage=signInPage.isLoginToHomePage("peterpet600100@gmail.com","peter_pet123");
    }
}

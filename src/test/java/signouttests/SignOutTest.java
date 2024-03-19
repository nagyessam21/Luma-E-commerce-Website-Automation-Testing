package signouttests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.SignOutSuccess;

public class SignOutTest extends BaseTest {

    //verify when click on logout button , usr signed out of his account
    @Test
    public void signOutSuccess()
    {
        SignOutSuccess signOutSuccess=homePage.clickOnSignOutButton();
        String signOutSuccessfully=signOutSuccess.bannerSignOutSuccess();
        Assert.assertEquals(signOutSuccessfully,"You are signed out","error , sign out not be done");
        homePage=signOutSuccess.clickOnHomeButton();
    }
    @BeforeMethod
    public void login()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        homePage=signInPage.isLoginToHomePage("peterpet600100@gmail.com","peter_pet123");
    }
}

package signintests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MyAccountPage;
import pages.SignInPage;

public class SignInTests extends BaseTest {

    //verify when user enters valid data for all fields in the sign in page , user signed in successfully
    @Test (priority = 1)
    public void t2_EnterValidPasswordAndEmail()
    {
        SignInPage signinPage=homePage.clickOnSignInButton();
        MyAccountPage myAccountPage=signinPage.isLogin("peterpet600100@gmail.com","peter_pet123");
        Boolean signOutButtonLocated=myAccountPage.signOutButtonAppears();
        Assert.assertTrue(signOutButtonLocated);
    }

    //verify when user enters invalid password in the password field in sign in page , user cannot sign in and an error mssg appears
    @Test
    public void t6_EnterInvalidPassword()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        signInPage.loginInvalid("peterpet600100@gmail.com","peter_pet5123");
        Boolean errorMssg=signInPage.errorMssgWhenEnterInvalidDataForLogin();
        Assert.assertTrue(errorMssg);
    }

    //verify when user enters invalid email in email field in sign in page , user cannot sign in and an error mssg appears
    @Test
    public void t1_EnterInvalidEmail()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        signInPage.loginInvalid("peterpet11@gmail.com","peter_pet123");
        Boolean errorMssg=signInPage.errorMssgWhenEnterInvalidDataForLogin();
        Assert.assertTrue(errorMssg);
    }

    //verify when user enters invalid email with SQL Injection Inputs in email field in sign in page , user cannot sign in and an error mssg appears
    @Test
    public void t3_EnterSqlInjectionInputs()
    {
            SignInPage signInPage=homePage.clickOnSignInButton();
        signInPage.loginInvalid("\"' OR '1'='1'\"","peter_pet123");
            String errorMssg=signInPage.errMssgWhenEnterSqlInjectionsInputs();
        Assert.assertEquals(errorMssg,"Please enter a valid email address (Ex: johndoe@domain.com)."
                    ,"error signin shouldn't be done");
    }

    //verify when clicks on show password check box in sign in page , password decrypted and appears for user
    @Test
    public void t4_ChkShowPassword()
    {
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.setPasswordField("peter_pet123");
        signInPage.clickShowPasswordField();
        boolean isDisplayed=signInPage.chkShowPassword();
        Assert.assertTrue(isDisplayed);
    }
    //verify when user left fields blank in sign in page , usr cannot sign in and an error appears
    @Test
    public void t5_ErrorForFieldsRequired()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        signInPage.loginInvalid();
        String errorFieldsAreRequired=signInPage.errorFieldRequired();
        Assert.assertEquals(errorFieldsAreRequired,"This is a required field.","error , signin shouldn't be done");
    }
}
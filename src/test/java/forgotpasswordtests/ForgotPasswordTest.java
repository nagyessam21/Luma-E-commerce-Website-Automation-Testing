package forgotpasswordtests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.SignInPage;

import java.time.Duration;

public class ForgotPasswordTest extends BaseTest {


    //verify when left fields blank , an error appears
    @Test
    public void resetPasswordEmailSentSuccessfully(){
        SignInPage signInPage=homePage.clickOnSignInButton();
        ForgotPasswordPage forgotPasswordPage=signInPage.clickOnForgotPasswordLink();
        SignInPage signInPage1=forgotPasswordPage.clickOnResetPasswordButton();
        String fieldsAreRequired=forgotPasswordPage.errorFieldsAreRequired();
        Assert.assertTrue(fieldsAreRequired.matches("This is a required field."));
    }
}

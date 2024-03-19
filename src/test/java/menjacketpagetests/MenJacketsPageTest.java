package menjacketpagetests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HyperionMenJacket;
import pages.MenJacketsPage;
import pages.SignInPage;

public class MenJacketsPageTest extends BaseTest {

    //verify when user clicks on sort by price in the results page , products are arranged ascending by price
    @Test
    public void sortByPrice()
    {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        menJacketsPage.selectFromSortingDropDownMenu(" Price ");
        String lowestPriceInPage=menJacketsPage.showMinimumPriceInPage();
        Assert.assertEquals(lowestPriceInPage,"€45.00","error, sorting function doesn't work");
    }
    //verify when click on sort by product , the products are arranged ascending alphapatically
    @Test
    public void sortByProductName()
    {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        menJacketsPage.selectFromSortingDropDownMenu(" Product Name ");
        String firstLetterInPage=menJacketsPage.showAscendingOrderForProducts();
        Assert.assertEquals(firstLetterInPage,"Hyperion Elements Jacket","error, sorting function doesn't work");
    }

    //verify when click on the product , the same product appears in page
    @Test
    public void clickOnFirstProduct()
    {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        HyperionMenJacket hyperionMenJacket=menJacketsPage.clickOnFirstProduct();
        String titleJacket=hyperionMenJacket.getTitleName();
        Assert.assertEquals(titleJacket,"Hyperion Elements Jacket","error , items didn't match");
    }
    @BeforeMethod
    public void login()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        homePage=signInPage.isLoginToHomePage("peterpet600100@gmail.com","peter_pet123");
    }

}

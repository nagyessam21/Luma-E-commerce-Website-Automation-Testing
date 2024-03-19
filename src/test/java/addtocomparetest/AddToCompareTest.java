package addtocomparetest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparisonList;
import pages.MenJacketsPage;
import pages.SignInPage;

public class AddToCompareTest extends BaseTest {

    //verify when add two products in compare list , they appear in comparison list page
    @Test
    public void addToCompareSuccesfully() {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        String taurusFromMenPage=menJacketsPage.getTaurusJacketTitle();
        String hyperionFromMenPage=menJacketsPage.getHyperionJacketTitle();
        menJacketsPage.addHyperionToCompare();
        menJacketsPage.addTaurusToCompare();
        ComparisonList comparisonList=menJacketsPage.clickOnComparisonList();
        String hyperionFromComparisonPage=comparisonList.getHyperionJacketTitle();
        String taurusFromComparisonPage=comparisonList.getTaurusJacketTitle();
        Assert.assertEquals(taurusFromComparisonPage,taurusFromMenPage,"error, items aren't matched");
        Assert.assertEquals(hyperionFromComparisonPage,hyperionFromMenPage,"error, items aren't matched");
    }

    //verify when add the same product in the comparison list , it shows only one product
    @Test
    public void addToTheSameProductTCompare() {
        MenJacketsPage menJacketsPage=homePage.clickOnMenTopsJacketsCategory();
        menJacketsPage.addHyperionToCompare();
        menJacketsPage.addHyperionToCompare();
        ComparisonList comparisonList=menJacketsPage.clickOnComparisonList();
        int noOfJackets=comparisonList.numbersOfHyperionJacket();
        Assert.assertEquals(noOfJackets,1);
    }
    @BeforeMethod
    public void login()
    {
        SignInPage signInPage=homePage.clickOnSignInButton();
        homePage=signInPage.isLoginToHomePage("peterpet600100@gmail.com","peter_pet123");
    }

}

package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTest extends BaseTest {


    @DataProvider
    public Object [] [] negativeLoginTest() {
        return new Object[][]{

                {"a@b.c", ""}
        };
    }



    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "mail@gmail.com", "Password" },
                { "mail@GMAIL.COM", "Password" },
                { " mail@gmail.com ", "Password" },
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPass) {
         HomePage homePage = loginPage.login (userEmail, userPass);

        Assert.assertTrue(homePage.isLoaded(),
                "Home page is not loaded.");
    }


    @DataProvider
    public Object[][] negativeLeadsToLoginPage() {
        return new Object[][]{
                {"ok.mailbox666@gmail.com", "wrong"},
                {"ok.mailbox666@gmail.com", "12"}
        };
    }


    @Test(dataProvider = "negativeLeadsToLoginPage")
    public void negativeLeadsToLoginSubmitPage(String userEmail,
                                               String userPass)
    {
        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPass);


        Assert.assertEquals(loginSubmitPage.getUserPassError(),
                "The password you provided must have at least 6 characters.");

        Assert.assertEquals(loginSubmitPage.getUserPassError(),
                "Hmm, that's not the right password. Please try again or request a new one.");
    }
}

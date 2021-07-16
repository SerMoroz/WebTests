package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class ResetPasswordTest extends BaseTest{

    @Test
    public void successfulResetPasswordTest() throws InterruptedException {
        String newPassword = "Passsword";

        Assert.assertTrue(loginPage.isLoaded(),
                "LoginPage is not loaded.");

        RequestPasswordResetPage requestPasswordResetPage =
                loginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isLoaded(),
                "RequestPasswordResetPage is not loaded.");

        PasswordResetSubmitPage passwordResetSubmitPage =
                requestPasswordResetPage.findAccount("mail@gmail.com");
        sleep(180000);
        Assert.assertTrue(passwordResetSubmitPage.isLoaded(),
                "PasswordResetSubmitPage is not loaded.");

        SetNewPasswordPage setNewPasswordPage =
                passwordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(setNewPasswordPage.isLoaded(),
                "SetNewPasswordPage is not loaded.");



    }
}

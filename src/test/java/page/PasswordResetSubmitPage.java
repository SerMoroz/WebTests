package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class PasswordResetSubmitPage extends BasePage {
    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    /**
     * Constructor for PasswordResetSubmitPage class.
     * @param webDriver - webDriver instance from Test.
     */

    public PasswordResetSubmitPage(WebDriver browser) {
        this.webDriver = webDriver;
        PageFactory.initElements(browser, this);
    }
    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isLoaded() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resendLinkButton.isDisplayed()
                && webDriver.getTitle().contains("Please check your mail for reset password link.")
                && webDriver.getCurrentUrl().contains("request-password-reset-submit");
    }

    /**+
     * Method to press Link for reset password and navigate to mailbox
     * @return  new page to set new password for
     */

    public SetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "ok.mailbox666@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(
                messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordLink =
                StringUtils.substringBetween(message, "href=\"", "\" style=")
                        .replace("amp;", "");
        webDriver.get(resetPasswordLink);

        return new SetNewPasswordPage(webDriver);
    }
}

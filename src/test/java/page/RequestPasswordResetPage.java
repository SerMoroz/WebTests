package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage extends BasePage {
    /**+
     * Xpath checking user email and button to press
     */
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;
    /**
     * Constructor RequestPasswordResetPage class.
     * @param webDriver - webDriver instance from Test.
     */
    public RequestPasswordResetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && webDriver.getTitle().contains("Reset Password | LinkedIn")
                && webDriver.getCurrentUrl().contains("uas/request-password-reset");
    }

    /**+
     * Method to submit new password
     * @param userEmail
     * @return
     */

    public PasswordResetSubmitPage findAccount(String userEmail) {
        gMailService = new GMailService();
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        return new PasswordResetSubmitPage(webDriver);
    }
}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetNewPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    /**+
     * Constructor of SetNewPasswordPage class
     * @param webDriver -instance from Test
     */
    public SetNewPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isLoaded() {
        return newPasswordField.isDisplayed()
                && webDriver.getTitle().contains("Reset Your Password")
                && webDriver.getCurrentUrl().contains("checkpoint/rp/password-reset?requestSubmissionId=");
    }


}

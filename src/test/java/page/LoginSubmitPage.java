package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage extends BasePage {

    private WebElement loginForm;
    private WebElement userEmailError;
    private WebElement userPassError;

    /**
     * Constructor of LoginSubmitPage class.
     * @param webDriver - webDriver instance from Test.
     */
    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        loginForm = webDriver.findElement(By.xpath("//form[@class='login__form']"));
        userEmailError = webDriver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPassError = webDriver.findElement(By.xpath("//div[@id='error-for-password']"));
    }
    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isLoaded() {
        return loginForm.isDisplayed()
                && webDriver.getTitle().contains("Sign In to LinkedIn")
                && webDriver.getCurrentUrl().contains("uas/login-submit");
    }

    public String getUserEmailError() {
        return userEmailError.getText();
    }

    public String getUserPassError() {
        return userPassError.getText();
    }

}

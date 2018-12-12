package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;


public class HomePage extends BasePage {
    /**+
     * Search using xpath on LinkedIn Home Page
     */
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement welcomeMessage;
    @FindBy(xpath= "//input[@placeholder='Search' and @role]")
    private WebElement searchFields;

    /**+
     * Page object for LinkedIn home page
     * @param webDriver - instance from Test
     */
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    /**+
     * Method to check if page is loaded
     * @return true/false
     */
    public boolean isLoaded() {
        return welcomeMessage.isDisplayed()
                && webDriver.getTitle().contains("LinkedIn")
                && webDriver.getCurrentUrl().contains("/feed/");
    }

    /**+
     * Method that show search results on Home page in LinkedIn
     * @param searchTerm - in this case its "HR"
     * @return request SearchResultPage object
     */
    public SearchResultsPage search(String searchTerm) {
        searchFields.sendKeys(searchTerm);
        searchFields.sendKeys(Keys.RETURN);
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultsPage(webDriver);
    }
}

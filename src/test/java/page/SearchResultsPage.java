package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    /**+
     * Xpath checking if page with results loaded
     */
    @FindBy(xpath = "//div[contains(@class, 'search-filters-bar')]")
    private WebElement searchFilterBar;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    /**
     * Constructor of SearchResultsPage class.
     * @param webDriver - webDriver instance from Test.
     */
    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isLoaded() {
        return searchFilterBar.isDisplayed()
                && webDriver.getTitle().contains("LinkedIn")
                && webDriver.getCurrentUrl().contains("search/results");

    }

    /**+
     * Method which count results of searched items on page
     * @return
     */
    public  int getSearchResultsCount() {
        return searchResults.size();
    }

    /**+
     * Method to scroll and get results on Search Page
     * @return Results of searching
     */
    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchFilterBar :searchResults) {
            ((JavascriptExecutor) webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchFilterBar);
            searchResultsList.add(searchFilterBar.getText());
        }
        return searchResultsList;
    }
}



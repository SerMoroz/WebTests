package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultsPage;

import java.util.List;

public class SearchTest extends BaseTest {





    /**
     * Preconditions:
     * - Open browser
     * - Navigate to linkedin.com
     * - Login with valid credentials
     * Scenario:
     * - Verify page.HomePage is loaded
     * - Enter "HR" into search field
     * - Press Return on keyboard
     * - Verify Search results page is loaded
     * - Verify list contains 10 items
     * - Verify each item if contains searchterm
     * Postcondition:
     * - Close browser
     *
     *
     *
     */
    @Test
    public void basicSearchTest(){
        HomePage homePage = loginPage.login("ok.mailbox666@gmail.com", "Vlasenko13!");
        String searchTerm= "HR";

        Assert.assertTrue(homePage.isLoaded(),
                   "Home page is not loaded.");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);

        Assert.assertTrue(searchResultsPage.isLoaded(),
                    "Search page is not loaded.");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10,
                     "Search results count is wrong.");

         List<String> searchResults = searchResultsPage.getSearchResultsList();

        for (String searchResult: searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm "+searchTerm+" not found in: \n"+searchResult);
        }
    }
}

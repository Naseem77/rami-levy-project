package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchBar {
    private TestContext context;


    public SearchBar(TestContext context) {
        this.context = context;
    }
    @Given("I have navigated to Rami Levi home page")
    public void iHaveNavigatedToRamiLeviHomePage() {
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        Logic.SearchBar searchBar = browserWrapper.createPage(Logic.SearchBar.class, "http://rami-levy.co.il");
    }

    @When("I input with in search {string}")
    public void iInputWithInSearch(String item) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        context.put("searchItem", item);
        Logic.SearchBar page = new Logic.SearchBar(browserWrapper.getDriver());
        page.searchInput(item);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        Logic.SearchBar page = new Logic.SearchBar(browserWrapper.getDriver());
        page.searchButton();
    }

    @Then("I should be navigated to the correct page")
    public void iShouldBeNavigatedToTheCorrectPage() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        String searchItem = context.get("searchItem");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String currentUrl = browserWrapper.getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.rami-levy.co.il/he/online/search?q=" + searchItem,currentUrl);
    }
}

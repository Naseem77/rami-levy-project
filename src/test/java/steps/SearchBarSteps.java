package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.SearchBarComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchBarSteps {
    private TestContext context;

    public SearchBarSteps(TestContext context) {
        this.context = context;
    }

    @When("I input with in search {string}")
    public void iInputWithInSearch(String item) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        context.put("searchItem", item);
        SearchBarComponent searchBarComponent = browserWrapper.createPage(SearchBarComponent.class);
        searchBarComponent.searchInput(item);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchBarComponent searchBarComponent = browserWrapper.createPage(SearchBarComponent.class);
        searchBarComponent.searchButton();
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

package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import io.cucumber.java.en.And;
import org.junit.Assert;
import Logic.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RamiLeviSteps {
    private TestContext context;


    public RamiLeviSteps(TestContext context) {
        this.context = context;
    }

    @Given("I have navigated to Rami Levi")
    public void iHaveNavigatedToRamiLevi() {
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        RamiLeviHomePage ramiLeviHomePage = browserWrapper.createPage(RamiLeviHomePage.class, "http://rami-levy.co.il");
    }



    @When("On login popup - I login with user '{}' and password '{}'")
    public void iLoginWithUserAndPassword(String user, String password) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        LoginPage page = browserWrapper.getCurrentPage();
        page.login(user, password);
        browserWrapper.createPage(RamiLeviHomePage.class);
    }

    @Given("On Rami Levi home page - I click login")
    public void onRamiLeviHomePageIClickLogin() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage page = browserWrapper.getCurrentPage();
        page.clickLogin();
        browserWrapper.createPage(LoginPage.class);
    }




    @Then("On Rami Levi home page - '{}'")
    public void onRamiLeviHomePage(String name) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage homePage = browserWrapper.getCurrentPage();
        String currentText = homePage.getLoginUserText();
        int retries = 0;
        while (!currentText.equals(name) && retries < 10) {
            currentText = homePage.getLoginUserText();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retries++;
        }
        assertEquals(name, currentText);
    }


    //SearchBar

    @Given("I have navigated to Rami Levi home page")
    public void iHaveNavigatedToRamiLeviHomePage() {
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        SearchBar searchBar = browserWrapper.createPage(SearchBar.class, "http://rami-levy.co.il");
    }

    @When("I input with in search {string}")
    public void iInputWithInSearch(String item) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        context.put("searchItem", item);
        SearchBar page = new SearchBar(browserWrapper.getDriver());
        page.searchInput(item);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchBar page = new SearchBar(browserWrapper.getDriver());
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

    // FAST BUYING

    @Given("I have navigated to Rami Levi home pagea")
    public void iHaveNavigatedToRamiLeviHomePagea() {
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        RamiLeviHomePage home = browserWrapper.createPage(RamiLeviHomePage.class, "http://rami-levy.co.il");
    }
    @When("I click on Fast Buying button")
    public void iClickOnFastBuyingButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage page = new RamiLeviHomePage(browserWrapper.getDriver());
        page.clickFastBuy();
    }

    @And("I enter input {string}")
    public void iEnterInputBambaAndClickOnContinue(String searchItem) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuying page = new FastBuying(browserWrapper.getDriver());
        page.FastBuy(searchItem);;
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuying page = new FastBuying(browserWrapper.getDriver());
        page.continueButton();
    }

    @And("I add an item to cart and click on finish")
    public void iAddAnItemToCartAndClickOnFinish() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuying page = new FastBuying(browserWrapper.getDriver());
        page.FinishingFastBuyingProcess();
        browserWrapper.createPage(RamiLeviHomePage.class);
    }


    @Then("I need to view item on cart")
    public void iNeedToViewItemOnCart() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage page = new RamiLeviHomePage(browserWrapper.getDriver());
        Assert.assertEquals(page.checkCartLength(),1);
    }
  
  @Given("i have navigated the home page")
    public void IHaveNavigatedTheHomePage(){
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        RamiLeviHomePage ramiLeviHomePage = browserWrapper.createPage(RamiLeviHomePage.class, "http://rami-levy.co.il");

    }


    @When("navigated to the profile and fill the address")
    public void navigatedToTheProfileAndFillTheAddress() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressEdit address = new AddressEdit(browserWrapper.getDriver());
        address.ProfileClick();
        address.AddressClick();
        address.AddAddressClick();
        address.FillAddress("עכו","אבות ובנים","1","1","1");
    }


    @Then("i should view the address")
    public void iShouldViewTheAddress(){
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressEdit address = new AddressEdit(browserWrapper.getDriver());
        Assert.assertTrue(address.CheckAddress());
    }


}

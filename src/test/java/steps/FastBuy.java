package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.FastBuying;
import Logic.RamiLeviHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FastBuy {

    private TestContext context;


    public FastBuy(TestContext context) {
        this.context = context;
    }

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
}

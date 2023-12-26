package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.FastBuyingComponent;
import Logic.RamiLeviHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FastBuySteps {

    private TestContext context;

    public FastBuySteps(TestContext context) {
        this.context = context;
    }

    @When("I click on Fast Buying button")
    public void iClickOnFastBuyingButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage home = browserWrapper.createPage(RamiLeviHomePage.class);
        home.clickFastBuy();
    }

    @And("I enter input {string}")
    public void iEnterInputBambaAndClickOnContinue(String searchItem) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuyingComponent fastBuyingPage = browserWrapper.createPage(FastBuyingComponent.class);
        fastBuyingPage.FastBuy(searchItem);
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuyingComponent fastBuyingPage = browserWrapper.createPage(FastBuyingComponent.class);
        fastBuyingPage.continueButton();
    }

    @And("I add an item to cart and click on finish")
    public void iAddAnItemToCartAndClickOnFinish() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        FastBuyingComponent fastBuyingPage = browserWrapper.createPage(FastBuyingComponent.class);
        fastBuyingPage.FinishingFastBuyingProcess();
    }


    @Then("I need to view item on cart")
    public void iNeedToViewItemOnCart() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        RamiLeviHomePage page = browserWrapper.createPage(RamiLeviHomePage.class);
        Assert.assertEquals(page.checkCartLength(),1);
    }
}

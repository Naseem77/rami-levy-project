package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.AllDiscountsPage;
import Logic.RamiLeviHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DiscountSteps {
    private TestContext context;

    public DiscountSteps(TestContext context) {
        this.context = context;
    }

    @When("I Click AllDiscounts Button")
    public void iClickAllDiscountsButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AllDiscountsPage allDiscountsPage = browserWrapper.createPage(AllDiscountsPage.class);
        allDiscountsPage.ClickAllDiscountButton();
        Set<String> windowHandles = browserWrapper.GetDriver().getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        String secondTab = windowHandlesList.get(1);
        browserWrapper.GetDriver().switchTo().window(secondTab);

    }
    @Then("Validate that I navigate to the correct page")
    public void iClickAllDiscountsButtonAndValidateThatINavigateToTheCorrectPageAnd() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        Assertions.assertEquals(browserWrapper.GetDriver().getCurrentUrl(),"https://www.rami-levy.co.il/he/online/feed");
    }
}

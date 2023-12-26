package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.AddressEdit;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressSteps {

    private TestContext context;


    public AddressSteps(TestContext context) {
        this.context = context;
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

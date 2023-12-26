package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.AddressPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class AddressSteps {
    private TestContext context;
    public AddressSteps(TestContext context) {
        this.context = context;
    }

    @When("navigated to the profile and fill the address")
    public void navigatedToTheProfileAndFillTheAddress() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressPage addressPage = browserWrapper.createPage(AddressPage.class);
        addressPage.ProfileClick();
        addressPage.AddressClick();
        addressPage.AddAddressClick();
        addressPage.FillAddress("עכו","אבות ובנים","1","1","1");
    }

    @Then("i should view the address")
    public void iShouldViewTheAddress(){
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressPage addressPage = browserWrapper.createPage(AddressPage.class);
        System.out.println("after Adding"+addressPage.CheckAddress());
        Assert.assertTrue(addressPage.CheckAddress());
    }



    @Given("i navigated to the profile address page")
    public void iNavigatedToTheProfileAddressPage() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressPage addressPage = browserWrapper.createPage(AddressPage.class);
        addressPage.ProfileClick();
        addressPage.AddressClick();


    }

    @When("i click on the delete button and confirm")
    public void iClickOnTheDeleteButtonAndConfirm() {

        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressPage addressPage = browserWrapper.createPage(AddressPage.class);
        addressPage.addressHoverAndRemove();

    }


    @Then("Validate that address deleted")
    public void validateThatAddressDeleted() {

        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AddressPage addressPage = browserWrapper.createPage(AddressPage.class);

        try {
            // Introduce a pause of 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(addressPage.CheckIftheAdressersIsEmpty());

    }




}

package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.ApiRequests;
import Logic.ItemComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class ItemSteps {
    private TestContext context;

    public ItemSteps(TestContext context) {
        this.context = context;
    }
    @When("I add one item to the cart via API")
    public void addingOneItem() {
        ApiRequests apiRequests = new ApiRequests();
        apiRequests.addToCart("377697");
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        browserWrapper.refreshPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("Removing Item from the cart")
    public void removingItemFromTheCart() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ItemComponent itemComponent = browserWrapper.createPage(ItemComponent.class);
        itemComponent.RemoveItem();
    }

    @Then("validate cart is empty")
    public void checkThatTheCartDoesnTContainIt() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ItemComponent itemComponent = browserWrapper.createPage(ItemComponent.class);
        Assertions.assertEquals(0, itemComponent.GetItemsInTheCart());
    }

    @When("I add one item to the cart via UI")
    public void iAddOneItemToTheCartViaUI() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ItemComponent itemComponent = browserWrapper.createPage(ItemComponent.class);
        itemComponent.AddItem();
    }

    @And("Remove item from the cart with API")
    public void removeItemFromTheCartWithAPI() {
        ApiRequests apiRequests = new ApiRequests();
        int status  = apiRequests.removeAllItemsFromCart();
        context.put("status", status);
    }

    @Then("validate cart empty")
    public void validateCartEmpty() {
        int status = context.get("status");
        Assert.assertEquals(200, status);
    }
}

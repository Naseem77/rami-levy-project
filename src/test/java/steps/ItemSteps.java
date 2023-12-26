package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.ItemComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ItemSteps {
    private TestContext context;

    public ItemSteps(TestContext context) {
        this.context = context;
    }
    @When("Adding one item")
    public void addingOneItem() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ItemComponent itemComponent = browserWrapper.createPage(ItemComponent.class);
        itemComponent.AddItem();
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
}

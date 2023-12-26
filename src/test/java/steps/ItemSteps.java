package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.Item;
import Logic.LoginPage;
import Logic.RamiLeviHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ItemSteps {
    private TestContext context;


    public ItemSteps(TestContext context) {
        this.context = context;
    }
    @When("Adding one item")
    public void addingOneItem() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");

        WebElement elementToHover = browserWrapper.GetDriver().findElement(By.xpath("//*[@id=\"products-gallery-swiper\"]/div/div[4]"));

        Actions actions = new Actions(browserWrapper.GetDriver());

        actions.moveToElement(elementToHover).perform();
        Item item = new Item(browserWrapper.GetDriver());
        item.AddItem();

    }

    @And("Removing Item from the cart")
    public void removingItemFromTheCart() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        WebElement elementToHover = browserWrapper.GetDriver().findElement(By.xpath("//*[@id=\"market\"]/ul/li[1]"));

        Actions actions = new Actions(browserWrapper.GetDriver());

        actions.moveToElement(elementToHover).perform();
        Item item = new Item(browserWrapper.GetDriver());
        item.RemoveItem();
    }

    @Then("check that the cart doesn't contain it")
    public void checkThatTheCartDoesnTContainIt() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        Item item = new Item(browserWrapper.GetDriver());
        Assertions.assertEquals(0,item.GetItemsInTheCart());
    }
}

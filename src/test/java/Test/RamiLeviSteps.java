package Test;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        int retries=0;
        while(!currentText.equals(name) && retries < 10){
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


    @Given("I have navigated to Rami Levi Home Page")
    public void iHaveNavigatedToRamiLeviHomePage() {
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        RamiLeviHomePage ramiLeviHomePage = browserWrapper.createPage(RamiLeviHomePage.class, "http://rami-levy.co.il");

    }
    @When("I Click AllDiscounts Button")
    public void iClickAllDiscountsButton() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        AllDiscountsComponent alldisconts = new AllDiscountsComponent(browserWrapper.GetDriver());
        alldisconts.ClickAllDiscountButton();
        Set<String> windowHandles = browserWrapper.GetDriver().getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        String secondTab = windowHandlesList.get(1);
        browserWrapper.GetDriver().switchTo().window(secondTab);
        System.out.println("WE GOT THIS"  + browserWrapper.GetDriver().getCurrentUrl());
    }
    @Then("Validate that I navigate to the correct page")
    public void iClickAllDiscountsButtonAndValidateThatINavigateToTheCorrectPageAnd() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        Assertions.assertEquals(browserWrapper.GetDriver().getCurrentUrl(),"https://www.rami-levy.co.il/he/online/feed");
    }
    @When("Adding one item")
    public void addingOneItem() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");

        WebElement elementToHover = browserWrapper.GetDriver().findElement(By.xpath("//*[@id=\"products-gallery-swiper\"]/div/div[4]"));

        Actions actions = new Actions(browserWrapper.GetDriver());

        actions.moveToElement(elementToHover).perform();
        Item item=new Item(browserWrapper.GetDriver());
        item.AddItem();

    }



    @And("Removing Item from the cart")
    public void removingItemFromTheCart() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        WebElement elementToHover = browserWrapper.GetDriver().findElement(By.xpath("//*[@id=\"market\"]/ul/li[1]"));

        Actions actions = new Actions(browserWrapper.GetDriver());

        actions.moveToElement(elementToHover).perform();
        Item item=new Item(browserWrapper.GetDriver());
        item.RemoveItem();
    }

    @Then("check that the cart doesn't contain it")
    public void checkThatTheCartDoesnTContainIt() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        Item item=new Item(browserWrapper.GetDriver());
        Assertions.assertEquals(0,item.GetItemsInTheCart());
    }
}
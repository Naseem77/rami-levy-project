package steps;

import ramiLevi.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ramiLevi.BrowserWrapper;
import ramiLevi.LoginPage;
import ramiLevi.RamiLeviHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RamiLeviSteps {
    private TestContext context;
//    saleh zarora
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
    public void iLoginWithUserTzahiTzahiComAndPasswordAa(String user, String password) {
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
    public void onRamiLeviHomePageTzahi(String name) {
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
}

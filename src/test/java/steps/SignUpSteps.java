package steps;

import Infra.BrowserWrapper;
import Infra.TestContext;
import Logic.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SignUpSteps {
    private TestContext context;

    public SignUpSteps(TestContext context) {
        this.context = context;
    }


    @When("On login popup - I click signup")
    public void OnloginPopupIClickSignup() throws InterruptedException {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SignUp signUp = browserWrapper.createPage(SignUp.class);
//        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
//        SignUp signUp = browserWrapper.getCurrentPage();
        signUp.ClickSignup();
        //  browserWrapper.createPage(SignUp.class);

    }

    @Then("On Signup popup fill information")
    public void onSignupPopupFillInformation() throws Exception{
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SignUp signUpPage = browserWrapper.createPage(SignUp.class);
        signUpPage.signup("sam","same","sam12113@gmail.com", "test1911","211805106");

    }

    @And("email popup appers")
    public void emailPopupAppers() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SignUp signUpPage = browserWrapper.createPage(SignUp.class);
        Assertions.assertTrue(signUpPage.PopUPIsDisabled());


    }
}

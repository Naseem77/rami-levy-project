package steps;

import Infra.BrowserWrapper;
import io.cucumber.java.*;

public class Hooks {


    private LoginSteps stepDefinitions;

    public Hooks(LoginSteps stepDefinitions) {
        this.stepDefinitions = stepDefinitions;
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @Before
    public void before(Scenario scenario) throws InterruptedException {
        System.out.println("*** Before " + scenario.getName());
//        loginToRamiLevi();
    }


    private void loginToRamiLevi() throws InterruptedException {
        stepDefinitions.iHaveNavigatedToRamiLevi();
        stepDefinitions.onRamiLeviHomePageIClickLogin();
        stepDefinitions.iLoginWithUserAndPassword("saeedyasen41@gmail.com", "Aש123123");
        stepDefinitions.onRamiLeviHomePage("סעיד");
    }


    @BeforeStep
    public void beforeStep(){
    }
    @After
    public void afterEach(){

    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }
}

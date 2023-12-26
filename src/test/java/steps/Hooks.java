package steps;

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
            loginToRamiLevi();
    }


    private void loginToRamiLevi() throws InterruptedException {
        stepDefinitions.iHaveNavigatedToRamiLevi();
        stepDefinitions.onRamiLeviHomePageIClickLogin();
//        stepDefinitions.iLoginWithUserAndPassword("salehzarora.z.9@gmail.com", "saleh12345");
//        stepDefinitions.onRamiLeviHomePage("ס2");
//          stepDefinitions.iLoginWithUserAndPassword("salehzarora.z.007@gmail.com", "saleh12345");
//         stepDefinitions.onRamiLeviHomePage("סאלח");
        stepDefinitions.iLoginWithUserAndPassword("saeedyasen41@gmail.com", "Aש123123");
        stepDefinitions.onRamiLeviHomePage("סעיד");

    }

    @BeforeStep
    public void beforeStep(){


    }
    @After
    public void afterEach(Scenario scenario){
        System.out.println("*** After " + scenario.getName());
        System.out.println(scenario.getStatus());
        if(!scenario.getStatus().equals(Status.PASSED)){
            //TAKE SCREENSHOT
        }

    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }
}

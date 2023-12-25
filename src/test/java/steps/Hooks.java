package steps;

import io.cucumber.java.*;

public class Hooks {


    private RamiLeviSteps stepDefinitions;

    public Hooks(RamiLeviSteps stepDefinitions) {
        this.stepDefinitions = stepDefinitions;
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("*** Before " + scenario.getName());
        loginToRamiLevi();
    }


    private void loginToRamiLevi() {
        stepDefinitions.iHaveNavigatedToRamiLevi();
        stepDefinitions.onRamiLeviHomePageIClickLogin();
        stepDefinitions.iLoginWithUserAndPassword("salehzarora.z.9@gmail.com", "saleh12345");
        stepDefinitions.onRamiLeviHomePage("ס2");
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

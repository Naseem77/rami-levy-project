package Test;

import io.cucumber.java.*;

public class Hooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("*** Before " + scenario.getName());
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

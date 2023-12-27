package steps;

import Infra.BrowserWrapper;
import io.cucumber.java.*;

public class Hooks {



    public Hooks() {

    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @Before
    public void before(Scenario scenario) throws InterruptedException {
        System.out.println("*** Before " + scenario.getName());
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

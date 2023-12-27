package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUp extends PageBase {
    private static final String SUBMIT_BUTTON = "//*[@id=\"__BVID__319___BV_modal_body_\"]/div/div[2]/div/div/div/div[5]/button[2]";
    private static final String SIGNUP_BUTTON = "//*[@id=\"__BVID__319___BV_modal_body_\"]/div/div[2]/div/div/div[4]/button";
    private By email = By.id("email");
    private By passwordInput = By.id("password");
    private By firstName = By.id("f-name");
    private By lastName = By.id("l-name");
    private By Password = By.xpath("//*[@id=\"__BVID__313___BV_modal_body_\"]/div/div[2]/div/div/div/div[2]/div[5]/input");
    private By id = By.id("identity_card");
    WebElement submit;
    WebElement signup;
    public SignUp(WebDriver driver){
        super(driver);
    }

    public void ClickSignup() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.signup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGNUP_BUTTON)));
        signup.click();

    }

    public void signup(String Name, String lName,String Email, String password, String userId) throws InterruptedException {
        driver.findElement(firstName).sendKeys(Name);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(id).sendKeys(userId);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_BUTTON)));
        submit.click();
    }
}

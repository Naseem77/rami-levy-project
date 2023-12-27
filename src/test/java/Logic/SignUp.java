package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUp extends PageBase {
    private  final String SUBMIT_BUTTON = "//div[@class=\"register-online\"]//button[@aria-label=\"קחו אותי לסופר! - הרשם\"]";
    private  final String SIGNUP_BUTTON = "//div[@class=\"text-center mt-2 mb-4\"]//button";
    private final String OP_UP_DISABLED="//div[@class=\"register-online\"]";
    private By email = By.id("email");
    private By passwordInput = By.id("password");
    private By firstName = By.id("f-name");
    private By lastName = By.id("l-name");
    private By Password = By.xpath("//div[@class=\"position-relative mb-3\"]//input[@placeholder=\"אישור סיסמה*\"]");
    ////*[@id="__BVID__168___BV_modal_body_"]/div/div[2]/div/div/div/div[2]/div[5]/input
    private By id = By.id("identity_card");
    private WebElement submit;
    private WebElement PopUpIsDisabled;
    private WebElement signup;
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

    public boolean PopUPIsDisabled() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.PopUpIsDisabled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OP_UP_DISABLED)));
        return PopUpIsDisabled.isDisplayed();
    }
}

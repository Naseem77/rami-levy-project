package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase {
    private static final String SUBMIT_BUTTON = "//button[@aria-label='כניסה']";
    private By userInput = By.id("email");
    private By passwordInput = By.id("password");
    WebElement submit;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(userInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMIT_BUTTON)));
        TimeUnit.MILLISECONDS.sleep(100);
        submit.click();
    }

}

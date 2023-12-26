package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class RamiLeviHomePage  extends PageBase {

    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//div[@id=\"login-user\"]";
    private final String FAST_BUYING_BUTTON = "quick-buy-btn";
    private final String CART = "//*[@id=\"market\"]/ul/li[1]";

    private WebElement loginButton;
    private WebElement userNameLabel;
    private WebElement fastBuyButton;
    public RamiLeviHomePage(WebDriver driver) {
        super(driver);
        this.loginButton = this.driver.findElement(By.xpath(LOGIN_BUTTON));
        this.fastBuyButton = this.driver.findElement(By.id(FAST_BUYING_BUTTON));
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public String getLoginUserText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.userNameLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(USER_NAME_LABEL)));
        return this.userNameLabel.getText();
    }

    public void clickFastBuy(){
        this.fastBuyButton.click();
    }

    public int checkCartLength(){
        List<WebElement> cart = this.driver.findElements(By.xpath(CART));
        return cart.size();
    }
}

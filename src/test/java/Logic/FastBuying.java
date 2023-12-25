package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FastBuying extends PageBase {
    private static final String SEARCH_INPUT = "list-product";
    private static final String CONTINUE_BUTTON ="//div[@aria-label=\"המשך\"]";
    private static final String ADDING_ITEM ="(//div[@class='d-flex flex-wrap justify-content-between p-1']//div[@class='plus-minus position-absolute']//button)[1]";

    private static final String FINISH_BUTTON ="//div[contains(text(), 'סיימתי')]";
    public static final String CLOSE_POPUP_SHIPPING="(//div[@id=\"close-popup\"])[2]";
    private WebElement continueButton;

    private WebElement addingItemToCart;
    private WebElement finishButton;
    private WebElement closePopUpShipping;

    public FastBuying(WebDriver driver) {
        super(driver);
    }

    public void FastBuy(String searchItem){
        driver.findElement(By.id(SEARCH_INPUT)).sendKeys(searchItem);
    }

    public void continueButton(){
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.continueButton = this.driver.findElement(By.xpath(CONTINUE_BUTTON));
        this.continueButton.click();


    }

    public void FinishingFastBuyingProcess(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.addingItemToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADDING_ITEM)));
        this.addingItemToCart.click();
        this.closePopUpForShipping();
        this.finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FINISH_BUTTON)));
        driver.findElement(By.xpath(FINISH_BUTTON)).click();
    }

    public void closePopUpForShipping(){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            this.closePopUpShipping = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_POPUP_SHIPPING)));
            closePopUpShipping.click();
    }
}

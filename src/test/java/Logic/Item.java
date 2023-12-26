package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Item extends PageBase {
    public static final String WCLASSICID="(//div[@class=\"swiper-slide\"][2]//button)[1]";
    public static final String REMOVEITEM="//div[@class=\"number position-relative\"]//button";
    public static final String EXIT_CITY_POPUP="//div[@id=\"close-popup\"]";
    public static final String ITEMS_IN_THE_CART="//*[@id=\"market\"]/ul";
    private WebElement Wclassic;
    private WebElement Removeitem;
    private WebElement ExitCityPopUp;

    WebElement PlusIcon;

    public Item(WebDriver driver) {
        super(driver);

    }
    public void AddItem(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.Wclassic = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(WCLASSICID)));
        Wclassic.click();
        this.ExitCityPopUp=driver.findElement(By.xpath(EXIT_CITY_POPUP));
        this.ExitCityPopUp.click();

    }
    public void RemoveItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.Removeitem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(REMOVEITEM)));
        Removeitem.click();

    }
    public int GetItemsInTheCart(){
        try {
            // Introduce a pause of 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> items=driver.findElements(By.xpath(ITEMS_IN_THE_CART));
        return items.size();
    }
}

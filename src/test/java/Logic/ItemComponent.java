package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemComponent extends PageBase {
    public final String WCLASSICID="(//div[@class=\"swiper-slide\"][2]//button)[1]";
    public final String REMOVEITEM="//div[@class=\"number position-relative\"]//button";
    public final String EXIT_CITY_POPUP="//div[@id=\"close-popup\"]";
    public final String ITEMS_IN_THE_CART="//*[@id=\"market\"]/ul";
    private final String HOVER_ON_ITEM_TO_ADD = "//*[@id=\"products-gallery-swiper\"]/div/div[4]";
    private final String HOVER_ON_ITEM_TO_REMOVE = "//*[@id=\"market\"]/ul/li[1]";
    private WebElement Wclassic;
    private WebElement Removeitem;
    private WebElement ExitCityPopUp;

    private WebElement HoverOnItemToAdd;
    private WebElement HoverOnItemToRemove;

    public ItemComponent(WebDriver driver) {
        super(driver);

    }
    public void AddItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.HoverOnItemToAdd = this.driver.findElement(By.xpath(HOVER_ON_ITEM_TO_ADD));
        Actions actions = new Actions(this.driver);
        actions.moveToElement(HoverOnItemToAdd).perform();
        this.Wclassic = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(WCLASSICID)));
        Wclassic.click();
        this.ExitCityPopUp=driver.findElement(By.xpath(EXIT_CITY_POPUP));
        this.ExitCityPopUp.click();

    }
    public void RemoveItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.HoverOnItemToRemove = this.driver.findElement(By.xpath("//*[@id=\"market\"]/ul/li[1]"));
        Actions actions = new Actions(this.driver);
        actions.moveToElement(HoverOnItemToRemove).perform();
        this.Removeitem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(REMOVEITEM)));
        Removeitem.click();

    }
    public int GetItemsInTheCart(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> items=driver.findElements(By.xpath(ITEMS_IN_THE_CART));
        return items.size();
    }
}

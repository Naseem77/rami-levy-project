package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllDiscountsPage extends PageBase {
    public  final String ALLDISCOUNTSBUTTON="//h2[contains(text(), 'לכל ההטבות')]/ancestor::a[1]";
    WebElement AllDiscount;

    public AllDiscountsPage(WebDriver driver) {
        super(driver);
        AllDiscount=this.driver.findElement(By.xpath(ALLDISCOUNTSBUTTON));
    }
    public void ClickAllDiscountButton(){
        AllDiscount.click();
    }
}

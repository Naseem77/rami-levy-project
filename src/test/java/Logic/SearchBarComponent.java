package Logic;


import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBarComponent extends PageBase {
    private static final String SEARCH_INPUT = "//*[@id='destination']";
    private static final String SEARCH_BUTTON = "//*[@id=\"search\"]//div[@class=\"px-2 w-100 bd-highlight\"]//button[2]";

    public SearchBarComponent(WebDriver driver) {
        super(driver);
    }

    public void searchInput(String input){
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(input);
    }

    public void searchButton(){
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }

}


package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserWrapper {
    private static final String webDriverPath = "chromedriver.exe";
    private PageBase currentPage;
    private WebDriver driver;
    public BrowserWrapper() {
        System.setProperty("webdriver.chrome.driver", webDriverPath);
         driver = new ChromeDriver();
         driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public <T extends PageBase> T createPage(Class<T> pageType){
        return createPage(pageType, null);
    }

    public <T extends PageBase> T createPage(Class<T> pageType, String url){
        try {
            Constructor<T> constructor = pageType.getConstructor(WebDriver.class);
            if(url!=null){
                driver.get(url);
            }
            T page = constructor.newInstance(driver);
            currentPage = page;
            return page;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("relevant constructor not found", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        driver.close();
    }

    public <T extends PageBase> T getCurrentPage(){
        return (T)currentPage;
    }

}

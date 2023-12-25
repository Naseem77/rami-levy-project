package Logic;

import Infra.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressEdit extends PageBase {



    private final String PROFILE_B = "//*[@id=\"login-user\"]";
    private final String ADDRESS_B = "//*[@id=\"dashboard-addresses\"]";
    private final String ADD_ADDRESS_B="//*[@id=\"main-content\"]/div/div[2]/div/div/div/div/div[2]/div[1]";
    private final String SAVE_B = "//*[@id=\"SaveFullAddress\"]";

    private final String CLICK_CITY = "//*[@id=\"list-area-city-0\"]";

    private  final  String CLICK_STREET = "//*[@id=\"list-area-street-0\"]";

    private  final  String ADDRESS_EXISTS = "//*[@id=\"main-content\"]//label";

    private By cityInput = By.id("addresses-a-city");
    private By streetInput = By.id("addresses-a-street");
    private By houseInput = By.id("addresses-a-number");
    private By floorInput = By.id("addresses-a-floor");
    private By apartmentInput = By.id("addresses-a-house");




    private WebElement profileb;
    private WebElement addressb;
    private WebElement addaddressb;
    private WebElement saveb;
    private  WebElement clickCity ;
    private WebElement clickStreet;
    private WebElement addressExists;

    public AddressEdit(WebDriver driver)
    {
        super(driver);

    }

    public void FillAddress(String city , String street ,String house , String floor , String apartment)
    {
        driver.findElement(cityInput).sendKeys(city);

        WebDriverWait wait = new WebDriverWait(driver,10);
        this.clickCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLICK_CITY)));
        clickCity.click();


        driver.findElement(streetInput).sendKeys(street);

        this.clickStreet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLICK_STREET)));
        clickStreet.click();


        driver.findElement(houseInput).sendKeys(house);
        driver.findElement(floorInput).sendKeys(floor);
        driver.findElement(apartmentInput).sendKeys(apartment);

        this.saveb = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SAVE_B)));
        saveb.click();
    }


      //                                 maybe need                                              //
     //                      WebDriverWait wait = new WebDriverWait(driver, 10);                //
    //         wait.until(ExpectedConditions.elementToBeClickable(profileLocator)).click();    //
    public void ProfileClick()
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.profileb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROFILE_B)));

        this.profileb.click();
    }

    public void AddressClick()
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.addressb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADDRESS_B)));

        this.addressb.click();
    }

    public void AddAddressClick()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.addaddressb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_ADDRESS_B)));

        this.addaddressb.click();
    }



    public boolean CheckAddress()
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.addressExists = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADDRESS_EXISTS)));



        return this.addressExists.isDisplayed();



    }






}

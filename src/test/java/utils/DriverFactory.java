package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class DriverFactory
{

    /*public static RemoteWebDriver driver;
    DesiredCapabilities capabilities;*/
    public static WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException
    {
        /*capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("browserName", "firefox");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);*/
        System.setProperty("webdriver.chrome.driver", "C:/Users/sraav/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.close();
    }

    public void waitingforelement(WebElement uiElement , WebDriver mydriver){
        WebDriverWait wait = new WebDriverWait(mydriver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(uiElement));
    }
    public void verifyIsElementIsDisplayed(WebElement uiElement , WebDriver mydriver) {
        WebDriverWait wait = new WebDriverWait(mydriver, 20);
        wait.until(ExpectedConditions.visibilityOf((WebElement) uiElement));
    }

    public void waitForInvisibility(WebElement webElement, int maxSeconds) {
        Long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {}
        } catch (StaleElementReferenceException e) {

        } catch (NoSuchElementException e){}
    }

}

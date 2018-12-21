package utils.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public interface WebdriverUtilities {
    WebDriver driver = DriverFactory.driver;
    WebDriverWait wait = new WebDriverWait( driver,30 );

    static void waitForElementToBeVisible(WebElement element){
        wait.until( ExpectedConditions.visibilityOf( element ) );
    }

    static void waitForElementToBeClickable(WebElement element){
        wait.until( ExpectedConditions.elementToBeClickable( element ) );
    }
}

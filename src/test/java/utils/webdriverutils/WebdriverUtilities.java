package utils.webdriverutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.util.List;

public interface WebdriverUtilities {
    WebDriver driver = DriverFactory.driver;
    WebDriverWait wait = new WebDriverWait( driver, 30 );

    static void waitForElementToBeVisible(List <WebElement> element) {
        wait.until( ExpectedConditions.visibilityOf( (WebElement) element ) );
    }

    static void waitForElementToBeClickable(WebElement element) {
        wait.until( ExpectedConditions.elementToBeClickable( element ) );
    }

    static void waitForElementToBeVisible(WebElement element) {
        wait.until( ExpectedConditions.elementToBeClickable( element ) );
    }
    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static void scrollTo(WebDriver driver, List <WebElement> element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }
    }

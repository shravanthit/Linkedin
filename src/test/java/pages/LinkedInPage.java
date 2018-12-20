package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;

import static utils.DriverFactory.driver;

public class LinkedInPage {
    WebDriver driver = DriverFactory.driver;
    DriverFactory dFactory = new DriverFactory();
    DriverFactory visible = new DriverFactory();

    @FindBy(id = "login-email")
    WebElement email;

    @FindBy(id = "login-password")
    WebElement pwd;

    @FindBy(id = "login-submit")
    WebElement signIn;

    @FindBy(id="feed-tab-icon")
    WebElement homeIcon;



    public void launchLinkedinPage() {
        driver.get( "https://www.linkedin.com/" );
        dFactory.waitingforelement( email,driver );

    }

    public void enterDetails(String Email, String Pwd) {
        email.click();
        email.sendKeys( Email );
        pwd.sendKeys( Pwd );
        signIn.click();
    }

    public boolean verifyRegistered() {

        return homeIcon.isDisplayed();
    }

    //public class login(String email) {
    //}
}


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.DriverFactory;
import utils.webdriverutils.WebdriverUtilities;

import java.util.List;

public class LinkedInPage {
    WebDriver driver = DriverFactory.driver;

    @FindBy(id = "login-email")
    WebElement email;

    @FindBy(id = "login-password")
    WebElement pwd;

    @FindBy(id = "login-submit")
    WebElement signIn;

    @FindBy(id = "feed-tab-icon")
    WebElement homeIcon;

    @FindBy(id = "profile-nav-item")
    WebElement profileIcon;

    @FindBy(css = ".nav-settings__linkcard.nav-settings__block")
    WebElement viewProfile;

    @FindBy(className = "pv-dashboard-section__title")
    WebElement dashboard;

    @FindBy(xpath = ("//a[@data-control-name='nav.settings_signout']"))
    WebElement signOut;

    @FindBy(id = "jobs-tab-icon")
    WebElement jobIcon;

    @FindBy(xpath = ("//input[contains(@id,'jobs-search-box-keyword-id')]"))
    WebElement jobRole;

    @FindBy(xpath = ("//input[contains(@id,'jobs-search-box-location-id')]"))
    WebElement jobLocation;

    @FindBy(xpath = ("//button[contains(@class,'jobs-search-box__submit-button button-secondary-large-inverse')]"))
    WebElement jobSearch;

    @FindBy(id = "registration-submit")
    WebElement submit;

    @FindBys(@FindBy(xpath = ("//ul[@class='jobs-search-results__list artdeco-list artdeco-list--offset-4']/li")))
    private List <WebElement> jobList;

    @FindBy(xpath = ("//h3[contains(text(), 'Experience Level')]"))
    WebElement experienceLevelTab;

    public void launchLinkedinPage() {
        driver.get( "https://www.linkedin.com/" );
        driver.manage().window().maximize();
        WebdriverUtilities.waitForElementToBeVisible( email );
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

    public void myProfilepage() throws InterruptedException {
        profileIcon.click();
       WebdriverUtilities.waitForElementToBeClickable( viewProfile );
        viewProfile.click();

    }

    public boolean verifyOnDashboardPage() {
        WebdriverUtilities.waitForElementToBeVisible( dashboard );
        return dashboard.isDisplayed();
    }

    public void signOut() {
        profileIcon.click();
        WebdriverUtilities.waitForElementToBeClickable( signOut );
        signOut.click();

    }

    public boolean verifySignout() {
        WebdriverUtilities.waitForElementToBeVisible( signOut );
        return signOut.isDisplayed();

    }

    public void SearchJob(String jobName, String jobLoc) {
        WebdriverUtilities.waitForElementToBeVisible( jobIcon );
        jobIcon.click();
        jobRole.sendKeys( jobName );
        jobLocation.sendKeys( jobLoc );
        WebdriverUtilities.waitForElementToBeClickable( jobSearch );
        jobSearch.click();
        WebdriverUtilities.waitForElementToBeVisible( experienceLevelTab );

    }

    public boolean verifyresults() {
        return jobList.size() > 0;
    }

}


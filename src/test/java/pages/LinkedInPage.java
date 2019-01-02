package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.DriverFactory;
import utils.webdriverutils.WebdriverUtilities;

import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = ("//span[contains(text(), 'My Network')]"))
    WebElement myNetwork;

    @FindBy(xpath = ("//artdeco-tab[@class ='active ember-view']"))
    WebElement people;

    @FindBys(@FindBy(xpath = ("//ul[@class ='js-mn-discovery-entity-list__pymk mn-discovery-entity-list ember-view']//li[contains(@class,'ember-view')]")))
    WebElement peopleList;

    @FindBys(@FindBy(xpath = ("//button[@data-control-name='invite']")))
    List <WebElement> buttons;

    @FindBy(xpath = "https://www.asos.com/")
    WebElement accountIcon;

    @FindBy(xpath = ("//p[@class ='artdeco-toast-message']"))
    WebElement notification;

    @FindBy(xpath = ("//div[@class ='nav-search-typeahead']"))
    WebElement searchBar;

    @FindBy(xpath = ("//a[@data-control-name='topcard_view_all_connections']"))
    WebElement connections;

    @FindBy(xpath = ("//span[contains(text(), 'Connections')]"))
    WebElement onConnectionPage;

    @FindBy(xpath = ("//span[contains(text(), 'Search')]"))
    WebElement searchIcon;

    @FindBy(xpath = ("//span[contains(text(), 'Mahesh Thuma')]"))
    WebElement mahesh;

    public void launchAsosPage() {
        driver.get( "https://https://www.asos.com/" );
        driver.manage().window().maximize();
        WebdriverUtilities.waitForElementToBeVisible( email );
    }


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

    public void sendConnectionReq() throws InterruptedException {
        myNetwork.click();
        WebdriverUtilities.waitForElementToBeVisible( people );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,700)", "" );
        System.out.println( "Size is:" + buttons.size() );
        Random sendreq = new Random();
        int randomvalue = sendreq.nextInt( buttons.size() );
        System.out.println( "random no is: " + randomvalue );
        buttons.get( randomvalue ).click();
    }

    public boolean verifyConnectionSent() {
        WebdriverUtilities.waitForElementToBeVisible( notification );
        return notification.isDisplayed();
    }

    public void searchPersonProfile() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].click();", searchBar );
        Actions actions = new Actions( driver );
        actions.moveToElement( searchBar );
        actions.click();
        actions.sendKeys( "mahesh thuma" ).sendKeys( Keys.ENTER );
        actions.build().perform();
        wait();
        mahesh.click();
        WebdriverUtilities.waitForElementToBeVisible( connections );
        connections.click();
    }

    public boolean verifyConnectionsChecked() {
        WebdriverUtilities.waitForElementToBeVisible( onConnectionPage );
        return onConnectionPage.isDisplayed();
    }
}



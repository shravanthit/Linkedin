package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LinkedInPage;
import utils.DriverFactory;

public class LinkedinSteps {
    WebDriver driver = DriverFactory.driver;
    LinkedInPage linkedIn = PageFactory.initElements( driver, LinkedInPage.class );


    @Given("^I am on Linkedin Home page$")
    public void on_Linkedin_page() {
        linkedIn.launchLinkedinPage();
    }

    @When("^I Enter (.*) and (.*)$")
    public void i_Enter_details(String email, String pwd) {
        linkedIn.enterDetails( email, pwd );
    }

    @Then("^Login Should be successful$")
    public void loginSuccessful() {
        Assert.assertTrue( "Registration not successful", linkedIn.verifyRegistered() );

    }

    @Given("^I am logged in with (.*) and (.*)$")
    public void loggedIn(String email, String pwd) {
        on_Linkedin_page();
        i_Enter_details( email, pwd );
        loginSuccessful();

    }


    @When("^I navigate to my profile page$")
    public void myProfile() throws InterruptedException {
        linkedIn.myProfilepage();

    }

    @Then("^I should see my Dashboard")
    public void dashboard() {
        linkedIn.verifyOnDashboardPage();
        Assert.assertTrue( "not on dashboard page", linkedIn.verifyOnDashboardPage() );

    }

    @When("I click on signout")
    public void click_signOut() throws InterruptedException {
        myProfile();
        dashboard();
        linkedIn.signOut();

    }

    @Then("I should be succesfully logged out")
    public void verifySignout() {

    }

    @When("I click on job icon and enter (.*) and (.*)")
    public void searchJobs(String jobName, String jobLoc) {
        linkedIn.SearchJob( jobName, jobLoc );

    }

    @Then("I should be able to see list of jobs")
    public void listjobs() {
        Assert.assertTrue( "is not true", linkedIn.verifyresults() );
    }

    @When("I am on connection page and sent connection req to random person")
    public void connectionReq() throws InterruptedException {
        linkedIn.sendConnectionReq();
    }

    @Then("I should be able to see the message that connection req has been sent")
    public void reqSentSuccesfull() {
        Assert.assertTrue( "test failed", linkedIn.verifyConnectionSent() );

    }

    @When("I am on homepage and searched persons profile and connections")
    public void searchPerson() throws InterruptedException {
        linkedIn.searchPersonProfile();

    }

    @Then("I should be able to see number of connections")
    public void personConnections(){
        Assert.assertTrue( "connections test failed" ,linkedIn.verifyConnectionsChecked());

    }

    @Given("I am on asos home page")
    public void launchAsos(){
        linkedIn.launchAsosPage();
    }

    @When( "I search product and select randomly and add to basket" )
    public void searchProduct() throws InterruptedException {
        linkedIn.searchProduct();

    }

    @Then("I should be able to see the product in the basket")
    public void search(){

    }
}


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
    public void registration_Should_be_successful() {
        linkedIn.verifyRegistered();
        Assert.assertTrue( "Registration not successful", linkedIn.verifyRegistered() );

    }
}
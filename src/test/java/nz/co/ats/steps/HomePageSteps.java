package nz.co.ats.steps;

import nz.co.ats.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


public class HomePageSteps {

    @Autowired
    private HomePage   homePage;


    @Given("I open the home page")
    public void iOpenHomePage() {
        homePage.navigateToHome();
    }

    @Then("I should see the page title as {string}")
    public void iShouldSeePageTitle(String title) {
        Assertions.assertEquals(title, homePage.getTitle());
    }

}

package steps;

import context.ScenarioContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.HomePage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.*;

public class HomePageSteps {

    /**
     * Page objects
     */
    private HomePage homePage;
    private ScenarioContext context;

    public HomePageSteps(ScenarioContext context, HomePage homePage) {
        this.context = context;
        this.homePage = homePage;
    }

    /**
     * Static selectors
     */
    private static final By cookiesDialogBoxCssSelector = By.cssSelector("div[data-service=\"cookies\"]");
    private static final By cookiesAcceptBtnId = By.id("axeptio_btn_acceptAll");
    private static final By subscriptionDialogBoxClassName = By.className("modal-dialog");
    private static final By closeSubscriptionId = By.id("boutonFermeture");

    /**
     * Steps definitions
     */
    @Given("Go to home page")
    public void goToTheHomePage() {
        homePage.navigateToEnv();
        homePage.acceptsCookies(cookiesDialogBoxCssSelector, cookiesAcceptBtnId);
        //Using acceptsCookies Method to close the Subscription Dialog Box
        homePage.acceptsCookies(subscriptionDialogBoxClassName, closeSubscriptionId);
    }

    @When("Scroll down to footer")
    public void scrollDownToFooter() {
        homePage.goToFooter();
    }

    @Then("The Google Plus icon is no longer visible")
    public void theGoogleIconIsNoLongerVisible() {
        assertFalse(homePage.isGooglePlusPresent(), "The link to Google Plus is still present");
    }

    @And("Click on {string}")
    public void clickOn(String linkText) {
        context.set(Context.MY_SPACE_URL, homePage.goToMySpace());
    }


    @Then("The page is inaccessible with {string}")
    public void thePageIsInaccessibleWith(String link) throws UnsupportedEncodingException {
        assertNotEquals(link, URLDecoder.decode(context.get(Context.MY_SPACE_URL), StandardCharsets.UTF_8.toString()), "The link " + link + " is inaccessible");
    }

    @When("Click on {string} and click on question {string}")
    public void clickOnAndClickOnQuestion(String questionsGroup, String question) {
        homePage.openQuestionAnswer(questionsGroup);
    }
}

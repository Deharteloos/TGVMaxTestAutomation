package steps;

import context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.TrainlinePage;

public class TrainlinePageSteps {

    /**
     * Page objects declarations
     */
    private TrainlinePage trainlinePage;
    private ScenarioContext context;
    private HomePage homePage;

    public TrainlinePageSteps(ScenarioContext context, TrainlinePage trainlinePage, HomePage homePage) {
        this.context = context;
        this.trainlinePage = trainlinePage;
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
    @Given("Go to page {string}")
    public void goToPage(String link) {
        trainlinePage.goToTrainlinePage(link);
        homePage.acceptsCookies(cookiesDialogBoxCssSelector, cookiesAcceptBtnId);
        homePage.acceptsCookies(subscriptionDialogBoxClassName, closeSubscriptionId);
    }


    @When("Click on {string} and click on {string}")
    public void clickOnAndClickOn(String questionsGroup, String question) {
        trainlinePage.openQuestionAnswer(questionsGroup);
    }

    @And("Click on {string} in the text")
    public void clickOnInTheText(String here) {
        trainlinePage.clickOnHere();
    }


}

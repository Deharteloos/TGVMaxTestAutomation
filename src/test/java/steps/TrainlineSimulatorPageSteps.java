package steps;

import context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.TrainlineSimulatorPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TrainlineSimulatorPageSteps {

    /**
     * Page objects declarations
     */
    ScenarioContext context;
    TrainlineSimulatorPage trainlineSimulatorPage;

    public TrainlineSimulatorPageSteps(ScenarioContext context, TrainlineSimulatorPage trainlineSimulatorPage) {
        this.context = context;
        this.trainlineSimulatorPage = trainlineSimulatorPage;
    }

    /**
     * Steps definitions
     */
    @And("Click on the French flag in the navbar")
    public void clickOnTheFrenchFlagInTheNavar() {
        trainlineSimulatorPage.clickOnLanguagePicker();
    }


    @Then("The list of languages is empty")
    public void theListOfLanguagesIsEmpty() {
        assertTrue(trainlineSimulatorPage.isLanguagePickerMenuVisible(), "The languages in the list are not selectable");
    }
}

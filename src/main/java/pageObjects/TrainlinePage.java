package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrainlinePage extends Page {

    private static final Logger LOG = LogManager.getLogger(TrainlinePage.class);

    /**
     * Find By
     */
    @FindBy(css = "div[data-service=\"cookies\"]")
    private WebElement cookiesDialogBox;

    @FindBy(id = "axeptio_btn_acceptAll")
    private WebElement cookiesAcceptBtn;

    @FindBy(className = "modal-dialog")
    private WebElement subscriptionDialogBox;

    @FindBy(id = "boutonFermeture")
    private WebElement closeSubscriptionBtn;

    @FindBy(id = "faqId")
    private WebElement faqSection;

    @FindBy(css = ".style-theme.cursor-hand.row")
    private List<WebElement> questionsGroups;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[1]/div/div/div[6]/div/div/div/div[3]/div/div/div/div/div[2]/div")
    private WebElement question1;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[1]/div/div/div[6]/div/div/div/div[3]/div/div/div/div/div[3]/div/div/div/div/a")
    private WebElement hereLink;

    public void goToTrainlinePage(String link) {
        get(link);
        waitForLoadingPage();
    }

    public void openQuestionAnswer(String questions) {
        scrollToElement(faqSection);
        for(WebElement questionsGroup : questionsGroups) {
            if(questionsGroup.getText().equals(questions)) {
                clickOn(questionsGroup);
                break;
            }
        }
        clickOn(question1);
    }

    public void clickOnHere() {
        get(hereLink.getAttribute("href"));
        //clickOn(hereLink);
    }

}

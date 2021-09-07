package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Page {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    /**
     * Find By
     */
    @FindBy(className = "vsc__footer")
    private WebElement footer;

    @FindBy(css = "a[data-rfrrlink=\"Google+\"]")
    private WebElement googlePlusLink;

    @FindBy(id = "faqId")
    private WebElement faqSection;

    @FindBy(css = ".style-theme.cursor-hand.row")
    private List<WebElement> questionsGroups;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[1]/div/div/div[6]/div/div/div/div[12]/div/div/div/div/div[2]/div")
    private WebElement question1;

    @FindBy(css = "#faq-question > div > div > div.style-contenu.row > div > div > div > div > ul > li:nth-child(5) > a")
    private WebElement mySpaceLink;

    public void navigateToEnv() {
        get(config.getEnvironment());
    }

    public void goToFooter() {
        scrollToElement(footer);
    }

    public boolean isGooglePlusPresent() {
        saveScreenShotPNG();
        if(googlePlusLink != null)
            return googlePlusLink.isDisplayed();
        else return false;
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

    public String goToMySpace() {
        String link = mySpaceLink.getAttribute("href");
        clickOn(mySpaceLink);
        saveScreenShotPNG();
        return link;
    }



}

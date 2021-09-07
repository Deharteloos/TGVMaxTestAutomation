package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrainlineSimulatorPage extends Page {

    private static final Logger LOG = LogManager.getLogger(TrainlineSimulatorPage.class);

    /**
     * Find By
     */
    @FindBy(css = ".ct-dropdown-menu.language-picker")
    private WebElement languagePicker;

    @FindBy(className = "language-picker__menu")
    private WebElement languagePickerMenu;

    @FindBy(css = "body > header > div > ul > li.header__account-item.header__language > div > div.language-picker__menu-container > menu > a:nth-child(4)")
    private WebElement language;

    public void clickOnLanguagePicker() {
        clickOn(languagePicker);
        saveScreenShotPNG();
    }

    public boolean isLanguagePickerMenuVisible() {
        try {
            language.click();
            return true;
        } catch (ElementClickInterceptedException ex) {
            return false;
        }
    }

}

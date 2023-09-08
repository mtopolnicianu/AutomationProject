package pageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"oxd-main-menu-item\"]/span[text()=\"Admin\"]")
    private WebElement adminLink;
    @FindBy(css = ".oxd-topbar-header-title > .oxd-topbar-header-breadcrumb")
    private WebElement userManagementDescriptionForAdminLink;
    @FindBy(xpath = "//span[text()='Configuration ']")
    private WebElement configurationButton;
    @FindBy(linkText = "Language Packages")
    private WebElement languagePackagesOption;
    @FindBy(xpath = "(//button[text()=' Translate '])[8]")
    private WebElement spanishLanguageTranslateButton;
    @FindBy(xpath = "//h5[text()='Translate Language Package']")
    private WebElement translateLanguagePageText;
    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addLanguagePackagesButton;
    @FindBy(css = ".oxd-select-text--after")
    private WebElement selectLanguagePackagesButton;
    @FindBy(xpath = "//div[text()='Georgian (Georgia) - Georgian (Georgia)']")
    private WebElement selectGeorgiaLanguagePackage;
    @FindBy(css = ".oxd-select-text")
    private WebElement colognianGermanyLanguagePackage;

    public void clickAddLanguagePackages() {
        waitForElementToBeVisible(addLanguagePackagesButton);
        addLanguagePackagesButton.click();
    }
    public void selectColognianGermanyLanguagePackage() {
        waitForElementToBeVisible(selectLanguagePackagesButton);
        selectLanguagePackagesButton.click();

    }
    public void selectPackage(){
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView();", colognianGermanyLanguagePackage);
//        waitForElementToBeVisible(colognianGermanyLanguagePackage);
//        Actions action = new Actions(driver);
//        action.scrollToElement(colognianGermanyLanguagePackage).perform();

//        waitForElementToBeVisible(colognianGermanyLanguagePackage);
//        colognianGermanyLanguagePackage.click();
    }

    public void confirmationTranslateLanguagePage() {
        waitForElementToBeVisible(translateLanguagePageText);
        Assert.assertTrue("Page not found", translateLanguagePageText.getText().contains("Translate Language Package"));
        translateLanguagePageText.click();
    }

    public void clickTranslateSpanishButton() {
        waitForElementToBeVisible(spanishLanguageTranslateButton);
        spanishLanguageTranslateButton.click();
    }

    public void clickConfigurationButton() {
        waitForElementToBeVisible(configurationButton);
        configurationButton.click();
    }

    public void selectLanguagePackages() {
        waitForElementToBeVisible(languagePackagesOption);
        languagePackagesOption.click();
    }

    public void clickAdminLink() {
        waitForElementToBeVisible(adminLink);
        adminLink.click();
    }

    public void getActualTitleText() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void iVerifyAdditionalTextForAdminPage() {
        waitForElementToBeVisible(userManagementDescriptionForAdminLink);
        Assert.assertTrue("", userManagementDescriptionForAdminLink.getText().contains("User Management"));

    }
}

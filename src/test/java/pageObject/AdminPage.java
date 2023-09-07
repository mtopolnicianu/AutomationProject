package pageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

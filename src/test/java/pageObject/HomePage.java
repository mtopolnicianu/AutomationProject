package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
    private WebElement userNameValidation;
    @FindBy(xpath = "//img[@alt='client brand banner']") // Relative XPath
    private WebElement orangeHrmBanner;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[2]/div/div") // Absolute XPath
    private WebElement searchButton;
    @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li[2]")
    private WebElement pimLink;
    @FindBy(xpath = "//a[@class=\"oxd-main-menu-item\"]/span[text()=\"Time\"]")
    private WebElement timeLink;
    @FindBy(xpath = "//a[@class=\"oxd-main-menu-item\"]/span[text()=\"Directory\"]")
    private WebElement directoryLink;
    @FindBy(xpath = "//span[text()='Maintenance']")
    private WebElement maintenance;
    @FindBy(css = "img.oxd-userdropdown-img")
    private WebElement profilePicture;
    @FindBy(xpath = "//div[@class=\"orangehrm-dashboard-widget-name\"]/p[text()='My Actions']")
    private WebElement myActionsSection;
    @FindBy(css = "[title=Help]")
    private WebElement helpButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyUserName() {
        waitForElementToBeVisible(userNameValidation);
        Assert.assertTrue(userNameValidation.isDisplayed());
    }
    public void verifyHelpButton(){
        waitForElementToBeVisible(helpButton);
        Assert.assertTrue("Help button could not be found", helpButton.isDisplayed());
    }


}

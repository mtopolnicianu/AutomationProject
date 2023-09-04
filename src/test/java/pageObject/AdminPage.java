package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"oxd-main-menu-item\"]/span[text()=\"Admin\"]")
    private WebElement adminLink;
    @FindBy(css = ".oxd-topbar-header-title > .oxd-topbar-header-breadcrumb")
    private WebElement userManagementDescriptionForAdminLink;

    public void clickAdminLink(){
        waitForElementToBeVisible(adminLink);
        adminLink.click();
    }

    public void getActualTitleText(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    public void iVerifyAdditionalTextForAdminPage(){
        waitForElementToBeVisible(userManagementDescriptionForAdminLink);
        Assert.assertTrue("", userManagementDescriptionForAdminLink.getText().contains("User Management"));

    }
}

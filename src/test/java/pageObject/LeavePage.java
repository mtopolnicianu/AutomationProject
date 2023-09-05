package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage {
    public LeavePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li[3]")
    private WebElement leaveLink;
    @FindBy(xpath = "//span[text()='Entitlements ']")
    private WebElement entitlementsSection;

    @FindBy(css = ".oxd-input-field-bottom-space:nth-of-type(1) .oxd-radio-wrapper")
    private WebElement individualEmployeeButton;
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[1]")
    private WebElement addEntitlementsOption;

    public void clickLeaveLink() {
        waitForElementToBeVisible(leaveLink);
        leaveLink.click();
    }

    public void clickEntitlementsOption() {
        waitForElementToBeVisible(entitlementsSection);
        entitlementsSection.click();
    }

    public void selectAddEntitlementsOption() {
        waitForElementToBeVisible(addEntitlementsOption);
        addEntitlementsOption.click();
    }

    public void verifyIndividualEmployeeButtonIsChecked() {
        waitForElementToBeVisible((individualEmployeeButton));
        individualEmployeeButton.isEnabled();
    }


}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHrmPage extends BasePage{


    @FindBy(xpath = "//input[contains(@id,'chkMain')]")
    private WebElement emailSearchButton;
    @FindBy(css = "input#Form_submitForm_action_request")
    private WebElement tryItForFreeButton;

    public OrangeHrmPage(WebDriver driver) {
        super(driver);
    }

    public void enterYourEmailAddressSearchButton(){
        waitForElementToBeClickable(emailSearchButton);
        emailSearchButton.sendKeys("abc@gmail.com");
    }
}

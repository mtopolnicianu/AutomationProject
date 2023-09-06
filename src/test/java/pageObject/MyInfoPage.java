package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyInfoPage extends BasePage{
    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "My Info")
    private WebElement myInfoLink;
    @FindBy(linkText = "Contact Details")
    private WebElement contactDetailsLink;
    @FindBy(css = ".oxd-form .oxd-form-row:nth-child(3) .oxd-grid-item--gutters:nth-of-type(1) input")
    private WebElement street1Field;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    private WebElement countryDropDownList;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
   // @FindBy(css = "#oxd-toaster_1")
    @FindBy(css = ".oxd-toast-content.oxd-toast-content--success")
    private WebElement successUpdatedMessage;
    @FindBy(xpath = "//div[text()='Algeria']")
    private WebElement selectAlgeriaAsCountry;

    public void clickMyInfoOption(){
        waitForElementToBeVisible(myInfoLink);
        myInfoLink.click();
    }

    public void clickContactDetailsLink(){
        waitForElementToBeVisible(contactDetailsLink);
        contactDetailsLink.click();
    }

    public void updateStreetOne(){
        waitForElementToBeVisible(street1Field);
        street1Field.clear();
        street1Field.sendKeys("Test Street 1");
    }

    public void selectAlgeriaAsCountry(){
        waitForElementToBeVisible(countryDropDownList);
        countryDropDownList.click();
        waitForElementToBeVisible(selectAlgeriaAsCountry);
        selectAlgeriaAsCountry.click();


    }
    public void clickSaveButton(){
        waitForElementToBeVisible(saveButton);
        saveButton.click();
    }
    public void verifySuccessUpdatedMessage(){
        waitForElementToBeVisible(successUpdatedMessage);
        Assert.assertTrue(" Could not be saved, please try again!", successUpdatedMessage.getText().contains("Success"));
    }
}

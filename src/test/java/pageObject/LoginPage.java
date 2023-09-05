package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage
{

    @FindBy(name = "username")
    private WebElement userNameField;
    @FindBy(name = "password")
    private  WebElement passwordFiled;
    @FindBy(name = "username")
    private WebElement enterValidUserName;
    @FindBy(name = "password")
    private WebElement enterUserValidPassword;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions orangehrm-login-action\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class=\"oxd-alert-content oxd-alert-content--error\"]/p[text()=\"Invalid credentials\"]")
    private WebElement invalidCredentialsMessage;
    @FindBy(css = ".oxd-input-field-error-message")
    private WebElement errorMessageForEmptyUserNameField;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement errorMessageForEmptyPasswordField;
    @FindBy(xpath = "//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--gutters oxd-sheet--gray-lighten-2 orangehrm-demo-credentials']")
    private WebElement userNameAdmin;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserNameDisplayed() {
        userNameAdmin.getText();
    }

    public void addValidUserName() throws IOException {
        Properties prop = Utils.getPropertiesFile();
        waitForElementToBeVisible(enterValidUserName);
        enterValidUserName.sendKeys(prop.getProperty("userName"));
    }

    public void addInvalidUserName() throws IOException {
        Properties prop = Utils.getPropertiesFile();
        waitForElementToBeVisible(enterValidUserName);
        enterValidUserName.sendKeys(prop.getProperty("invalidUserName"));
    }

    public void addInvalidPassword() throws IOException {
        Properties prop = Utils.getPropertiesFile();
        waitForElementToBeVisible(enterUserValidPassword);
        enterUserValidPassword.sendKeys(prop.getProperty("invalidPassword"));
    }

    public void addValidPassword() throws IOException {
        Properties prop = Utils.getPropertiesFile();
        waitForElementToBeVisible(enterUserValidPassword);
        enterUserValidPassword.sendKeys(prop.getProperty("password"));
    }

    public void addUserName() {
        enterValidUserName.sendKeys("Admin");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void assertUserIsNotAllowedToLoginAccount() {
        waitForElementToBeVisible(invalidCredentialsMessage);
        Assert.assertTrue("Welcome, UserFirstName UserLastName!", invalidCredentialsMessage.getText().contains("Invalid credentials"));

    }

    public void assertRequiredUserNameField() {
        waitForElementToBeVisible(errorMessageForEmptyUserNameField);
        Assert.assertTrue("Valid username", errorMessageForEmptyUserNameField.getText().contains("Required"));
    }

    public void assertRequiredPasswordField() {
        waitForElementToBeVisible(errorMessageForEmptyPasswordField);
        Assert.assertTrue("Valid password", errorMessageForEmptyPasswordField.getText().contains("Required"));
    }

    public void assertUserNameField(){

        SoftAssert softAssert = new SoftAssert();
        waitForElementToBeVisible(userNameField);
        //softAssert.assertFalse(userNameField.isDisplayed());
        softAssert.assertTrue(userNameField.isDisplayed());
        softAssert.assertAll();
       // Assert.assertTrue(userNameField.isDisplayed());
      //  Assert.assertFalse(userNameField.isDisplayed());

    }
    public void assertPasswordField(){
        waitForElementToBeVisible(passwordFiled);
        Assert.assertTrue(passwordFiled.isDisplayed());
      //  Assert.assertFalse(passwordFiled.isDisplayed());
    }

}

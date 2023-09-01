package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement enterValidUserName;
    @FindBy(name = "password")
    private WebElement enterUserValidPassword;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions orangehrm-login-action\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class=\"oxd-alert-content oxd-alert-content--error\"]/p[text()=\"Invalid credentials\"]")
    private WebElement invalidCredentialsMessage;
    @FindBy(css = ".oxd-input-field-error-message")
    private WebElement errorMessageForEmptyField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void addValidUserName(){

        enterValidUserName.sendKeys("Admin");
    }
    public void addInvalidUserName(){
        enterValidUserName.sendKeys("admin1");
    }
    public void addInvalidPassword(){
        enterUserValidPassword.sendKeys("test123");
    }

    public void addValidPassword(){
        enterUserValidPassword.sendKeys("admin123");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void assertUserIsNotAllowedToLoginAccount(){
        waitForElementToBeVisible(invalidCredentialsMessage);
        Assert.assertTrue("Welcome, UserFirstName UserLastName!", invalidCredentialsMessage.getText().contains("Invalid credentials"));

    }
    public void assertRequiredUserNameField(){
        waitForElementToBeVisible(errorMessageForEmptyField);
        Assert.assertTrue("Username valid", errorMessageForEmptyField.getText().contains("Required"));
    }

}

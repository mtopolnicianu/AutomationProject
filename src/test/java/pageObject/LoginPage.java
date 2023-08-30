package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement enterValidUserName;
    @FindBy(name = "password")
    private WebElement enterUserValidPassword;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions orangehrm-login-action\"]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void addValidUserName(){

        enterValidUserName.sendKeys("Admin");
    }
    public void addValidPassword(){
        enterUserValidPassword.sendKeys("admin123");
    }
    public void clickLoginButton() {
        loginButton.click();
    }

}

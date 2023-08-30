package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOrangeHrmObject extends BasePage{
    public HomePageOrangeHrmObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
    private WebElement userNameValidation;

    public void verifyUserName() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(userNameValidation.isDisplayed());
    }
}

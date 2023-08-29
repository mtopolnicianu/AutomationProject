package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;

    @Given("Customer navigates to the website")
    public void navigateToWebsite() {
        System.setProperty("webdriver.chrome.driver","src/test/java/utils/chromedriver");
        //        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @And("Customer login to his account")
    public void customerLogin(){
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.completeLoginCredentials();
    }


}

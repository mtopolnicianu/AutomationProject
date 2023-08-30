package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.BasePage;
import pageObject.DashboardPageObject;
import pageObject.HomePageOrangeHrmObject;
import pageObject.LoginPage;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPageObject dashboardPageObject;
    private HomePageOrangeHrmObject homePageOrangeHrmObject;


    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePageOrangeHrmObject = PageFactory.initElements(driver, HomePageOrangeHrmObject.class);
        dashboardPageObject=PageFactory.initElements(driver, DashboardPageObject.class);
    }

 //  @After
//    public void after(){
//        driver.quit();
//    }

    @Given("^I access ([^\"]*) page$")
    public void accessUrl(String link){
        driver.get(link);
    }
    @And("^I enter the valid login credentials$")
    public void enterValidCredentials(){
        loginPage.addValidUserName();
        loginPage.addValidPassword();
    }
    @And("^I press the Login button to log into my account$")
    public void pressLoginButton(){
        loginPage.clickLoginButton();
    }
    @Then("^I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application$")
    public void iVerifyUserName() throws InterruptedException {
        homePageOrangeHrmObject.verifyUserName();

    }
}
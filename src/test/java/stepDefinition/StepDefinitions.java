package stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.OrangeHrmPage;

public class StepDefinitions {
    public WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private HomePage homePage;
    private OrangeHrmPage orangeHrmPage;


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/utils/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
//        String title = driver.getTitle();
//        System.out.println(title);
//        String pageSource = driver.getPageSource();
//        System.out.println(pageSource);
//        driver.navigate().to("http://google.com");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        orangeHrmPage = PageFactory.initElements(driver, OrangeHrmPage.class);
    }

//    @After
//    public void after() {
//        driver.close();
//        driver.quit();
//    }

    @Given("^I access ([^\"]*) page$")
    public void accessUrl(String link) {
        driver.get(link);
    }


    @And("^I enter the valid login credentials$")
    public void enterValidCredentials() {
        loginPage.addValidUserName();
        loginPage.addValidPassword();
    }

    @Given("^I enter the invalid login credentials$")
    public void enterMyInvalidCredentials() {
        loginPage.addInvalidUserName();
        loginPage.addValidPassword();
    }

    @Then("^I verify that an appropriate message is displayed for invalid credentials$")
    public void iVerifyRejectedStatusSelected() {
        loginPage.assertUserIsNotAllowedToLoginAccount();
    }

    @And("^I press the Login button to log into my account$")
    public void pressLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("^I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application$")
    public void iVerifyUserName() {
        homePage.verifyUserName();
    }

    @And("^I enter my email address to try the HR software for free$")
    public void searchWithYourEmailAddress() {
        orangeHrmPage.enterYourEmailAddressSearchButton();
    }

    @Given("^I enter the valid password without a username$")
    public void enterPassword() {
        loginPage.addValidPassword();
    }

    @Then("^I verify that an appropriate message is displayed required username field$")
    public void iVerifyMessageForEmptyUsernameField() {
        loginPage.assertRequiredUserNameField();
    }

    @Given("^I enter the valid username without a password$")
    public void enterUserName() {
        loginPage.addValidUserName();
    }

    @Then("^I verify that an appropriate message is displayed required password field$")
    public void iVerifyMessageForEmptyPasswordField() {
        loginPage.assertRequiredPasswordField();

    }


}
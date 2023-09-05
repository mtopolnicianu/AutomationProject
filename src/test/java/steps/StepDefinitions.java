package steps;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.*;

import java.io.IOException;

public class StepDefinitions {
    public WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private HomePage homePage;
    private OrangeHrmPage orangeHrmPage;
    private LeavePage leavePage;
    private AdminPage adminPage;


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
        leavePage = PageFactory.initElements(driver, LeavePage.class);
        adminPage = PageFactory.initElements(driver, AdminPage.class);
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
    public void enterValidCredentials() throws IOException {
        loginPage.addValidUserName();
        loginPage.addValidPassword();
    }

    @Given("^I enter the invalid login credentials$")
    public void enterMyInvalidCredentials() throws IOException {
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
    public void enterPassword() throws IOException {
        loginPage.addValidPassword();
    }

    @Then("^I verify that an appropriate message is displayed required username field$")
    public void iVerifyMessageForEmptyUsernameField() {
        loginPage.assertRequiredUserNameField();
    }

    @Given("^I enter the valid username without a password$")
    public void enterUserName() throws IOException {
        loginPage.addValidUserName();
    }

    @Then("^I verify that an appropriate message is displayed required password field$")
    public void iVerifyMessageForEmptyPasswordField() {
        loginPage.assertRequiredPasswordField();
    }

    @Then("^I check the Help button to be displayed$")
    public void iVerifyHelpButtonIsDisplayed() {
        homePage.verifyHelpButton();
    }

    @And("^I click the Leave link$")
    public void openLeavePage() {
        leavePage.clickLeaveLink();
    }

    @And("^I choose to select Add Leave Entitlement from the Entitlements section$")
    public void selectEntitlementsOption() {
        leavePage.clickEntitlementsOption();
        leavePage.selectAddEntitlementsOption();
    }

    @Then("^I can see the Individual Employee button is checked by default in the Add to section$")
    public void iVerifyIndividualEmployeeButton() {
        leavePage.verifyIndividualEmployeeButtonIsChecked();
    }

    @And("^I click the Admin link$")
    public void accessAdminLink() {
        adminPage.clickAdminLink();
    }

    @Then("^I verify that the title text is displayed correctly$")
    public void iVerifyAdminTitleTextPage() {
        adminPage.getActualTitleText();
    }

    @Then("^I check that when I clicked on the Admin link it also shows the User Management text below the Admin text$")
    public void iVerifyAdditionalTextInAdmin() {
        adminPage.iVerifyAdditionalTextForAdminPage();
    }

    @Then("^I verify that the username and password field are displayed on the login page$")
    public void iVerifyUserNameField() {
        loginPage.assertUserNameField();
        loginPage.assertPasswordField();
    }

    @Then("^I verify that the company logo is displayed on the login page$")
    public void iVerifyCompanyLogo(){
        loginPage.validateLogo();
    }

    @Given("^I enter (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password){
        loginPage.enterUsernameAndPassword(username,password);
    }

    @And("^I select the Rejected status from the 'Show Leave with Status' section$")
    public void selectLeaveWithRejectedStatus(){
        leavePage.clickShowLeaveWithStatusButton();
        leavePage.clickRejectedOption();
    }

    @Then("^I check that the Rejected status is present as a selection by using XPath locator$")
    public void iVerifyRejectedStatusToBeSelected(){
        leavePage.verifyRejectedStatusSelected();
    }
}
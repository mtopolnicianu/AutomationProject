package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;


    public BasePage(WebDriver driver) {

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofMillis(500L));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable (WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
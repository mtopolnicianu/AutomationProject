package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
      //  wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
//        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
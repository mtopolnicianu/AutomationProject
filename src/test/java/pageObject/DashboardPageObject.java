package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObject {
    public WebDriver driver;
    public DashboardPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void accessDashboardLink(){
        driver.findElement(By.id("path0")).click();

    }
}

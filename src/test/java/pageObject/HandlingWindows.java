package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(4000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        System.out.println(parentWindow);
        String childWindow =  iterator.next();
        System.out.println(childWindow);

        driver.switchTo().window(childWindow);

        Thread.sleep(2000);
        driver.findElement(By.name("EmailHomePage")).sendKeys("abd@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Form_submitForm_action_request")).click();
        driver.switchTo().window(parentWindow);

    }
}


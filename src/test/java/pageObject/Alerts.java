package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/popups.html");

        driver.findElement(By.xpath("//button[text()='Trigger Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        //for the Cancel button
        driver.switchTo().alert().dismiss();

    }
}

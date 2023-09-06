package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
    public static void main(String[]args){
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/iframes.html");

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".toggle")).click();
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector(".toggle")).click();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

    }
}

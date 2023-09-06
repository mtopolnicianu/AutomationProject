package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class BrowserTabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/browserTabs.html");
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//input[@value='Open Tab']")).click();
        }
        ArrayList<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("There are " + windowsHandles.size() + " tabs open");

        for (String item:windowsHandles){
            Thread.sleep(1500);
            driver.switchTo().window(item);

        }
        Thread.sleep(1500);
        driver.switchTo().window(windowsHandles.get(0)); //switching back to the main tab
    }
}

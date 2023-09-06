package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Popups {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/popups.html");

        driver.findElement(By.xpath("//button[text()='Trigger Pop-up']")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        while (iterator.hasNext()) {
            String child = iterator.next();

            if (!mainWindow.equalsIgnoreCase(child)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                driver.switchTo().window(child);
                driver.close();
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.switchTo().window(mainWindow);
        // driver.findElement(By.xpath("//button[text()='Trigger Pop-up']")).click();

    }
}

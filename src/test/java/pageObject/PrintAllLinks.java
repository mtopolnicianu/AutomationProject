package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintAllLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/au/form/signup/freetrial-elf-v2/");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String titleUrl = driver.getTitle();
        System.out.println(titleUrl);
        driver.manage().window().maximize();

        //List<WebElement> allTags = driver.findElements(By.tagName("a"));
        List<WebElement> allTags = driver.findElements(By.tagName("option"));
        System.out.println("Total tags are: " + allTags.size());



        for (int i = 0; i < allTags.size(); i++) {
            //System.out.println("Links on page are " + allTags.get(i).getAttribute("href"));
            //System.out.println("Links on page are " + allTags.get(i).getAttribute("value"));
            System.out.println("Links on page are " + allTags.get(i).getText());
            //System.out.println("Links on page are " + allTags.get(i).getText());
        }
    }
}

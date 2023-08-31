package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class BasicWebDriverMethods {
    public static String browser = "chrome"; //External configuration -XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(1000);
        WebElement enterUserNameBox = driver.findElement(By.cssSelector("input[name=username]")); //tag and attribute
        enterUserNameBox.sendKeys("Admin");

        //how to use className as locator
        int sliders = driver.findElements(By.className("homeslider-container")).size();
        System.out.println(sliders);

        //how to use tagName as locator
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println(links);


        Thread.sleep(1000);
        WebElement enterPasswordBox = driver.findElement(By.cssSelector("input[name=password")); //Tag and Class
        enterPasswordBox.sendKeys("admin123");

        Thread.sleep(1000);
        WebElement pressLoginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        pressLoginButton.click();

//       List<WebElement> webElements = driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']"));
//        System.out.println(webElements);

//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        String windowHandel = driver.getWindowHandle();
//        System.out.println(windowHandel);
//
//        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
//        Set<String> windowHandels = driver.getWindowHandles();
    }
}

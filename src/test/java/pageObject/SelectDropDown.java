package pageObject;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        // driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.get("https://www.automationtesting.co.uk/dropdown.html");
        driver.manage().window().maximize();


        WebElement ddown = driver.findElement(By.id("cars"));
        Select select = new Select(ddown);
        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println(firstOption.getText());

//
//        WebElement dropDown = driver.findElement(By.name("employees_c"));
//        Select select = new Select(dropDown);
//
//        select.selectByValue("level1");
//        Thread.sleep(1000);
//
//        select.selectByVisibleText("51 - 100 employees");
//        Thread.sleep(1000);
//
//        select.selectByIndex(5);
//        Thread.sleep(1000);

//        WebElement ddown = driver.findElement(By.id("cars"));
//        Select select = new Select(ddown);
//        select.selectByValue("Jeep");
//        Thread.sleep(1000);
//        select.selectByIndex(3);
//        Thread.sleep(1000);
//        List<WebElement> allItems = select.getAllSelectedOptions();
//        System.out.println(allItems.size());
//
//        select.deselectAll();
//        Thread.sleep(1000);
//        select.selectByValue("Jeep");
//        Thread.sleep(1000);
//        select.selectByIndex(3);
//        Thread.sleep(1000);

        select.deselectByIndex(3);
        Thread.sleep(1000);
        List<WebElement> allItems1 = select.getAllSelectedOptions();
        System.out.println(allItems1.size());


    }
}

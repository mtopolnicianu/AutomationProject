package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesDemo {

    @Test
    public void verifyTable() {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/");

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[contains(@id,'cust')]//th"));
        System.out.println(allHeaders.size());
        Assert.assertEquals("Column count is not same", 5, allHeaders.size());
        boolean status = false;

        for (WebElement ele : allHeaders) {
            String value = ele.getText();
            System.out.println(value);
            if (value.contains("Country")) {
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);

        System.out.println("===========================================");

        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr"));
        System.out.println("Total count of rows " + numberOfRows.size());
        Assert.assertEquals("Table row count mismatched", 7, numberOfRows.size());


        List<WebElement> allData = driver.findElements(By.xpath("//table[contains(@id,'cust')]//td"));

        boolean dataStatus = false;
        for (WebElement ele : allData) {
            String value = ele.getText();
            System.out.println(value);
            if (value.contains("Ola")) {
                dataStatus = true;
                break;
            }
        }

        List<WebElement> companyNames = driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr//td[2]"));
        boolean companyStatus = false;
        for (WebElement ele : companyNames) {
            String value = ele.getText();
            System.out.println(value);
            if (value.contains("Java")) {
                companyStatus = true;
                break;
            }
        }

        driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input")).click(); //Click on the checkbox Status for Selenium company
        driver.findElement(By.xpath("//td[text()='Ola']//following-sibling::td[3]//a")).click(); //click the link inside of Know More for Ola company

        Assert.assertTrue("Record did not find", dataStatus);
        Assert.assertTrue("Could not find the company", companyStatus);
        driver.quit();


    }
}

package pageObject;

import io.cucumber.java.ca.Cal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendars {
    @Test
    public void handleCalendars() throws Exception {
        WebDriverManager.chromedriver().driverVersion("116.0.5845.110").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        Calendar calendar = Calendar.getInstance();
        String targetDate = "30-Feb-2021";
        SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date formattedTargetDate;
        try {
            targetDateFormat.setLenient(false);
            formattedTargetDate = targetDateFormat.parse(targetDate);
            calendar.setTime(formattedTargetDate);

            int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
            int targetMonth = calendar.get(Calendar.MONTH);
            int targetYear = calendar.get(Calendar.YEAR);

            driver.findElement(By.id("second_date_picker")).click();
            String actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
            calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

            int actualMonth = calendar.get(Calendar.MONTH);
            int actualYear = calendar.get(Calendar.YEAR);

            while (targetMonth < actualMonth || targetYear < actualYear) {
                driver.findElement(By.className("ui-datepicker-prev")).click();
                actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

                actualMonth = calendar.get(Calendar.MONTH);
                actualYear = calendar.get(Calendar.YEAR);
            }

            while (targetMonth > actualMonth || targetYear > actualYear) {
                driver.findElement(By.className("ui-datepicker-prev")).click();
                actualDate = driver.findElement(By.className("ui-datepicker-title")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

                actualMonth = calendar.get(Calendar.MONTH);
                actualYear = calendar.get(Calendar.YEAR);
            }

//            driver.findElement(By.id("second_date_picker")).click();
//            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month '))]/a[text()="+targetDay+"]")).click();

        } catch (ParseException e) {
            throw new Exception("Invalid date is provided, please check input date");
        }
    }
}

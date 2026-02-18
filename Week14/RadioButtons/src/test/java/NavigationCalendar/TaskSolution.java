package NavigationCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TaskSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");
        driver.manage().window().maximize();

        selectDate(driver, By.xpath("//input[@id='from_date']"), "May", "22");
        selectDate(driver, By.xpath("//input[@id='to_date']"), "June", "22");
        driver.quit();
    }

    /**
     * @param driver         The WebDriver instance.
     * @param calendarLocator Locator for the calendar input element.
     * @param month          The month to select (e.g., "May").
     * @param date           The day to select (e.g., "22").
     */
    public static void selectDate(WebDriver driver, By calendarLocator, String month, String date) {
        driver.findElement(calendarLocator).click();

        boolean isFound = false;

        while (!isFound) {
            WebElement currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));

            if (currentMonth.getText().equals(month)) {
                List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td"));

                for (WebElement day : allDates) {
                    if (day.getText().equals(date)) {
                        day.click();
                        isFound = true;
                        break;
                    }
                }
            } else {
                driver.findElement(By.xpath("//span[text()='Next']")).click();
            }
        }
    }
}

package CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesSolution {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // Navigate to the URL
        driver.get("https://syntaxprojects.com/basic-checkbox-demo-homework.php");
        driver.manage().window().maximize();


        WebElement subscribeCheckbox = driver.findElement(By.id("newsletter"));
        if (subscribeCheckbox.isEnabled()) {
            subscribeCheckbox.click();
            System.out.println("Subscribe to Newsletter checkbox clicked.");
        } else {
            System.out.println("Subscribe to Newsletter checkbox is not enabled.");
        }

        List<WebElement> hobbiesCheckboxes = driver.findElements(By.cssSelector("#reading, #cooking"));
        for (WebElement checkbox : hobbiesCheckboxes) {
            checkbox.click();
            System.out.println("Selected hobby: " + checkbox.getAttribute("value"));
        }

        List<WebElement> interestCheckboxes = driver.findElements(By.cssSelector(".interest_section .checkbox-field"));

        if (interestCheckboxes.isEmpty() || !interestCheckboxes.get(0).isDisplayed()) {
            System.out.println("Support and Music checkboxes are not displayed by default.");
        }


        WebElement showCheckboxesButton = driver.findElement(By.id("toggleCheckboxButtons"));
        showCheckboxesButton.click();

        Thread.sleep(2000);


        WebElement musicCheckbox = driver.findElement(By.cssSelector(".interest_section .checkbox-field[value='Music']"));
        musicCheckbox.click();
        if(musicCheckbox.isEnabled()) {
            System.out.println("Music checkbox selected.");
        }
        WebElement notificationsCheckbox = driver.findElement(By.cssSelector(".checkbox-field[value='Receive-Notifications']"));

        if (!notificationsCheckbox.isEnabled()) {
            System.out.println("Receive Notifications checkbox is disabled.");
        }
// 1
        WebElement checkbox = driver.findElement(By.xpath("//input[@value='Receive-Notifications']"));

// 2
        if (!notificationsCheckbox.isSelected()) {
            notificationsCheckbox.click();
        }
 // 3
        if (notificationsCheckbox.isSelected()) {
            System.out.println("“Receive Notifications” checkbox has been successfully selected.");
        } else {
            System.out.println("Error: “Receive Notifications” checkbox was not selected.");
        }

        driver.quit();

    }
}

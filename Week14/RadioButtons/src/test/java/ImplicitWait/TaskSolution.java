package ImplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TaskSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("https://syntaxprojects.com/synchronization-waits-homework.php");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement clickMeButton = driver.findElement(By.id("show_text_synchronize_three"));
        clickMeButton.click();

        WebElement option1Checkbox = driver.findElement(By.xpath("//input[@value='Option-1']"));
        option1Checkbox.click();

        System.out.println("Option 1 checkbox selected successfully.");
    }

    }


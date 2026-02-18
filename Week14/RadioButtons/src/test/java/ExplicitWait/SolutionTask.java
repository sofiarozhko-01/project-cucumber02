package ExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SolutionTask {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("https://syntaxprojects.com/synchronization-explicit-wait-homework.php");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement changeTextButton = driver.findElement(By.id("changetext_button"));
        changeTextButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("headingtext"), "Ssyntaxtechs")
        );
        System.out.println("Text Changed to: " + driver.findElement(By.id("headingtext")).getText());

        WebElement enableButton = driver.findElement(By.id("enable_button"));
        enableButton.click();
        WebElement enabledButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button']"))
        );
        enabledButton.click();
        if(enabledButton.isEnabled()) {
            System.out.println("Button enabled and clicked.");
        }
        else{
            System.out.println("Button not enabled");
        }

        WebElement checkboxButton = driver.findElement(By.id("checkbox_button"));
        checkboxButton.click();
        wait.until(
                ExpectedConditions.elementToBeSelected(By.id("checkbox"))
        );
        WebElement checkbox =driver.findElement(By.id("checkbox"));
        if(checkbox.isSelected()){
            System.out.println("Checkbox selected status: " + checkbox.isSelected());
        }
        else{
            System.out.println("checkbox not selected");
        }
    }


    }

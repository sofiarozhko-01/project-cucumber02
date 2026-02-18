package Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HwSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php"); // Replace with the path to your HTML file or URL
        driver.manage().window().maximize();

        // 1)
        WebElement birthdayReminderButton = driver.findElement(By.xpath("//button[text()='Birthday Reminder!']"));
        birthdayReminderButton.click();

        Alert birthdayAlert = driver.switchTo().alert();
        System.out.println("Alert Text: " + birthdayAlert.getText());
        birthdayAlert.accept();
        System.out.println("Birthday Reminder alert accepted.");

        // 2)
        WebElement deleteFileButton = driver.findElement(By.xpath("//button[text()='Delete File!']"));
        deleteFileButton.click();

        // Handle confirmation alert and dismiss it
        Alert deleteAlert = driver.switchTo().alert();
        System.out.println("Alert Text: " + deleteAlert.getText());
        deleteAlert.dismiss();
        WebElement deleteConfirmation = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        if(deleteConfirmation.getText().equals("You pressed Cancel!")){
            System.out.println("Delete File alert dismissed.");}
        else {
            System.out.println("Delete File alert failed");
        }

        WebElement statusMessage = driver.findElement(By.id("confirm-demo"));
        System.out.println("Status Message: " + statusMessage.getText());

        // 3)
        WebElement enterNameButton = driver.findElement(By.xpath("//button[text()='Enter Your Name']"));
        enterNameButton.click();

        Alert nameAlert = driver.switchTo().alert();
        System.out.println("Alert Text: " + nameAlert.getText());
        nameAlert.sendKeys("John Doe"); // Replace with your desired name
        nameAlert.accept();

        WebElement nameDisplay = driver.findElement(By.id("prompt-demo"));
        String displayedName = nameDisplay.getText();
        System.out.println("Displayed Name: " + displayedName);

        if (displayedName.contains("John Doe")) {
            System.out.println("Name verification successful.");
        } else {
            System.out.println("Name verification failed.");
        }
    }

}

package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class HwSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("https://syntaxprojects.com/handle-iframe-homework.php");
        driver.manage().window().maximize();

        // switch context to nested frames; click Age checkbox
        driver.switchTo().frame("dropdownIframe");
        driver.switchTo().frame("checkboxIframe");
        WebElement ageCheckbox = driver.findElement(By.className("cb1-element"));
        ageCheckbox.click();
        if(ageCheckbox.isSelected()){
            System.out.println("Checkbox Selected Successfully");
        }else {
            System.out.println("Checkbox not Selected ");
        }

        // reset context and focus on the third iframe’s dropdown
        driver.switchTo().defaultContent();
//        enter dropdown's parent frame
        driver.switchTo().frame("dropdownIframe");
        Select cityDropdown = new Select(driver.findElement(By.id("cities")));
        cityDropdown.selectByIndex(2); // Selects the second city in the dropdown
        System.out.println("City selected from the dropdown.");

        // Back to main; set username
        driver.switchTo().defaultContent();
        driver.switchTo().frame("textfieldIframe");
        WebElement usernameField = driver.findElement(By.name("Username"));
        usernameField.sendKeys("Sophie");
        System.out.println("Username entered.");

    }
}


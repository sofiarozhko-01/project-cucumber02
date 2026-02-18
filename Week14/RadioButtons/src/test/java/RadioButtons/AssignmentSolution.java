package RadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AssignmentSolution {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://syntaxprojects.com/basic-radiobutton-demo-homework.php");
        driver.manage().window().maximize();

        WebElement juiceRadioButton = driver.findElement(By.cssSelector("input[value='Juice'][name='beverage']"));
        juiceRadioButton.click();
        if(juiceRadioButton .isSelected()){
            System.out.println("Selected Juice radio button.");
        }

        List<WebElement> workingEnvRadioButtons = driver.findElements(By.name("working_enviroment"));
        for (WebElement radioButton : workingEnvRadioButtons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase("hybrid")) {
                radioButton.click();
                System.out.println("Selected Hybrid option in Preferred Working Environment.");
                break;
            }
        }

        WebElement springRadioButton = driver.findElement(By.cssSelector("input[value='spring'][name='season']"));
        if (!springRadioButton.isEnabled()) {
            System.out.println("Spring radio button is disabled. Enabling it.");
            WebElement enableButtonsButton = driver.findElement(By.id("enabledFruitradio"));
            enableButtonsButton.click();

        }

        Thread.sleep(2000);
        if(springRadioButton.isEnabled()){
            springRadioButton.click();
            System.out.println("Selected Spring radio button.");
        }


        WebElement winterRadioButton = driver.findElement(By.cssSelector("input[value='winter'][name='season']"));
        if (!winterRadioButton.isDisplayed()) {
            System.out.println("Winter radio button is hidden. Revealing it.");
            WebElement showButtonsButton = driver.findElement(By.id("showRadioButtons"));
            showButtonsButton.click();

        }

        Thread.sleep(2000);
        if(winterRadioButton.isDisplayed()) {
            winterRadioButton.click();
            System.out.println("Selected Winter radio button.");
        }

        WebElement lunchRadioButton = driver.findElement(By.cssSelector("input[value='lunch'][name='meal']"));
        lunchRadioButton.click();
        if(lunchRadioButton.isSelected()){
            System.out.println("Selected Lunch radio button.");
        }

        driver.quit();
    }

}

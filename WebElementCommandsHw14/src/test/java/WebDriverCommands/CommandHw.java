package WebDriverCommands;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class CommandHw {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://syntaxprojects.com/selenium_commands_selector-homework.php");

        // 1 Retrieve custom attribute text
        WebElement customAttributeElement =
                driver.findElement(By.xpath("//div[contains(text(),'inspect me')]"));

        String customText = customAttributeElement.getAttribute("data-custom-attr");
        System.out.println("Custom attribute text: " + customText);

        // 2 Meal Preference

        // Musical Festival checkbox
        WebElement musicalFestival =
                driver.findElement(By.xpath("//input[@value='Musical Festival']"));

        if (musicalFestival.isEnabled()) {
            musicalFestival.click();
        }

        // Tech Talk should be disabled
        WebElement techTalk =
                driver.findElement(By.xpath("//input[@value='Tech Talk']"));

        System.out.println("Tech Talk enabled: " + techTalk.isEnabled());

        // Show more options
        WebElement showMore =
                driver.findElement(By.linkText("Show More Options"));
        showMore.click();

        // Art Exhibition checkbox
        WebElement artExhibition =
                driver.findElement(By.xpath("//input[@value='Art Exhibition']"));

        if (artExhibition.isDisplayed()) {
            artExhibition.click();
        }

        // 3 Mystery Message - retrieve title attribute
        WebElement hoverElement =
                driver.findElement(By.xpath("//div[contains(text(),'Hover me')]"));

        String titleValue = hoverElement.getAttribute("title");
        System.out.println("Title attribute value: " + titleValue);

        // 4️ Option Box

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkbox1']"));

        if (checkbox1.isEnabled()) {
            checkbox1.click();
        }

        WebElement checkbox2 =
                driver.findElement(By.xpath("//input[@id='checkbox2']"));

        System.out.println("Checkbox 2 enabled: " + checkbox2.isEnabled());

        // 5 Input Field
        // 5 Input Field
        WebElement inputBox =
                driver.findElement(By.id("inputField"));

        inputBox.click();
        Thread.sleep(1000);

// select all text
        inputBox.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(500);

// delete selected text
        inputBox.sendKeys(Keys.DELETE);
        Thread.sleep(500);

// type new text
        inputBox.sendKeys("here is the custom text entered");

// driver.quit();
    }
}


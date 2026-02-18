package WindowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HwSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");

        // Save main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Click buttons
        clickButton(driver, "Open B1 Page");
        clickButton(driver, "Open B2 Page");

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {
            driver.switchTo().window(handle);

            String currentUrl = driver.getCurrentUrl();
            String pageText = driver.findElement(By.xpath("//h2")).getText();

            if (currentUrl.contains("b1-page")) {
                verifyPage("B1", pageText);
            }

            if (currentUrl.contains("b2-page")) {
                verifyPage("B2", pageText);
            }
        }

        // Switch back to main window
        driver.switchTo().window(mainWindowHandle);

        // ❌ driver.quit();  // intentionally removed
    }

    // Method to click buttons
    private static void clickButton(WebDriver driver, String buttonText) {
        driver.findElement(By.xpath("//a[contains(text(),'" + buttonText + "')]")).click();
    }

    // Method to verify page text
    private static void verifyPage(String pageName, String actualText) {
        if (actualText.contains("Welcome to " + pageName)) {
            System.out.println("Switched to " + pageName + " and verified the text");
        } else {
            System.out.println("Text verification failed for " + pageName);
        }
    }
}
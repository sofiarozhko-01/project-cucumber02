package NoSelectTag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SolutionHw {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        // Navigate to the website
        driver.get("https://syntaxprojects.com/no-select-tag-dropdown-demo-homework.php");

        // 1. Choose Your Dream Fruit
        WebElement dreamFruitDropdown = driver.findElement(By.id("dream_fruits"));
        dreamFruitDropdown.click(); // Open the dropdown

        // Retrieve all options
        List<WebElement> dreamFruitOptions = driver.findElements(By.cssSelector(".single-dropdown-menu li a"));

        for (WebElement option : dreamFruitOptions) {
            System.out.println("Fruit option: " + option.getText());
            if (option.getText().equals("Mango")) {
                option.click();
                System.out.println("Selected Mango.");
                break;
            }
        }

        // 2. Choose Your Favorite Hobby
        WebElement favoriteHobbyDropdown = driver.findElement(By.id("favorite_hobbies"));
        favoriteHobbyDropdown.click(); // Open the dropdown

        // Retrieve all options
        List<WebElement> hobbyOptions = driver.findElements(By.cssSelector(".multi-dropdown-menu li a"));

        for (WebElement option : hobbyOptions) {
            System.out.println("Hobby option: " + option.getText());
            if (option.getText().equals("Cooking")) {
                option.click();
                System.out.println("Selected Cooking.");
                break;
            }
        }

        // driver.quit();
    }
}

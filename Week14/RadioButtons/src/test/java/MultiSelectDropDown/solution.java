package MultiSelectDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class solution {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // Navigate to the website
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");

        driver.manage().window().maximize();
        // 1. Single-Select Dropdown
        WebElement singleSelectDropdown = driver.findElement(By.id("fav_fruit_selector"));
        Select singleSelect = new Select(singleSelectDropdown);

        // Select "Pear" using selectByVisibleText
        singleSelect.selectByVisibleText("Pear");

        WebElement selectedOption = driver.findElement(By.xpath("//p[@class='selected-value']"));
        if(selectedOption.getText().contains("Pear")) {
            System.out.println("Selected option: Thursday");
        }



        // Get all options from the dropdown and print them
        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("All available options in the dropdown:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // 2. Multi-Select Dropdown
        WebElement multiSelectDropdown = driver.findElement(By.id("select_multi_hobbies"));
        Select multiSelect = new Select(multiSelectDropdown);

        // Verify if the dropdown is multi-select
        if (multiSelect.isMultiple()) {
            System.out.println("The dropdown is multi-select.");

            // Select options: Traveling, Cooking, Gardening
            multiSelect.selectByVisibleText("Traveling");
            multiSelect.selectByVisibleText("Cooking");
            multiSelect.selectByVisibleText("Gardening");
            System.out.println("Selected options: Traveling, Cooking, Gardening");

            // Click "Get All Selected" button
            WebElement getAllSelectedButton = driver.findElement(By.id("get_all"));
            getAllSelectedButton.click();
//            This is a bug as get selected does not get all teh selected values

            // Print selected options
            List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
            System.out.println("Currently selected options:");
            for (WebElement selected : selectedOptions) {
                System.out.println(selected.getText());
            }

            // Wait 5 seconds, then deselect "Traveling"
            Thread.sleep(5000);
            multiSelect.deselectByVisibleText("Traveling");
            System.out.println("Deselected option: Traveling");

            // Click "Get All Selected" button again
            getAllSelectedButton.click();
            selectedOptions = multiSelect.getAllSelectedOptions();
            System.out.println("Currently selected options after deselection:");
            for (WebElement selected : selectedOptions) {
                System.out.println(selected.getText());
            }
        }

    }
}

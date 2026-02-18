package DynamicTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;

public class HwSolution {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        boolean notFound=true;
        while (notFound) {
            int count = 0;

            List<WebElement> ids = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            for (WebElement id : ids) {

                if (id.getText().equals("24824123")) {
                    System.out.println("the row number is" + (count + 1));

                    String xpath = "//table/tbody/tr[" + (count + 1) + "]/td[1]";
                    WebElement checkBox = driver.findElement(By.xpath(xpath));
                    checkBox.click();
                    notFound=false;
                }
                count = count + 1;
            }
            if(notFound) {
                WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
                nextBtn.click();
            }
        }

    }

}

package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        addEmpOption.click();
    }

    @When("user enters employee first name and last name")
    public void user_enters_employee_first_name_and_last_name() {
        WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        firstNameloc.sendKeys("sofia");
        WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        lastNameloc.sendKeys("rozhko");

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        saveButton.click();
    }
    @Then("user is able to see employee added successfully")
    public void user_is_able_to_see_employee_added_successfully() {
        System.out.println("employee added succesfully");
    }

    @When("user enters employee {string} and {string} values")
    public void user_enters_employee_and_values(String firstname, String lastname) {
        WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        firstNameloc.sendKeys(firstname);
        WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        lastNameloc.sendKeys(lastname);
    }
}
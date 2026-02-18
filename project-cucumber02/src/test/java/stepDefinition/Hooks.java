package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(utils.ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

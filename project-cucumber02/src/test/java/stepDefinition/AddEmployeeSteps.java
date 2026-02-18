package stepDefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddEmployeeSteps {

    @Then("verify employee in database")
    public void verify_employee_in_database() throws SQLException {

        DBUtils.connect();

        ResultSet rs = DBUtils.runQuery(
                "SELECT * FROM hs_hr_employees WHERE emp_firstname='John'");

        Assert.assertTrue(rs.next());

        DBUtils.close();
    }
}
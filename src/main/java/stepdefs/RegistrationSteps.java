package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.BaseClass;
import org.junit.After;
import org.junit.Assert;

import static pages.LoginPage.*;
import static pages.RegistrationPage.register;

public class RegistrationSteps extends BaseClass {
    //Always put this on each of stepdefs to clear chromedriver every test script
    @After
    public void after() {
        driver.quit();
    }

    //Note that the step text from Feature file should exactly match the annotation text

    @Given("^User registers with (valid|invalid) data$")
    public static void stepUserRegister(String condition, DataTable regCredentials) throws Throwable {
        initializeBrowser();
        if (condition.equals("valid")) {
            register(regCredentials);
        }
    }
}

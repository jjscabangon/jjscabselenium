package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import framework.BaseClass;
import org.junit.After;
import org.junit.Assert;

import static pages.LoginPage.*;

public class LoginSteps extends BaseClass {
    //Always put this on each of stepdefs to clear chromedriver every test script
    @After
    public void after() {
        driver.quit();
    }

    //Note that the step text from Feature file should exactly match the annotation text

    @Given("^End User logs in$")
    public static void stepEndUserLogsInAs(DataTable loginCredentials) throws Throwable {
        initializeBrowser();
        login(loginCredentials);
    }

    @Then("^Post-login page is (displayed|not displayed)$")
    public static void stepPostLoginPage(String state) {
        if (state.equals("displayed")) {
            Assert.assertTrue(isPostLoginPageDisplayed());
        }
        Assert.assertTrue(isPostLoginPageNotDisplayed());
    }
}

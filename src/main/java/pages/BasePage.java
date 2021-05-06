package pages;

import framework.BaseClass;
import org.openqa.selenium.By;

public class BasePage extends BaseClass {
    //Global
        //Click Table Row
        public static By tblTable = By.cssSelector("table.ListTable");

    //Login Page
    public static By loginUsername = By.cssSelector("input#txtLoginID");
    public static By loginPassword = By.cssSelector("input#txtPassword");
    public static By btnLoginSignIn = By.cssSelector("input#cmdLogin");
}

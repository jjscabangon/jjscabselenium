package pages;

import framework.BaseClass;
import org.openqa.selenium.By;

public class BasePage extends BaseClass {
    //Global
        //Click Table Row
            public static By tblTable = By.cssSelector("table.ListTable");

    //Login Page
        public static By lnkHeaderSignIn = By.cssSelector("a.login");
        public static By txtLoginEmail = By.cssSelector("input#email");
        public static By txtLoginPassword = By.cssSelector("input#passwd");
        public static By btnLoginSignIn = By.cssSelector("button#SubmitLogin");
        public static By txtLoginError = By.cssSelector("div.alert-danger > ol > li");

    //Post-Login Identifiers
        public static By lnkHeaderAccount = By.cssSelector("a.account");
        public static By lnkHeaderSignout = By.cssSelector("a.logout");
}

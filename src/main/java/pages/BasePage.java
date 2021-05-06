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

    //Registration
        public static By txtRegEmail = By.cssSelector("input#email_create");
        public static By btnRegCreateAccount = By.cssSelector("button#SubmitCreate");
        public static By txtRegFirstName = By.cssSelector("input#customer_firstname");
        public static By txtRegLastName = By.cssSelector("input#customer_lastname");
        public static By txtRegPassword = By.cssSelector("input#passwd");
        public static By txtRegAddress= By.cssSelector("input#address1");
        public static By txtRegCity = By.cssSelector("input#city");
        public static By ddRegState = By.cssSelector("select#id_state");
        public static By txtRegZip = By.cssSelector("input#postcode");
        public static By txtRegMobilePhone = By.cssSelector("input#phone_mobile");
        public static By btnRegSubmitAccount = By.cssSelector("button#submitAccount");
}

package pages;

import cucumber.api.DataTable;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    //Execute login
    public static void login(DataTable loginCredentials) {
        System.out.println("START: login()");
        waitForPageToLoadCompletely(30);
        //Convert DataTable into Array
        List<List<String>> loginRawData = loginCredentials.raw();
        ArrayList<String> loginDataList = new ArrayList<>();
            loginDataList.add(loginRawData.get(0).get(1));
            loginDataList.add(loginRawData.get(1).get(1));
        //Input credentials and Login
        driver.findElement(loginUsername).sendKeys(loginDataList.get(0));
        driver.findElement(loginPassword).sendKeys(loginDataList.get(1));
        driver.findElement(btnLoginSignIn).click();
        System.out.println("END: login()");
    }
}

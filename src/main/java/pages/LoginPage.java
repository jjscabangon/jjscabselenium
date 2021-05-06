package pages;

import cucumber.api.DataTable;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    //Execute login
        public static void login(DataTable loginCredentials) {
            //Wait for Sign In Link
                waitForElementToBeDisplayed(lnkHeaderSignIn,30);
            //Click Sign In from Header
                clickElement(lnkHeaderSignIn);
            //Convert DataTable into Array
                List<List<String>> loginRawData = loginCredentials.raw();
                ArrayList<String> loginDataList = new ArrayList<>();
                    loginDataList.add(loginRawData.get(0).get(1)); //Email Address
                    loginDataList.add(loginRawData.get(1).get(1)); //Password
            //Input credentials and Login
                inputText(txtLoginEmail,loginDataList.get(0));
                inputText(txtLoginPassword,loginDataList.get(1));
                clickElement(btnLoginSignIn);
        }

    //Verify if Post-login Page is displayed
        public static boolean isPostLoginPageDisplayed() {
            if(isElementDisplayed(lnkHeaderAccount) && isElementDisplayed(lnkHeaderSignOut)){
                System.out.println("PASSED: isPostLoginPageDisplayed()");
                return true;
            }
            System.out.println("FAILED: isPostLoginPageDisplayed()");
            return false;
        }

    //Verify if Post-login Page is NOT displayed
        public static boolean isPostLoginPageNotDisplayed() {
                if(isElementDisplayed(txtLoginError)) {
                    try {
                        //Display the Error Message
                            System.out.println(getText(txtLoginError));
                    } catch (Exception missingErrorMessage) {
                        System.out.println("Exception: Cannot extract Error Message from " + txtLoginError);
                    }
                    System.out.println("PASSED: isPostLoginPageNotDisplayed()");
                    return true;
                }
            System.out.println("FAILED: isPostLoginPageNotDisplayed()");
            return false;
        }
}

package pages;

import cucumber.api.DataTable;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage extends BasePage {
    //Execute Registration
        public static void register(DataTable regCredentials) throws InterruptedException {
            //Wait for Sign In Link
                waitForElementToBeDisplayed(lnkHeaderSignIn,30);
            //Click Sign In from Header
                clickElement(lnkHeaderSignIn);
            //Convert DataTable into Array
                List<List<String>> regRawData = regCredentials.raw();
                ArrayList<String> regDataList = new ArrayList<>();
                    regDataList.add(regRawData.get(0).get(1)); //First Name
                    regDataList.add(regRawData.get(1).get(1)); //Last Name
                    regDataList.add(regRawData.get(2).get(1)); //Password
                    regDataList.add(regRawData.get(3).get(1)); //Address
                    regDataList.add(regRawData.get(4).get(1)); //City
                    regDataList.add(regRawData.get(5).get(1)); //Zip
                    regDataList.add(regRawData.get(6).get(1)); //Mobile Phone
            //Input Email and Continue
                String tempEmail = getDateAndTimeNoFormat() + "@tempr.email";
                inputText(txtRegEmail,tempEmail);
                clickElement(btnRegCreateAccount);
            //Wait for Registration Form
                Thread.sleep(3000);
            //Complete Registration Form and Submit
                inputText(txtRegFirstName,regDataList.get(0)); //First Name
                inputText(txtRegLastName,regDataList.get(1)); //Last Name
                inputText(txtRegPassword,regDataList.get(2)); //Password
                inputText(txtRegAddress,regDataList.get(3)); //Address
                inputText(txtRegCity,regDataList.get(4)); //City
                selectDropdownByIndex(ddRegState,2); //State
                inputText(txtRegZip,regDataList.get(5)); //Zip
                inputText(txtRegMobilePhone,regDataList.get(6)); //Mobile Phone
                clickElement(btnRegSubmitAccount);
        }
}

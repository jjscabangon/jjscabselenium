package framework;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import static pages.BasePage.*;

public class BaseClass {
    public static WebDriver driver;
    public static String winHandleParent;
    public static String url;
    public static SoftAssert softAssert;
    public static String browser;

    //Browser Initialization
        //Initialize browser
        public static void initializeBrowser() throws IOException {
            setupTestBrowser();
            url = fetchConfig("url");
            try {
                driver.get(url);
            } catch (Exception remoteTimeOut){
                System.out.println("FAILED: Cannot access the website");
            }
        }
        //Setup Browser
        public static void setupTestBrowser() throws IOException {
            browser = fetchConfig("browser");

            // Initialize browser
            if (driver != null) driver.quit();
            if ("Firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();

            // Starting softAssert Method
            softAssert= new SoftAssert();
        }

    //Fetch from config.properties
    public static String fetchConfig(String property) throws IOException {
        FileInputStream objFis = new FileInputStream("src/main/config.properties");
        Properties objProp = new Properties();
        objProp.load(objFis);
        return objProp.getProperty(property);
    }

    //Wait
        //Wait for Element to be displayed
        public static void waitForElementToBeDisplayed(By element, int retries) {
            for (int i=0; i<retries; i++) {
                try {
                    driver.findElement(element).isDisplayed();
                    i=retries+1;
                } catch (Exception elementNotFound) {
                    if (i==retries-1) {
                        System.out.println("ASSERT: Element Not Found | " + element);
                    }
                }
            }
        }
        //Wait for page to load completely
        public static void waitForPageToLoadCompletely(int seconds){
            try {
                ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<>() {
                    @NullableDecl
                    @Override
                    public Boolean apply(@NullableDecl WebDriver webDriver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
                WebDriverWait wait = new WebDriverWait(driver, seconds);
                wait.until(pageLoadCondition);
            } catch (Exception errorTimeout){
                System.out.println("ERROR: Page did not load completely after " + seconds + "seconds of wait");
            }
        }

    //Environment Variables
        //Get Date and Time with no formatting and spaces
        public static String getDateAndTimeNoFormat() {
            DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmmss");
            Date date = new Date();
            return dateFormat.format(date);
        }

    //Actions
        //Click element
        public static void clickElement(By element) {
            try {
                waitForElementToBeDisplayed(element,30);
                driver.findElement(element).click();
                waitForPageToLoadCompletely(30);
            } catch (Exception elementNotFound) {
                System.out.println("FAILED: clickElement | " + element.toString());
            }
        }
        //Input Text
        public static void inputText(By element, String text) {
            driver.findElement(element).sendKeys(text);
        }
        //Clear Text
        public static void clearText(By element) {
            driver.findElement(element).clear();
        }
        //Get Attribute
        public static String getAttribute(By element, String attributeName) {
            return driver.findElement(element).getAttribute(attributeName);
        }
        //Get Text
        public static String getText(By element) {
            return driver.findElement(element).getText();
        }
        //Select from dropdown by Text
        public static void selectDropdownByText(By dropdown, String value) {
            Select ddStatus = new Select(driver.findElement(dropdown));
            try {
                ddStatus.selectByVisibleText(value);
            } catch (org.openqa.selenium.NoSuchElementException noAvailableSelection) {
                System.out.println("ERROR: selectDropdownByIndex() | No available dropdown selection");
            }
        }
        //Select from dropdown by Index
        public static void selectDropdownByIndex(By dropdown, int index) {
            Select ddStatus = new Select(driver.findElement(dropdown));
            try {
                ddStatus.selectByIndex(index);
            } catch (org.openqa.selenium.NoSuchElementException noAvailableSelection) {
                System.out.println("ERROR: selectDropdownByIndex() | No available dropdown selection");
            }
        }
        //Switch to newly opened window
        public static void switchToNewWindow() throws InterruptedException {
            //Store the current window handle
            winHandleParent = driver.getWindowHandle();
            Thread.sleep(2000);
            switch (browser) {
                case "Firefox":
                    Set<String> allHandles = driver.getWindowHandles();
                    for(String winHandle : allHandles){
                        if(!winHandle.equals(winHandleParent)) {
                            driver.switchTo().window(winHandle);
                        }
                        driver.switchTo().window(winHandle);
                    }
                    break;
                default:
                    for(String winHandle : driver.getWindowHandles()){
                        driver.switchTo().window(winHandle);
                    }
            }
        }

    //Table
        //Click table row by Text
        public static void clickTableRowByText(String text) {
            //Click the row to edit
            WebElement table = driver.findElement(tblTable);
            WebElement row = table.findElement(By.xpath("//tr/td[contains(text(), '" + text + "')]"));
            row.click();
            waitForPageToLoadCompletely(30);
        }
        //Find element in a table
        public static void findTableElement(String tableName, String text) {
            //Find Table Element
            tblTable = By.cssSelector("table." + tableName);
            WebElement table = driver.findElement(tblTable);
            By element = By.xpath("//tr/td[contains(text(), '" + text + "')]");
            table.findElement(element);
        }

    //Assertion
        //Check if Text is present in page
        public static boolean isTextPresentInPage(String text) {
            try {
                driver.getPageSource().contains(text);
                System.out.println("PASSED: isTextPresentInPage() | " + text + " was found");
                return true;
            } catch (Exception missingText) {
                System.out.println("FAILED: isTextPresentInPage() | " + text + " was NOT found");
                return false;
            }
        }
        //Check if Element is displayed
        public static boolean isElementDisplayed(By element) {
            try {
                waitForElementToBeDisplayed(element,30);
                System.out.println("PASSED: isElementDisplayed() | " + element + " was found");
                return true;
            } catch (Exception missingElement) {
                System.out.println("FAILED: isElementDisplayed() | " + element + " was NOT found");
                return false;
            }
        }

    //iFrame
        //Input text inside iFrame
        public static void inputTextInsideIFrame(By div, String innerHTML, String text) {
            //Navigate inside the iFrame
            driver.switchTo().frame(driver.findElement(div));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("document.querySelector( '" + innerHTML + "' ).innerHTML = " + "'" + text + "'" );
            //Navigate to Parent Frame
            moveToParentFrame();
        }
        //Move to Parent iFrame
        public static void moveToParentFrame() {
            driver.switchTo().parentFrame();
        }
}

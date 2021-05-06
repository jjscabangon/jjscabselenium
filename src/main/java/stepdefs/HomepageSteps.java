package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.BaseClass;
import org.junit.After;

import static pages.HomepagePage.*;

public class HomepageSteps extends BaseClass {
    //Always put this on each of stepdefs to clear chromedriver every test script
    @After
    public void after() {
        driver.quit();
    }

    //Note that the step text from Feature file should exactly match the annotation text

    @Given("^User is in Homepage$")
    public static void stepUserIsInHomepage() throws Throwable {
        initializeBrowser();
    }

    @Then("^(Header|Top Menu|Slider Banner|Suggested Product|Category|Social Media|Footer) is displayed$")
    public static void stepComponentIsDisplayed(String homepageElement) {
        switch (homepageElement) {
            case "Header" -> isHeaderDisplayed();
            case "Top Menu" -> isTopMenuDisplayed();
            case "Slider Banner" -> isSliderBannerDisplayed();
            case "Suggested Product" -> isSuggestedProductDisplayed();
            case "Category" -> isCategoryDisplayed();
            case "Social Media" -> isSocialMediaBlockDisplayed();
            case "Footer" -> isFooterDisplayed();
            default -> System.out.println("ERROR: Homepage element undefined.");
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomepagePage extends BasePage {
    public static boolean elementNotFound = false;

    //Verify if Header is displayed
        public static boolean isHeaderDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> headerElements = new ArrayList<>();
                    headerElements.add(imgHeaderBanner);
                    headerElements.add(lblHeaderContactNumber);
                    headerElements.add(lnkHeaderContactUs);
                    headerElements.add(lnkHeaderSignIn);
                    //headerElements.add(lnkHeaderSignOut);
                    headerElements.add(imgHeaderLogo);
                    headerElements.add(txtHeaderSearch);
                    headerElements.add(lnkHeaderCart);
            //Verify each Selector
                areSelectorsDisplayed("Header", headerElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Header is displayed");
                    return true;
                }
        }

    //Verify if Top Menu is displayed
        public static boolean isTopMenuDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> topMenuElements = new ArrayList<>();
                topMenuElements.add(lnkTopMenuWomen);
                topMenuElements.add(lnkTopMenuDresses);
                topMenuElements.add(lnkTopMenuTShirts);
            //Verify each Selector
                areSelectorsDisplayed("Top Menu", topMenuElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Top Menu is displayed");
                    return true;
                }
        }

    //Verify if Banner is displayed
        public static boolean isSliderBannerDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> sliderBannerElements = new ArrayList<>();
                sliderBannerElements.add(sldSliderBannerSlider);
                sliderBannerElements.add(imgSliderBannnerTop);
                sliderBannerElements.add(imgSliderBannerBottom);
            //Verify each Selector
                areSelectorsDisplayed("Slider Banner", sliderBannerElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Slider Banner is displayed");
                    return true;
                }
        }

    //Verify if Suggested Product is displayed
        public static boolean isSuggestedProductDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> suggestedProductElements = new ArrayList<>();
                suggestedProductElements.add(lnkSuggestedProductPopular);
                suggestedProductElements.add(lnkSuggestedProductBestSeller);
                suggestedProductElements.add(imgSuggestedProductThumbnail);
            //Verify each Selector
                areSelectorsDisplayed("Suggested Product", suggestedProductElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Suggested Product is displayed");
                    return true;
                }
        }

    //Verify if Category is displayed
        public static boolean isCategoryDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> categoryElements = new ArrayList<>();
                categoryElements.add(imgCategoryTopTrends);
                categoryElements.add(imgCategoryMens);
                categoryElements.add(imgCategoryWomens);
                categoryElements.add(imgCategoryEyewear);
                categoryElements.add(imgCategoryHandbags);
            //Verify each Selector
                areSelectorsDisplayed("Category", categoryElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Category is displayed");
                    return true;
                }
        }

    //Verify if Social Media Block is displayed
        public static boolean isSocialMediaBlockDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> socialMediaElements = new ArrayList<>();
                socialMediaElements.add(txtSocialMediaFacebook);
                socialMediaElements.add(lblSocialMediaInfo);
                socialMediaElements.add(lblSocialMediaEditorial);
            //Verify each Selector
                areSelectorsDisplayed("Social Media", socialMediaElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Social Media is displayed");
                    return true;
                }
        }

    //Verify if Footer is displayed
        public static boolean isFooterDisplayed() {
            elementNotFound = false;
            //Create Selector Array
                List<By> footerElements = new ArrayList<>();
                footerElements.add(txtFooterNewsletter);
                footerElements.add(lnkFooterSocialMedia);
                footerElements.add(lnkFooterCategories);
                footerElements.add(lnkFooterInformation);
                footerElements.add(lnkFooterMyAccount);
                footerElements.add(lnkFooterStoreInformation);
                footerElements.add(lnkFooterCopyright);
            //Verify each Selector
                areSelectorsDisplayed("Footer", footerElements);
            //Return Result
                if (elementNotFound) {
                    return false;
                } else {
                    System.out.println("PASSED: Footer is displayed");
                    return true;
                }
        }

    //Verify each Selector
        public static void areSelectorsDisplayed(String label, List<By> arrayElements) {
            for (By element : arrayElements) {
                if(!isElementDisplayed(element)){
                    System.out.println("FAILED: " + label + " Element NOT found | " + element);
                    elementNotFound = true;
                }
            }
        }
}

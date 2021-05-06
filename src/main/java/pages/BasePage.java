package pages;

import framework.BaseClass;
import org.openqa.selenium.By;

public class BasePage extends BaseClass {
    /* VARIABLE NAMING PREFIXES
     * tbl = table
     * lbl = label / pure text
     * txt = text field
     * btn = button
     * cbx = checkbox
     * lnk = link
     * dd = dropdown
     * img = image
     * sld = slider
     */

    //Global
        //Click Table Row
            public static By tblTable = By.cssSelector("table.ListTable");

    //Login Page
        public static By txtLoginEmail = By.cssSelector("input#email");
        public static By txtLoginPassword = By.cssSelector("input#passwd");
        public static By btnLoginSignIn = By.cssSelector("button#SubmitLogin");
        public static By txtLoginError = By.cssSelector("div.alert-danger > ol > li");

    //Post-Login Identifiers
        public static By lnkHeaderAccount = By.cssSelector("a.account");

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

    //Homepage
        //Header
            public static By imgHeaderBanner = By.cssSelector("div.banner img.img-responsive");
            public static By lblHeaderContactNumber = By.cssSelector("span.shop-phone");
            public static By lnkHeaderContactUs = By.cssSelector("div#contact-link");
            public static By lnkHeaderSignIn = By.cssSelector("a.login");
            public static By lnkHeaderSignOut = By.cssSelector("a.logout");
            public static By imgHeaderLogo = By.cssSelector("div#header_logo");
            public static By txtHeaderSearch = By.cssSelector("form#searchbox");
            public static By lnkHeaderCart = By.cssSelector("div.shopping_cart");

        //Top Menu
            public static By lnkTopMenuWomen = By.cssSelector("div#block_top_menu a[title='Women']");
            public static By lnkTopMenuDresses = By.cssSelector("div#block_top_menu a[title='Dresses']");
            public static By lnkTopMenuTShirts = By.cssSelector("div#block_top_menu a[title='T-shirts']");
        //Slider Banner
            public static By sldSliderBannerSlider = By.cssSelector("div#homepage-slider");
            public static By imgSliderBannnerTop = By.cssSelector("div#htmlcontent_top li.htmlcontent-item-1 img.item-img");
            public static By imgSliderBannerBottom = By.cssSelector("div#htmlcontent_top li.htmlcontent-item-2 img.item-img");
        //Suggested Product
            public static By lnkSuggestedProductPopular = By.cssSelector("a.homefeatured");
            public static By lnkSuggestedProductBestSeller = By.cssSelector("a.blockbestsellers");
            public static By imgSuggestedProductThumbnail = By.cssSelector("div.product-container");
        //Category
            public static By imgCategoryTopTrends = By.cssSelector("div#htmlcontent_home li.htmlcontent-item-1");
            public static By imgCategoryMens = By.cssSelector("div#htmlcontent_home li.htmlcontent-item-2");
            public static By imgCategoryWomens = By.cssSelector("div#htmlcontent_home li.htmlcontent-item-3");
            public static By imgCategoryEyewear = By.cssSelector("div#htmlcontent_home li.htmlcontent-item-4");
            public static By imgCategoryHandbags = By.cssSelector("div#htmlcontent_home li.htmlcontent-item-5");
        //Social Media Block
            public static By txtSocialMediaFacebook = By.cssSelector("div#facebook_block");
            public static By lblSocialMediaInfo = By.cssSelector("div#cmsinfo_block");
            public static By lblSocialMediaEditorial = By.cssSelector("div#editorial_block_center");
        //Footer
            public static By txtFooterNewsletter = By.cssSelector("div#newsletter_block_left");
            public static By lnkFooterSocialMedia = By.cssSelector("section#social_block");
            public static By lnkFooterCategories = By.cssSelector("section.blockcategories_footer");
            public static By lnkFooterInformation = By.cssSelector("section#block_various_links_footer");
            public static By lnkFooterMyAccount = By.cssSelector("section.footer-block a[href*='my-account']");
            public static By lnkFooterStoreInformation = By.cssSelector("section#block_contact_infos");
            public static By lnkFooterCopyright = By.cssSelector("section.bottom-footer.col-xs-12");
}

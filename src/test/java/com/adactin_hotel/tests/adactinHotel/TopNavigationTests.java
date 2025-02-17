package com.adactin_hotel.tests.adactinHotel;

import com.adactin_hotel.config.retry.TestRetryAnalyzer;
import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TopNavigationTests extends TestBase {

    private static final Logger logger = LoggerUtils.getLogger(TopNavigationTests.class);
    private static final String WELCOME_TEXT_MESSAGE = "Welcome to Adactin Group of Hotels";

    @Test(groups = {"sanity"}, retryAnalyzer = TestRetryAnalyzer.class)
    public void verifyTopNavigationLinks() {
        try{
            // Login
            loginPage.loginToPortal(decryptCredentials().get(0), decryptCredentials().get(1));
            loginPage.verifyLoginErrorMessageNotVisible();

            // Top Navigation Links
            topNavigationPage.verifyAllNavigationsMenusAreDisplayed(WELCOME_TEXT_MESSAGE);
            logger.info("All Top Navigation Links validated successfully");
        } catch (Exception error){
            ErrorHandler.logError(error, "verifyTopNavigationLinks", "Failed to verify top navigation links");
            throw error;
        }
    }
}

package com.adactin_hotel.tests.adactinHotel;

import com.adactin_hotel.config.retry.TestRetryAnalyzer;
import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    private static final Logger logger = LoggerUtils.getLogger(LoginTests.class);
    private static final String INVALID_USERNAME = "User8958";
    private static final String INVALID_PASSWORD = "password123";

    @Test(groups = {"sanity"}, retryAnalyzer = TestRetryAnalyzer.class)
    public void loginWithValidCredentials() {
        try {
            System.out.println(decryptCredentials().get(0));
            loginPage.loginToPortal(decryptCredentials().get(0), decryptCredentials().get(1));
            loginPage.verifyLoginErrorMessageNotVisible();
            loginPage.captureScreenshot("ValidLogin");
            logger.info("Login successful");
        } catch (Exception error) {
            ErrorHandler.logError(error, "loginWithValidCredentials", "Failed to login to portal");
            throw error;
        }
    }

    @Test(groups = {"sanity"}, retryAnalyzer = TestRetryAnalyzer.class)
    public void loginWithInvalidCredentials() {
        try {
            loginPage.loginToPortal(INVALID_USERNAME, INVALID_PASSWORD);
            loginPage.isLoginErrorMessageVisible();
            loginPage.captureScreenshot("InvalidLogin");
            logger.info("Login Failed as expected");
        } catch (Exception error) {
            ErrorHandler.logError(error, "loginWithInvalidCredentials", "Failed to login to portal");
            throw error;
        }
    }
}

package com.adactin_hotel.config.retry;

import com.adactin_hotel.config.properties.PropertiesConfigManager;
import com.adactin_hotel.config.properties.PropertiesFileAlias;
import com.adactin_hotel.drivers.DriverFactory;
import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.logging.ErrorHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {

    private static final String MAX_RETRY_COUNT = "MAX_RETRY_COUNT";
    private static final int maxRetryCount = initializeMaxRetryCount();
    private int retryCount = 0;

    private static int initializeMaxRetryCount() {
        try {
            return PropertiesConfigManager
                    .getConfiguration(PropertiesFileAlias.GLOBAL.getConfigurationAlias())
                    .getProperty(MAX_RETRY_COUNT, Integer.class)
                    .orElse(2);
        } catch (Exception error) {
            ErrorHandler.logError(error, "initializeMaxRetryCount",
                    "Failed to retrieve retry count");
            throw error;
        }
    }

    @Override
    public boolean retry(ITestResult result) {
        try {
            if (retryCount < maxRetryCount) {
                retryCount++;

                // Clean up the existing driver
                DriverFactory.getInstance().quitDriver();

                // Force reinitialize test context
                Object instance = result.getInstance();
                if (instance instanceof TestBase testBase) {
                    testBase.setup(); // Call setup to reinitialize everything
                }

                return true;
            }
            return false;
        } catch (Exception error) {
            ErrorHandler.logError(error, "retry", "Failed to retry test execution");
            throw error;
        }
    }
}
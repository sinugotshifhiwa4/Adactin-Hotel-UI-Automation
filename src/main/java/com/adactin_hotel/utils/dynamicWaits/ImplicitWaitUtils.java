package com.adactin_hotel.utils.dynamicWaits;

import com.adactin_hotel.config.properties.PropertiesConfigManager;
import com.adactin_hotel.config.properties.PropertiesFileAlias;
import com.adactin_hotel.drivers.DriverFactory;
import com.adactin_hotel.utils.logging.ErrorHandler;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ImplicitWaitUtils {

    private static final String TIMEOUT_KEY = "IMPLICIT_TIMEOUT";

    private ImplicitWaitUtils() {
        throw new AssertionError("Utility class - do not instantiate");
    }

    /**
     * Retrieves implicit wait timeout from properties and applies it to WebDriver
     */
    public static void applyImplicitWait(WebDriver driver) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getTimeout()));
        } catch (Exception error) {
            ErrorHandler.logError(error, "applyImplicitWait", "Failed to apply implicit wait time");
            throw error;
        }
    }

    public static void applyImplicitWait() {
        applyImplicitWait(DriverFactory.getInstance().getDriver());
    }

    /**
     * Fetch timeout value from properties file
     * @return Optional containing the timeout value if found
     */
    private static int getTimeout() {
        try {
            return PropertiesConfigManager
                    .getConfiguration(PropertiesFileAlias.GLOBAL.getConfigurationAlias())
                    .getProperty(TIMEOUT_KEY, Integer.class)
                    .orElse(10);
        } catch (Exception error) {
            ErrorHandler.logError(error, "getTimeout", "Failed to retrieve timeout value");
            throw error;
        }
    }
}
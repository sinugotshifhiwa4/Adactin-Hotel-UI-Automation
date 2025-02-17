package com.adactin_hotel.tests.base;

import com.adactin_hotel.config.environments.EnvironmentFileAlias;
import com.adactin_hotel.config.environments.EnvironmentSecretKey;
import com.adactin_hotel.config.properties.PropertiesConfigManager;
import com.adactin_hotel.config.properties.PropertiesFileAlias;
import com.adactin_hotel.crypto.services.CryptoOperationsManager;
import com.adactin_hotel.drivers.BrowserFactory;
import com.adactin_hotel.drivers.DriverFactory;
import com.adactin_hotel.pages.adactinHotel.*;
import com.adactin_hotel.testDataStorage.TestContextIds;
import com.adactin_hotel.config.paths.TestDataFilePath;
import com.adactin_hotel.utils.jacksonUtils.JsonDataReader;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import static com.adactin_hotel.tests.base.TestConfigInitializer.cleanUpTestContexts;
import static com.adactin_hotel.tests.base.TestConfigInitializer.initializeConfigurations;
import static com.adactin_hotel.utils.TestUtils.createJsonReader;

public class TestBase extends BasePage {

    private static final Logger logger = LoggerUtils.getLogger(TestBase.class);

    // Global config parameters
    private static final String BROWSER = "CHROME_BROWSER";
    private static final String URL = "PORTAL_BASE_URL";

    // Test Data Ids
    private static final TestContextIds BOOKING_ID_ONE = TestContextIds.BOOKING_TEST_ID_ONE;

    // Get Driver Instance
    private final DriverFactory driverFactory = DriverFactory.getInstance();
    protected BrowserFactory browserFactory;

    // Json Test Data initialization variables
    protected JsonDataReader bookingDataReader;
    protected JsonDataReader paymentDataReader;

    // Pages
    protected LoginPage loginPage;
    protected TopNavigationPage topNavigationPage;
    protected SearchHotelPage searchHotelPage;
    protected SelectHotelPage selectHotelPage;
    protected BookHotelPage bookHotelPage;
    protected BookingConfirmationPage bookingConfirmationPage;

    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        try {
            initializeConfigurations();
            initializeJsonReaders();
            TestConfigInitializer.initializeTestContexts(BOOKING_ID_ONE);
            logger.info("Global setup completed successfully.");
        } catch (Exception error) {
            ErrorHandler.logError(error, "globalSetup", "Failed to initialize global setup");
            throw error;
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        try {
            // Skip browser initialization when running crypto operations
            skipBrowserInitializationIfNeeded();

            logger.info("Setup configured successfully");
        } catch (Exception error) {
            ErrorHandler.logError(error, "setup", "Failed to initialize setup");
            throw error;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            cleanUpTestContexts(BOOKING_ID_ONE);
            logger.info("Test teardown completed successfully.");
        } catch (Exception error) {
            ErrorHandler.logError(error, "tearDown", "Failed to tear down");
            throw error;
        } finally {
            driverFactory.quitDriver();
        }
    }

    private void initializeJsonReaders() {
        bookingDataReader = createJsonReader(TestDataFilePath.BOOKING_DATA);
        paymentDataReader = createJsonReader(TestDataFilePath.PERSONAL_INFO_DATA);
    }

    private void skipBrowserInitializationIfNeeded() {
        if (!Boolean.getBoolean("skipBrowserInitialization")) {
            initializeBrowserComponents();
        } else {
            logger.info("Skipping browser initialization for encryption tests.");
        }
    }

    private void initializePages(WebDriver driver) {
        loginPage = new LoginPage(driver);
        topNavigationPage = new TopNavigationPage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        selectHotelPage = new SelectHotelPage(driver);
        bookHotelPage = new BookHotelPage(driver);
        bookingConfirmationPage = new BookingConfirmationPage(driver);
    }

    private void initializeBrowserComponents() {
        try {
            browserFactory = new BrowserFactory();

            String browser = PropertiesConfigManager.getPropertyKeyFromCache(PropertiesFileAlias.GLOBAL.getConfigurationAlias(), BROWSER);

            browserFactory.initializeBrowser(browser);

            if (!driverFactory.hasDriver()) {
                String errorMessage = "WebDriver initialization failed for thread: " + Thread.currentThread().threadId();
                logger.error(errorMessage);
                throw new IllegalStateException(errorMessage);
            }

            initializePages(driverFactory.getDriver());

            String url = PropertiesConfigManager.getPropertyKeyFromCache(PropertiesFileAlias.UAT.getConfigurationAlias(), URL);

            driverFactory.navigateToUrl(url);
            validateLoginPage();
        } catch (Exception error) {
            ErrorHandler.logError(error, "initializeBrowserComponents", "Failed to initialize browser components");
            throw error;
        }
    }

    private void validateLoginPage() {
        loginPage.validateHeroImageLoadTime();
        loginPage.isCompanyLogoPresent();
    }

    public List<String> decryptCredentials() {
        try {
            return CryptoOperationsManager.decryptEnvironmentVariables(
                    EnvironmentFileAlias.UAT.getEnvironmentAlias(),
                    EnvironmentSecretKey.UAT.getKeyName(),
                    "PORTAL_USERNAME", "PORTAL_PASSWORD"
            );
        } catch (Exception error) {
            ErrorHandler.logError(error, "decryptCredentials", "Failed to decrypt credentials");
            throw error;
        }
    }
}

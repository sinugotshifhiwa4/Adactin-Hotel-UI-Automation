package com.adactin_hotel.tests.encryption;

import com.adactin_hotel.config.environments.EnvironmentFilePaths;
import com.adactin_hotel.config.environments.EnvironmentSecretKey;
import com.adactin_hotel.crypto.services.SecureKeyGenerator;
import com.adactin_hotel.crypto.services.CryptoOperationsManager;
import com.adactin_hotel.utils.Base64Utils;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import javax.crypto.SecretKey;
import java.io.IOException;

public class KeyGeneratorTest {
    private static final Logger logger = LoggerUtils.getLogger(KeyGeneratorTest.class);

    // Run test in terminal that generates and encrypt credentials: mvn clean test -Denv=crypto -DskipBrowserInitialization=true
    @Test(groups = {"encryption"}, priority = 1)
    public void generateSecretKey() throws IOException {
        try{
            // Generate a new secret key
            SecretKey generatedSecretKey = SecureKeyGenerator.generateSecretKey();

            // Save the secret key in the base environment
            CryptoOperationsManager.saveSecretKeyInBaseEnvironment(
                    EnvironmentFilePaths.BASE.getEnvironmentFileFullPath(),
                    EnvironmentSecretKey.UAT.getKeyName(),
                    Base64Utils.encodeSecretKey(generatedSecretKey)
            );
            logger.info("Secret key generated and Saved successfully");
        } catch (Exception error){
            ErrorHandler.logError(error, "generateSecretKey", "Failed to generate secret key");
            throw error;
        }
    }
}

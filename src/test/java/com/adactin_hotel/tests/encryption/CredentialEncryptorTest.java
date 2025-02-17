package com.adactin_hotel.tests.encryption;

import com.adactin_hotel.config.environments.EnvironmentFileAlias;
import com.adactin_hotel.config.environments.EnvironmentFilePaths;
import com.adactin_hotel.config.environments.EnvironmentSecretKey;
import com.adactin_hotel.crypto.services.CryptoOperationsManager;
import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.crypto.CryptoException;
import org.testng.annotations.Test;

public class CredentialEncryptorTest extends TestBase {

    private static final Logger logger = LoggerUtils.getLogger(CredentialEncryptorTest.class);
    private static final String USERNAME = "PORTAL_USERNAME";
    private static final String PASSWORD = "PORTAL_PASSWORD";

    @Test(groups = {"encryption"}, priority = 2)
    public void encryptCredentials() throws CryptoException {
        try{
            // Run Encryption
            CryptoOperationsManager.encryptEnvironmentVariables(
                    EnvironmentFilePaths.UAT.getEnvironmentFileFullPath(),
                    EnvironmentFileAlias.UAT.getEnvironmentAlias(),
                    EnvironmentSecretKey.UAT.getKeyName(),
                    USERNAME, PASSWORD
            );
            logger.info("Successfully encrypted credentials");
        } catch (Exception error){
            ErrorHandler.logError(error, "encryptCredentials", "Failed to encrypt credentials");
            throw error;
        }
    }
}

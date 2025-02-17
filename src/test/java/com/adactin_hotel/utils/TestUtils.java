package com.adactin_hotel.utils;

import com.adactin_hotel.config.paths.TestDataFilePath;
import com.adactin_hotel.testDataStorage.TestContextIds;
import com.adactin_hotel.testDataStorage.TestContextStore;
import com.adactin_hotel.utils.jacksonUtils.JsonDataReader;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;

public class TestUtils {

    private static final Logger logger = LoggerUtils.getLogger(TestUtils.class);

    public static void logAndThrow(String valueName){
        logger.error("{} Value cannot be empty", valueName);
        throw new IllegalArgumentException(valueName + " Value cannot be empty");
    }

    public static JsonDataReader createJsonReader(TestDataFilePath filePath) {
        return new JsonDataReader(filePath.getTestDataFilePath());
    }
}

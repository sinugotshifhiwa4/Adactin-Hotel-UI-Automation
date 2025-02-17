package com.adactin_hotel.config.paths;

public enum TestDataFilePath {

    BOOKING_DATA("adactinHotelBookingData.json"),
    PERSONAL_INFO_DATA("personalInformationData.json");

    private static final String TEST_DATA_ROOT_PATH = "src/test/resources/testData/";
    private final String filename;

    TestDataFilePath(String filename) {
        this.filename = filename;
    }

    public String getTestDataFilePath() {
        return TEST_DATA_ROOT_PATH + filename;
    }
}

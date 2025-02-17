package com.adactin_hotel.dataProviders;

import com.adactin_hotel.utils.jacksonUtils.JsonDataReader;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class PaymentInfoDataProviders {

    private static final Logger logger = LoggerUtils.getLogger(BookingTestDataProviders.class);

    private final JsonDataReader paymentDataReader;

    // Constructor-based dependency injection
    public PaymentInfoDataProviders(JsonDataReader reader) {
        this.paymentDataReader = reader;
    }

    @DataProvider(name = "creditCardTypes")
    public Iterator<Object[]> provideCreditCardTypes() {
        return getDataList("CreditCardType");
    }

    @DataProvider(name = "expiryMonths")
    public Iterator<Object[]> provideExpiryMonths() {
        return getDataList("ExpiryMonth");
    }

    @DataProvider(name = "expiryYears")
    public Iterator<Object[]> provideExpiryYears() {
        return getDataList("ExpiryYear");
    }

    @DataProvider(name = "cvvNumbers")
    public Iterator<Object[]> provideCvvNumbers() {
        return getDataList("CvvNumber");
    }

    private Iterator<Object[]> getDataList(String section) {
        if (paymentDataReader == null) {
            logger.error("bookingDataReader is not initialized. Ensure TestBase is properly set up.");
            throw new IllegalStateException("bookingDataReader is not initialized. Ensure TestBase is properly set up.");
        }
        List<String> dataList = paymentDataReader.getAllStrings(section);
        return dataList.stream().map(data -> new Object[]{data}).iterator();
    }
}

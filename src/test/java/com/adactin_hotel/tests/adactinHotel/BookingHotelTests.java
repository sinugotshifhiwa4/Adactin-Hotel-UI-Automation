package com.adactin_hotel.tests.adactinHotel;

import com.adactin_hotel.config.retry.TestRetryAnalyzer;
import com.adactin_hotel.testDataStorage.TestContextIds;
import com.adactin_hotel.testDataStorage.TestContextStore;
import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.DateGeneratorUtils;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class BookingHotelTests extends TestBase {

    private static final Logger logger = LoggerUtils.getLogger(BookingHotelTests.class);
    private static final String LOCATION_SECTION = "Locations";
    private static final String HOTEL_SECTION = "Hotels";
    private static final String ROOM_TYPE_SECTION = "RoomTypes";
    private static final String NUMBER_OF_ROOMS_SECTION = "NumberOfRooms";
    private static final String ADULTS_PER_ROOM_ROOM_SECTION = "AdultsPerRoom";
    private static final String CHILDREN_PER_ROOM_SECTION = "ChildrenPerRoom";

    private static final String USER_INFO_SECTION = "UserInformation";
    private static final String CREDIT_CARD_TYPE_SECTION = "CreditCardType";
    private static final String EXPIRY_MONTH_SECTION = "ExpiryMonth";
    private static final String EXPIRY_YEAR_SECTION = "ExpiryYear";
    private static final String CVV_NUMBER_SECTION = "CvvNumber";


    @Test(groups = {"sanity"}, retryAnalyzer = TestRetryAnalyzer.class)
    public void verifyUserCanBookHotelSuccessfully(){
        try{
            // Login
            loginPage.loginToPortal(decryptCredentials().get(0), decryptCredentials().get(1));
            loginPage.verifyLoginErrorMessageNotVisible();

            // Search Hotel
            searchHotelPage.searchForHotel(
                    bookingDataReader.getStringByIndex(LOCATION_SECTION, 4),
                    bookingDataReader.getStringByIndex(HOTEL_SECTION, 1),
                    bookingDataReader.getStringByIndex(ROOM_TYPE_SECTION, 2),
                    bookingDataReader.getStringByIndex(NUMBER_OF_ROOMS_SECTION, 5),
                    DateGeneratorUtils.getCurrentDate(),
                    DateGeneratorUtils.getDateAfterTenDays(),
                    bookingDataReader.getStringByIndex(ADULTS_PER_ROOM_ROOM_SECTION, 1),
                    bookingDataReader.getStringByIndex(CHILDREN_PER_ROOM_SECTION, 1)
            );
            searchHotelPage.clickSearchButton();

            // Select Hotel
            selectHotelPage.clickHotelSelectionRadioButtonZero();
            selectHotelPage.clickContinueButton();

            // Book Hotel
            bookHotelPage.verifyAllBookHotelValuesAreNotEmpty();
            bookHotelPage.fillPersonalInformation(
                    paymentDataReader.getString(USER_INFO_SECTION, "firstName"),
                    paymentDataReader.getString(USER_INFO_SECTION, "lastname"),
                    paymentDataReader.getString(USER_INFO_SECTION, "billingAddress"),
                    paymentDataReader.getString(USER_INFO_SECTION, "creditCardNumber"),
                    paymentDataReader.getStringByIndex(CREDIT_CARD_TYPE_SECTION, 2),
                    paymentDataReader.getStringByIndex(EXPIRY_MONTH_SECTION, 5),
                    paymentDataReader.getStringByIndex(EXPIRY_YEAR_SECTION, 4),
                    paymentDataReader.getStringByIndex(CVV_NUMBER_SECTION, 1)
            );
            bookHotelPage.clickBookNowButton();

            // Booking Confirmation
            bookingConfirmationPage.verifyAllBookingConformationDataAreNotEmpty();

            // Save Order Number
            String orderNumber = bookingConfirmationPage.getOrderNumber();
            TestContextStore.storeContextValue(TestContextIds.BOOKING_TEST_ID_ONE.getTestId(), "orderNumber", orderNumber);

        } catch (Exception error){
            ErrorHandler.logError(error, "verifyUserCanBookHotelSuccessfully", "Failed to book hotel successfully");
            throw error;
        }
    }
}

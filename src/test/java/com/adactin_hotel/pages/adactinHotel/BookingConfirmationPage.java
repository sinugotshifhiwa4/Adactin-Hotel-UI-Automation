package com.adactin_hotel.pages.adactinHotel;

import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.adactin_hotel.utils.TestUtils.logAndThrow;

public class BookingConfirmationPage extends TestBase {

    private final Logger logger = LoggerUtils.getLogger(BookingConfirmationPage.class);
    private final WebDriver driver;

    By bookingConfirmationHeader = By.xpath("//td[@class='login_title' and contains(.,'Booking Confirmation')]");
    By hotelName = By.cssSelector("#hotel_name");
    By location = By.cssSelector("#location");
    By roomType = By.cssSelector("#room_type");
    By arrivalDate = By.cssSelector("#arrival_date");
    By departureDate = By.cssSelector("#departure_text");
    By totalRooms = By.cssSelector("#total_rooms");
    By adultsPerRoom = By.cssSelector("#adults_room");
    By childrenPerRoom = By.cssSelector("#children_room");
    By pricePerNight = By.cssSelector("#price_night");
    By totalPrice = By.cssSelector("#total_price");
    By gst = By.cssSelector("#gst");
    By finalBilledPrice = By.cssSelector("#final_price");
    By firstName = By.cssSelector("#first_name");
    By lastName = By.cssSelector("#last_name");
    By billingAddress = By.cssSelector("#address");
    By orderNumber = By.cssSelector("#order_no");
    By searchHotelButton = By.cssSelector("#search_hotel");
    By myItineraryButton = By.cssSelector("#my_itinerary");
    By logoutButton = By.cssSelector("#logout");

    public BookingConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyBookingConfirmationHeaderIsDisplayed() {
        try {
            waitForElementToBeVisible(driver.findElement(bookingConfirmationHeader), "Booking Confirmation Header");
        } catch (Exception error){
            ErrorHandler.logError(error,"verifyBookingConfirmationHeaderIsDisplayed", "Failed to verify Booking visibility of Confirmation Header");
            throw error;
        }
    }

    public void verifyHotelNameIsNotEmpty(){
        try {
            String hotelNameText = getInputText(driver.findElement(hotelName));

            if(hotelNameText.isEmpty()){
                logAndThrow("Hotel Name");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyHotelNameIsNotEmpty", "Failed to get hotel name");
            throw error;
        }
    }

    public void verifyLocationIsNotEmpty(){
        try {
            String locationValue = getInputText(driver.findElement(location));

            if(locationValue.isEmpty()){
                logAndThrow("Location");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyLocationIsNotEmpty", "Failed to get location");
            throw error;
        }
    }

    public void verifyRoomTypeIsNotEmpty(){
        try {
            String roomTypeValue = getInputText(driver.findElement(roomType));

            if(roomTypeValue.isEmpty()){
                logAndThrow("Room Type");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyRoomTypeIsNotEmpty", "Failed to get room type");
            throw error;
        }
    }

    public void verifyArrivalDateIsNotEmpty(){
        try {
            String arrivalDateValue = getInputText(driver.findElement(arrivalDate));

            if(arrivalDateValue.isEmpty()){
                logAndThrow("Arrival Date");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyArrivalDateIsNotEmpty", "Failed to get arrival date");
            throw error;
        }
    }

    public void verifyDepartureDateIsNotEmpty(){
        try {
            String departureDateValue = getInputText(driver.findElement(departureDate));

            if(departureDateValue.isEmpty()){
                logAndThrow("Departure Date");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyArrivalDateIsNotEmpty", "Failed to get departure date");
            throw error;
        }
    }

    public void verifyTotalRoomsIsNotEmpty(){
        try {
            String totalRoomsValue = getInputText(driver.findElement(totalRooms));

            if(totalRoomsValue.isEmpty()){
                logAndThrow("Total Rooms");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyTotalRoomsIsNotEmpty", "Failed to get total rooms");
            throw error;
        }
    }

    public void verifyAdultsPerRoomIsNotEmpty(){
        try {
            String adultsPerRoomValue = getInputText(driver.findElement(adultsPerRoom));

            if(adultsPerRoomValue.isEmpty()){
                logAndThrow("Adults Per Room");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyAdultsPerRoomIsNotEmpty", "Failed to get Adults per room");
            throw error;
        }
    }

    public void verifyChildrenPerRoomIsNotEmpty(){
        try {
            String childrenPerRoomValue = getInputText(driver.findElement(childrenPerRoom));

            if(childrenPerRoomValue.isEmpty()){
                logAndThrow("Children Per Room");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyChildrenPerRoomIsNotEmpty", "Failed to get children per room");
            throw error;
        }
    }

    public void verifyPricePerNightIsNotEmpty(){
        try {
            String pricePerNightValue = getInputText(driver.findElement(pricePerNight));

            if(pricePerNightValue.isEmpty()){
                logAndThrow("Price Per Night");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyPricePerNightIsNotEmpty", "Failed to get price per night");
            throw error;
        }
    }

    public void verifyTotalPriceIsNotEmpty(){
        try {
            String totalPriceValue = getInputText(driver.findElement(totalPrice));

            if(totalPriceValue.isEmpty()){
                logAndThrow("Total Price");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyTotalPriceIsNotEmpty", "Failed to get total price");
            throw error;
        }
    }

    public void verifyGstIsNotEmpty(){
        try {
            String gstValue = getInputText(driver.findElement(gst));

            if(gstValue.isEmpty()){
                logAndThrow("GST");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyGstIsNotEmpty", "Failed to get gst value");
            throw error;
        }
    }

    public void verifyFinalBilledIsNotEmpty(){
        try {
            String finalBilledValue = getInputText(driver.findElement(finalBilledPrice));

            if(finalBilledValue.isEmpty()){
                logAndThrow("Final Billed");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyFinalBilledIsNotEmpty", "Failed to get final billed value");
            throw error;
        }
    }

    public void verifyFirstNameIsNotEmpty(){
        try {
            String firstNameValue = getInputText(driver.findElement(firstName));

            if(firstNameValue.isEmpty()){
                logAndThrow("First Name");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyFirstNameIsNotEmpty", "Failed to get first name");
            throw error;
        }
    }

    public void verifyLastNameIsNotEmpty(){
        try {
            String lastNameValue = getInputText(driver.findElement(lastName));

            if(lastNameValue.isEmpty()){
                logAndThrow("Last Name");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyLastNameIsNotEmpty", "Failed to get last name");
            throw error;
        }
    }

    public void verifyBillingAddressIsNotEmpty(){
        try {
            String billingAddressValue = getInputText(driver.findElement(billingAddress));

            if(billingAddressValue.isEmpty()){
                logAndThrow("Billing Address");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyBillingAddressIsNotEmpty", "Failed to get billing address");
            throw error;
        }
    }

    public void verifyOrderNumberIsNotEmpty(){
        try {
            String orderNumberValue = getInputText(driver.findElement(orderNumber));

            if(orderNumberValue.isEmpty()){
                logAndThrow("Order Number");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyOrderNumberIsNotEmpty", "Failed to get order number");
            throw error;
        }
    }

    public String getOrderNumber(){
        try {
            return getInputText(driver.findElement(orderNumber));
        } catch (Exception error){
            ErrorHandler.logError(error, "getOrderNumber", "Failed to get order number");
            throw error;
        }
    }

    public void clickSearchHotelButton(){
        try {
            clickElement(driver.findElement(searchHotelButton), "Search Hotel");
        } catch (Exception error) {
            ErrorHandler.logError(error, "clickSearchHotelButton", "Failed to click search hotel button");
            throw error;
        }
    }

    public void clickItineraryButton(){
        try {
            clickElement(driver.findElement(myItineraryButton), "Itinerary");
        } catch (Exception error) {
            ErrorHandler.logError(error, "clickItineraryButton", "Failed to click itinerary button");
            throw error;
        }
    }

    public void clickLogoutButton(){
        try {
            clickElement(driver.findElement(logoutButton), "Logout");
        } catch (Exception error) {
            ErrorHandler.logError(error, "clickLogoutButton", "Failed to click logout button");
            throw error;
        }
    }

    public void verifyAllBookingConformationDataAreNotEmpty(){
        try {
            verifyBookingConfirmationHeaderIsDisplayed();
            verifyHotelNameIsNotEmpty();
            verifyLocationIsNotEmpty();
            verifyRoomTypeIsNotEmpty();
            verifyArrivalDateIsNotEmpty();
            verifyDepartureDateIsNotEmpty();
            verifyTotalRoomsIsNotEmpty();
            verifyAdultsPerRoomIsNotEmpty();
            verifyChildrenPerRoomIsNotEmpty();
            verifyPricePerNightIsNotEmpty();
            verifyTotalPriceIsNotEmpty();
            verifyGstIsNotEmpty();verifyFinalBilledIsNotEmpty();
            verifyFirstNameIsNotEmpty();
            verifyLastNameIsNotEmpty();
            verifyBillingAddressIsNotEmpty();
            verifyOrderNumberIsNotEmpty();
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyAllBookingConformationDataAreNotEmpty", "Failed to verify all booking data");
            throw error;
        }
    }
}

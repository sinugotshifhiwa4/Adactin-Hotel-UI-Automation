package com.adactin_hotel.pages.adactinHotel;

import com.adactin_hotel.tests.base.TestBase;
import com.adactin_hotel.config.DropdownSelector;
import com.adactin_hotel.utils.logging.ErrorHandler;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.adactin_hotel.utils.TestUtils.logAndThrow;

public class BookHotelPage extends TestBase {

    private static final Logger logger = LoggerUtils.getLogger(BookHotelPage.class);
    private final WebDriver driver;

    By bookHotelHeader = By.xpath("//td[@class='login_title' and contains(.,'Book A Hotel ')]");
    By hotelName = By.cssSelector("#hotel_name_dis");
    By location = By.cssSelector("#location_dis");
    By roomType = By.cssSelector("#room_type_dis");
    By numberOfRooms = By.cssSelector("#room_num_dis");
    By totalDays = By.cssSelector("#total_days_dis");
    By pricePerNight = By.cssSelector("#price_night_dis");
    By totalPrice = By.cssSelector("#total_price_dis");
    By gst = By.cssSelector("#gst_dis");
    By finalBilledPrice = By.cssSelector("#final_price_dis");
    By firstNameInput = By.cssSelector("#first_name");
    By lastNameInput = By.cssSelector("#last_name");
    By billingAddressInput = By.cssSelector("#address");
    By creditCardNumberInput = By.cssSelector("#cc_num");
    By creditCardTypeDropdown = By.cssSelector("#cc_type");
    By expiryMonthDropdown = By.cssSelector("#cc_exp_month");
    By expiryYearDropdown = By.cssSelector("#cc_exp_year");
    By cvvNumberInput = By.cssSelector("#cc_cvv");
    By bookNowButton = By.cssSelector("#book_now");
    By cancelButton = By.cssSelector("#cancel");

    public BookHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyBookHotelHeaderIsDisplayed() {
        try {
            waitForElementToBeVisible(driver.findElement(bookHotelHeader), "Book Hotel Header");
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyBookHotelHeaderIsDisplayed", "Failed to verify visibility of Book Hotel Header");
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

    public void verifyNumberOfRoomsIsNotEmpty(){
        try {
            String numberOfRoomsValue = getInputText(driver.findElement(numberOfRooms));

            if(numberOfRoomsValue.isEmpty()){
               logAndThrow("Number of Rooms");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyNumberOfRoomsIsNotEmpty", "Failed to get number of rooms");
            throw error;
        }
    }

    public void verifyTotalDaysIsNotEmpty(){
        try {
            String totalDaysValue = getInputText(driver.findElement(totalDays));

            if(totalDaysValue.isEmpty()){
               logAndThrow("Total Days");
            }
        } catch (Exception error) {
            ErrorHandler.logError(error, "verifyTotalDaysIsNotEmpty", "Failed to get total days");
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

    public void verifyAllBookHotelValuesAreNotEmpty(){
        verifyBookHotelHeaderIsDisplayed();
        verifyHotelNameIsNotEmpty();
        verifyLocationIsNotEmpty();
        verifyRoomTypeIsNotEmpty();
        verifyNumberOfRoomsIsNotEmpty();
        verifyTotalDaysIsNotEmpty();
        verifyPricePerNightIsNotEmpty();
        verifyTotalPriceIsNotEmpty();
        verifyGstIsNotEmpty();
        verifyFinalBilledIsNotEmpty();
    }

    public void fillFirstName(String firstName){
        try {
            sendKeys(driver.findElement(firstNameInput), firstName,"First Name");
        } catch (Exception error){
            ErrorHandler.logError(error, "fillFirstName", "Failed to fill first name");
            throw error;
        }
    }

    public void fillLastName(String lastName){
        try {
            sendKeys(driver.findElement(lastNameInput), lastName,"Last Name");
        } catch (Exception error){
            ErrorHandler.logError(error, "fillLastName", "Failed to fill last name");
            throw error;
        }
    }

    public void fillBillingAddress(String billingAddress){
        try {
            sendKeys(driver.findElement(billingAddressInput), billingAddress,"Billing Address");
        } catch (Exception error){
            ErrorHandler.logError(error, "fillBillingAddress", "Failed to fill billing address");
            throw error;
        }
    }

    public void fillCreditCardNumber(String creditCardNumber){
        try {
            sendKeys(driver.findElement(creditCardNumberInput), creditCardNumber,"Credit Card Number");
        } catch (Exception error){
            ErrorHandler.logError(error, "fillCreditCardNumber", "Failed to fill credit card number");
            throw error;
        }
    }

    public void selectCreditCardType(String creditCardType){
        try {
            selectDropdownElement(driver.findElement(creditCardTypeDropdown), DropdownSelector.VISIBLE_TEXT.getSelector(), creditCardType, "Credit Card Type");
        } catch (Exception error){
            ErrorHandler.logError(error, "selectCreditCardType", "Failed to select credit card type");
            throw error;
        }
    }

    public void selectExpiryMonth(String expiryMonth){
        try {
            selectDropdownElement(driver.findElement(expiryMonthDropdown), DropdownSelector.VISIBLE_TEXT.getSelector(), expiryMonth, "Expiry Month");
        } catch (Exception error){
            ErrorHandler.logError(error, "selectExpiryMonth", "Failed to select expiry month");
            throw error;
        }
    }

    public void selectExpiryYear(String expiryYear){
        try {
            selectDropdownElement(driver.findElement(expiryYearDropdown), DropdownSelector.VISIBLE_TEXT.getSelector(), expiryYear, "Expiry Year");
        } catch (Exception error){
            ErrorHandler.logError(error, "selectExpiryYear", "Failed to select expiry year");
            throw error;
        }
    }

    public void fillCvvNumber(String cvvNumber){
        try {
            sendKeys(driver.findElement(cvvNumberInput), cvvNumber,"CVV Number");
        } catch (Exception error){
            ErrorHandler.logError(error, "fillCvvNumber", "Failed to fill cvv number");
            throw error;
        }
    }

    public void clickBookNowButton(){
        try {
            clickElement(driver.findElement(bookNowButton), "Book Now");
        } catch (Exception error){
            ErrorHandler.logError(error, "clickBookNowButton", "Failed to click book now");
            throw error;
        }
    }

    public void clickCancelButton(){
        try {
            clickElement(driver.findElement(cancelButton), "Cancel");
        } catch (Exception error){
            ErrorHandler.logError(error, "clickCancelButton", "Failed to click cancel");
            throw error;
        }
    }

    public void fillPersonalInformation(
            String firstName,
            String lastName,
            String billingAddress,
            String creditCardNumber,
            String creditCardType,
            String expiryMonth,
            String expiryYear,
            String cvvNumber
    ){
        try {
            fillFirstName(firstName);
            fillLastName(lastName);
            fillBillingAddress(billingAddress);
            fillCreditCardNumber(creditCardNumber);
            selectCreditCardType(creditCardType);
            selectExpiryMonth(expiryMonth);
            selectExpiryYear(expiryYear);
            fillCvvNumber(cvvNumber);
        } catch (Exception error){
            ErrorHandler.logError(error, "fillPersonalInformation", "Failed to fill personal information");
            throw error;
        }
    }
}

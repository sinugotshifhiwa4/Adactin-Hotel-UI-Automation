package com.adactin_hotel.dataProviders;

import com.adactin_hotel.utils.jacksonUtils.JsonDataReader;
import com.adactin_hotel.utils.logging.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingTestDataProviders {

    private static final Logger logger = LoggerUtils.getLogger(BookingTestDataProviders.class);
    private final JsonDataReader bookingDataReader;

    // Constructor-based dependency injection
    public BookingTestDataProviders(JsonDataReader reader) {
        this.bookingDataReader = reader;
    }

    @DataProvider(name = "locations")
    public Iterator<Object[]> provideHotelLocations() {
        return getDataList("Locations");
    }

    @DataProvider(name = "hotels")
    public Iterator<Object[]> provideHotels() {
        return getDataList("Hotels");
    }

    @DataProvider(name = "roomTypes")
    public Iterator<Object[]> provideRoomTypes() {
        return getDataList("RoomTypes");
    }

    @DataProvider(name = "numberOfRooms")
    public Iterator<Object[]> provideNumberOfRooms() {
        return getDataList("NumberOfRooms");
    }

    @DataProvider(name = "adultsPerRoom")
    public Iterator<Object[]> provideAdultsPerRoom() {
        return getDataList("AdultsPerRoom");
    }

    @DataProvider(name = "childrenPerRoom")
    public Iterator<Object[]> provideChildrenPerRoom() {
        return getDataList("ChildrenPerRoom");
    }

    private Iterator<Object[]> getDataList(String section) {
        if (bookingDataReader == null) {
            logger.error("bookingDataReader is not initialized. Ensure TestBase is properly set up.");
            throw new IllegalStateException("bookingDataReader is not initialized. Ensure TestBase is properly set up.");
        }
        List<String> dataList = bookingDataReader.getAllStrings(section);
        return dataList.stream().map(data -> new Object[]{data}).iterator();
    }
}

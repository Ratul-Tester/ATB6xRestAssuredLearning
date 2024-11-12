package com.thetestingaccademy.gson.deserialization;

import com.google.gson.Gson;
import com.thetestingaccademy.gson.serialization.Booking;

import com.thetestingaccademy.gson.serialization.BookingDates;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab292 {

    @Test
    public void deserializationPojo(){

        String payload = "{\n" +
                "    \"firstname\" : \"Jasmin\",\n" +
                "    \"lastname\" : \"Shaw\",\n" +
                "    \"totalprice\" : 143,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        Gson gson = new Gson();
        Booking booking = gson.fromJson(payload, Booking.class);
        BookingDates bookingdates = gson.fromJson(payload, BookingDates.class);
        System.out.println(booking.toString());
        System.out.println(booking.getBookingdates());
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
        System.out.println(booking.getBookingdates().getCheckin());
        System.out.println(booking.getBookingdates().getCheckout());

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(booking.getFirstname(), "Jasmi", "Not Matching");
        sa.assertEquals(booking.getLastname(), "Shaw", "Not Matching");
        Assert.assertEquals(booking.getTotalprice(),143,"Not Matching");
        sa.assertAll();

    }
}

package com.thetestingaccademy.serializ;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class Lab299 {
    @Test
    public void deserializ(){

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
        Booking booking = gson.fromJson(payload,Booking.class);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
        System.out.println(booking.getTotalprice());
        System.out.println(booking.getDepositpaid());
        System.out.println(booking.getBookingdates().getCheckin());
        System.out.println(booking.getBookingdates().getCheckout());
        System.out.println(booking.getAdditionalneeds());
    }
}

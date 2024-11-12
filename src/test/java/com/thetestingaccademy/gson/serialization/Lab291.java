package com.thetestingaccademy.gson.serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab291 {

    @Test
    public void serializationPojo(){

        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Bala");
        booking.setLastname("pele");
        booking.setTotalprice(786);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2021-01-01");
        bookingdates.setCheckout("2025-01-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Khamba Allu");

        System.out.println(booking);

        Gson gson = new Gson();
        String JsonPayload = gson.toJson(booking);
        System.out.println(JsonPayload);

        String payload = JsonPayload;

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        response = rs.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.log().all().statusCode(200);


    }
}

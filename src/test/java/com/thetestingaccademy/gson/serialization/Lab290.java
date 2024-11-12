package com.thetestingaccademy.gson.serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab290 {

    @Test
    public void createBookingPostMethod(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Sunoyoni");
        booking.setLastname("Nandy");
        booking.setTotalprice(24);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2020-01-01");
        bookingdates.setCheckout("2020-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Dinner");
        System.out.println(booking.toString());

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(booking);
        rs.log().all();

        response = rs.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.log().all().statusCode(200);



    }
}

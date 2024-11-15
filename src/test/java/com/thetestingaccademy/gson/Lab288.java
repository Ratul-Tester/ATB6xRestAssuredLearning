package com.thetestingaccademy.gson;

import com.thetestingaccademy.gson.serialization.Bookingg;
import com.thetestingaccademy.gson.serialization.BookingDatess;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class Lab288 {

    public void bookingPostMethod(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        Bookingg booking = new Bookingg();
        booking.setFirstname("Bala");
        booking.setLastname("Pela");
        booking.setTotalprice(401);
        booking.setDepositpaid(true);

        BookingDatess bookingdates = new BookingDatess();
        bookingdates.setCheckin("2021-01-01");
        bookingdates.setCheckout("2021-01-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(booking);

        response = rs.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.statusCode(200);
    }
}

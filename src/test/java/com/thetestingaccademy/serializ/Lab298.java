package com.thetestingaccademy.serializ;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab298 {

    @Test
    public void seria(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Ratul");
        booking.setLastname("Nandy");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-10");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");


        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(booking);
        rs.log().all();

        r = rs.when().post();
        String respString = r.asString();
        System.out.println(respString);

        vr = r.then();
        vr.log().all().statusCode(200);

    }

}

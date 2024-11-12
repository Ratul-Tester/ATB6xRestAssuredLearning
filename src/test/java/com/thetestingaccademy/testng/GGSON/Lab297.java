package com.thetestingaccademy.testng.GGSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab297 {

    @Test
    public void finalTest(){

        String Base_Url="https://restful-booker.herokuapp.com";
        String Base_Path="/booking";

        Booking booking = new Booking();
        booking.setFirstname("Ramesh");
        booking.setLastname("Rao");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-30");

        booking.setBookingdates(bookingdates);

        booking.setAdditionalneeds("Breakfast");

        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.log().all().body(booking);

        r = rs.when().post();
        String responseString = r.asString();
        System.out.println(responseString);

        vr = r.then().log().all();
        vr.statusCode(200);

    }
}

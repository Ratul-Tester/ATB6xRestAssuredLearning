package com.thetestingaccademy.gson.serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class Lab289 {


    public void postBooking(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath= "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Ramesh");
        booking.setLastname("Rao");
        booking.setTotalprice(123);
        booking.setDepositpaid(false);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        RequestSpecification requestSpecification = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        requestSpecification.baseUri(BaseUrl);
        requestSpecification.basePath(BasePath);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking);
        requestSpecification.log().all();

        response = requestSpecification.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(200);
    }
}

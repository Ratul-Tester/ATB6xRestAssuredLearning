package com.thetestingaccademy.serializ;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab300 {

    @Test
    public void serPost(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Ramesh");
        booking.setLastname("Rao");
        booking.setTotalprice(12);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-02-01");
        bookingdates.setCheckout("2018-04-03");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Bala");

        Gson gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        System.out.println(jsonPayload);



        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(jsonPayload);

        r = rs.when().post();

        vr = r.then();
        vr.log().all().statusCode(200);



    }
}

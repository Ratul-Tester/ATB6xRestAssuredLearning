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

        Bookingg booking = new Bookingg();
        booking.setFirstname("Ramesh");
        booking.setLastname("Rao");
        booking.setTotalprice(123);
        booking.setDepositpaid(false);

        BookingDatess bookingdates = new BookingDatess();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking.toString());


        /*Booking booking1 = new Booking();
        booking1.setFirstname("Ram");
        booking1.setLastname("Rao");
        booking1.setTotalprice(143);
        booking1.setDepositpaid(true);

        BookingDates bookingdates1 = new BookingDates();
        bookingdates1.setCheckin("2019-01-01");
        bookingdates1.setCheckout("2019-02-02");

        booking1.setBookingdates(bookingdates1);
        booking1.setAdditionalneeds("Dinner");

        System.out.println(booking1.toString());*/

//        ArrayList payload = new ArrayList();
//        payload.add(booking);
//        payload.add(booking1);
//        System.out.println(payload);

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

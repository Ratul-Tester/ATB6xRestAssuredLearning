package com.thetestingaccademy.serializ;

import com.google.gson.Gson;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab301 {

    @Test
    public void seraGson() throws JsonProcessingException {

        Booking booking = new Booking();
        booking.setFirstname("Raty");
        booking.setLastname("Rao");
        booking.setTotalprice(23);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-10");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Golgapa");

        Gson gson = new Gson();
        String seriGsonToJson = gson.toJson(booking);
        System.out.println(seriGsonToJson);

        ObjectMapper objectMapper = new ObjectMapper();
        String seriGsonToJsonn = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(seriGsonToJsonn);

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(seriGsonToJson);

        r = rs.when().post();

        vr = r.then();
        vr.log().all().statusCode(200);

    }
}

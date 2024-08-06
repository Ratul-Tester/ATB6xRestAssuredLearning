package com.thetestingaccademy.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab271deleteBooking {
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
    String token = "423eb52e68e715f";
    String bookingid = "1895";

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Test
    public void deleteBookingDELETERequestNonBDDStyle(){
        String basePathForDeleteBooking = BASE_PATH+"/"+bookingid;
        rs.baseUri(BASE_URL);
        rs.basePath(basePathForDeleteBooking);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        response = rs.when().delete();

        vr = response.then();
        vr.statusCode(201);

    }
}

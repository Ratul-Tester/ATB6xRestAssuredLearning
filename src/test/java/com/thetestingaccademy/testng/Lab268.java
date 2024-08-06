package com.thetestingaccademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab268 {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String basePathForBooking = "/booking";
    String basePathForAuth = "/Auth";
    String basePathForPing = "/Ping";
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Test(priority = 1)
    public void createTokenPOSTnonBDDStyle(){
        String Auth_Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        rs.baseUri(Base_Url);
        rs.basePath(basePathForAuth);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(Auth_Payload);

        response = rs.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }

    @Test(priority = 2)
    public void fetchBookingGETnonBDDStyle(){
        rs.baseUri(Base_Url);
        rs.basePath(basePathForBooking);

        response = rs.when().get();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

    @Test(priority = 3)
    public void createBookingPOSTnonBDDStyle(){
        String Create_Payload = "{\n" +
                "    \"firstname\" : \"Jasmin\",\n" +
                "    \"lastname\" : \"Shaw\",\n" +
                "    \"totalprice\" : 143,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        rs.baseUri(Base_Url);
        rs.basePath(basePathForBooking);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(Create_Payload);

        response = rs.when().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(200);
    }

    @Test(priority = 4)
    public void fetchHealthGETnonBDDStyle(){
        rs.baseUri(Base_Url);
        rs.basePath(basePathForPing);

        response = rs.when().get();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(201);

    }
}

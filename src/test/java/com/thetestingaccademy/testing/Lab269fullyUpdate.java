package com.thetestingaccademy.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab269fullyUpdate {

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
    String token = "a6e891b1dbd803a";
    String bookingid = "3938";

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Test
    public void fullyUpdatePUTRequestNonBDDStyle(){
        String Updated_BASE_PATH = BASE_PATH+"/"+bookingid;
        String Pay_Load = "{\n" +
                "    \"firstname\" : \"Rambaba\",\n" +
                "    \"lastname\" : \"Rao\",\n" +
                "    \"totalprice\" : 110,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Fooding\"\n" +
                "}";

        rs.baseUri(BASE_URL);
        rs.basePath(Updated_BASE_PATH);
        rs.contentType(ContentType.JSON);
        rs.body(Pay_Load);
        rs.cookie("token",token);
        rs.log().all();

        response = rs.log().all().when().put();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.log().all().statusCode(200);
        vr.body("firstname", Matchers.equalTo("Rambaba"));

    }
}

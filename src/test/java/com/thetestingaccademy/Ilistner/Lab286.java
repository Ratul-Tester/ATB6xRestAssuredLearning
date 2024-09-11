package com.thetestingaccademy.Ilistner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class Lab286 {

    @Test
    public void testDemo285(){
        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String payload = "{\n" +
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

        RequestSpecification requestSpecification = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        requestSpecification.baseUri(Base_Url);
        requestSpecification.basePath(Base_Path);
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(200);
    }
}

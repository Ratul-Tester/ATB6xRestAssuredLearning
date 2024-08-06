package com.thetestingaccademy.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270partialUpdate {
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_Path = "/booking";
    String token = "4153cb76e395893";
    String bookingid = "4813";

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Test
    public void partiallyUpdatePATCHRequestNonBDDStyle(){
        String Partial_Update_BasePath = BASE_Path+"/"+bookingid;
        String Partial_Update_Payload = "{\n" +
                "    \"firstname\" : \"Ratul\",\n" +
                "    \"lastname\" : \"Nandy\"\n" +
                "}";
        rs.baseUri(BASE_URL);
        rs.basePath(Partial_Update_BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(Partial_Update_Payload);
        rs.cookie("token",token);

        response = rs.when().patch();

        vr = response.then();
        vr.statusCode(200);
    }
}

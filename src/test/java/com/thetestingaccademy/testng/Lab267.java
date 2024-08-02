package com.thetestingaccademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab267 {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Auth_Path = "/Auth";

    @Test
    public void postCreateTokenBDDStyle(){

        String Auth_Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given().baseUri(Base_Url).basePath(Base_Auth_Path)
                .contentType(ContentType.JSON).log().all()
                .body(Auth_Payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }

    @Test
    public void getBookingIdsBDDStyle(){

        RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_Path).log().all()
                .when().log().all().get()
                .then().statusCode(200);
    }

    @Test
    public void postCreateBookingBDDStyle(){

        String Payload = "{\n" +
                "    \"firstname\" : \"Jasmin\",\n" +
                "    \"lastname\" : \"Roy\",\n" +
                "    \"totalprice\" : 143,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_Path).contentType(ContentType.JSON).log().all()
                .body(Payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }


}

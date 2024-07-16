package com.thetestingaccademy.testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab262 {

    @Test
    public void getRequest() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().get()
                .then().statusCode(200);

    }

    @Test
    public void getRequestPing() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);

    }
}

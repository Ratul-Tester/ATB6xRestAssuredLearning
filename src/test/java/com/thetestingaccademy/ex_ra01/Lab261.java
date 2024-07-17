package com.thetestingaccademy.ex_ra01;

import io.restassured.RestAssured;

public class Lab261 {
    public static void main(String[] args) {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().get()
                .then().statusCode(200);
    }
}

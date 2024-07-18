package com.thetestingaccademy.ex_ra01;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Lab260 {
    @Description("Checking for ping module")
    @Test
    public void pingModule()
        /*public static void main(String[] args) */ {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
}

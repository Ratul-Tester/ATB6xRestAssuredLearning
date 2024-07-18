package com.thetestingaccademy.ex_ra01;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;



public class Lab261 {
    @Description("Checking for booking module")
    @Test
    public void bookingModule()
    /*public static void main(String[] args) */{
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().get()
                .then().statusCode(200);
    }
}

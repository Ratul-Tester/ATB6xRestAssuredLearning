package com.thetestingaccademy.ex_ra01;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab294 {

    @Test
    public void jsonString(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        Map<String,Object> JsonData = new LinkedHashMap<>();
        Map<String,Object> BookingDates = new LinkedHashMap<>();
        BookingDates.put("checkin","2018-01-01");
        BookingDates.put("checkout","2018-01-02");

        Faker faker = new Faker();

        JsonData.put("firstname",faker.name().firstName());
        JsonData.put("lastname",faker.name().lastName());
        JsonData.put("totalprice",faker.random().nextInt(1000));
        JsonData.put("depositpaid",faker.random().nextBoolean());
        JsonData.put("bookingdates",BookingDates);
        JsonData.put("additionalneeds","Breakfast");

        System.out.println(JsonData);

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(JsonData);

        r = rs.when().log().all().post();
        String responseString = r.asString();
        System.out.println(responseString);

        vr = r.then();
        vr.log().all().statusCode(200);

    }
}

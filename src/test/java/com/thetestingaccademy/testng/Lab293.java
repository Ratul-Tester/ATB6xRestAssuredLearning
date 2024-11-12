package com.thetestingaccademy.testng;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab293 {

    @Test
    public void jsonString(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        String BasePath = "/booking";

        Map<String,Object> fakerJSONData = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();

        Map<String,Object> bookingDatesData = new LinkedHashMap<>();
        bookingDatesData.put("checkin","2018-01-01");
        bookingDatesData.put("checkout","2018-01-05");

        fakerJSONData.put("firstname",firstname);
        fakerJSONData.put("lastname",lastname);
        fakerJSONData.put("totalprice",faker.random().nextInt(1000));
        fakerJSONData.put("depositpaid",faker.random().nextBoolean());
        fakerJSONData.put("bookingdates",bookingDatesData);
        fakerJSONData.put("additionalneeds","Breakfast");

        String fakerJSONDat = fakerJSONData.toString();

        System.out.println(fakerJSONDat);

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        rs.baseUri(BaseUrl);
        rs.basePath(BasePath);
        rs.contentType(ContentType.JSON);
        rs.body(fakerJSONData);

        System.out.println(fakerJSONData);

        Response response1 = rs.when().log().all().post();
        String responseString = response1.asString();
        System.out.println(responseString);

        ValidatableResponse validatableResponse1 = response1.then();
        validatableResponse1.log().all();
        validatableResponse1.statusCode(200);

    }
}

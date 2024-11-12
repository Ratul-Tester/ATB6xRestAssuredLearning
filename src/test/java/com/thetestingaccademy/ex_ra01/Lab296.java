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

public class Lab296 {

    @Test
    public void jSToString(){

        String Url = "https://restful-booker.herokuapp.com";
        String path = "/booking";

        Map<String,Object> jsonToStri = new LinkedHashMap<>();
        Map<String,Object> BookingDates = new LinkedHashMap<>();
        BookingDates.put("checkin","2018-01-02");
        BookingDates.put("checkout","2018-01-30");

        Faker f = new Faker();
        jsonToStri.put("firstname",f.name().firstName());
        jsonToStri.put("lastname",f.name().lastName());
        jsonToStri.put("totalprice",f.random().nextInt(1000));
        jsonToStri.put("depositpaid",f.random().nextBoolean());
        jsonToStri.put("bookingdates",BookingDates);
        jsonToStri.put("additionalneeds","Breakfast");

        System.out.println(jsonToStri);

        RequestSpecification rs = RestAssured.given();
        Response r;
        ValidatableResponse vr;

        rs.baseUri(Url);
        rs.basePath(path);
        rs.contentType(ContentType.JSON);
        rs.log().all().body(jsonToStri);

        r = rs.when().post();
        String responseString = r.asString();
        System.out.println(responseString);

        vr = r.then().log().all();
        vr.statusCode(200);

    }
}

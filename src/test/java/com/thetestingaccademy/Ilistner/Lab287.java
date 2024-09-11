package com.thetestingaccademy.Ilistner;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


public class Lab287 {

    @Test
    public void demoTest(){

        Map <String,Object> jsonBodyUsingMap;
        jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        int totalprice = faker.random().nextInt(1000);
        boolean depositpaid = faker.random().nextBoolean();
        Date checkin = faker.date().birthday();
        Date checkout = faker.date().birthday();

        jsonBodyUsingMap.put("firstname", firstname);
        jsonBodyUsingMap.put("lastname", lastname);
        jsonBodyUsingMap.put("totalprice", totalprice);
        //jsonBodyUsingMap.put("totalprice",faker.random().nextInt(1000));
        //jsonBodyUsingMap.put("depositpaid",faker.random().nextBoolean());

        /*Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkout","2018-01-01");
        bookingDatesMap.put("checkout","2018-01-05");*/

        //jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");


        System.out.println(jsonBodyUsingMap);

        RequestSpecification r = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String Create_Payload = "{\n" +
                "    \"firstname\" : \""+firstname+"\",\n" +
                "    \"lastname\" : \""+lastname+"\",\n" +
                "    \"totalprice\" : \""+totalprice+"\" ,\n" +
                "    \"depositpaid\" : \""+depositpaid+"\",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \""+checkout+"\",\n" +
                "        \"checkout\" : \""+checkin+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        r.baseUri(Base_Url);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(Create_Payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(200);



    }
}

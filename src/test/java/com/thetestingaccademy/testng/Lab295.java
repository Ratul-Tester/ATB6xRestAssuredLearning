package com.thetestingaccademy.testng;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab295 {

    @Test
    public void stringJson(){

        Faker faker = new Faker();

        Map<String,Object> BookingDates = new LinkedHashMap<>();
        BookingDates.put("checkin","2018-01-01");
        BookingDates.put("checkout","2018-01-01");

        Map<String,Object> JsonToString = new LinkedHashMap<>();

        JsonToString.put("firstname",faker.name().firstName());
        JsonToString.put("lastname",faker.name().lastName());
        JsonToString.put("totalprice",faker.random().nextInt(1000));
        JsonToString.put("depositpaid",faker.random().nextBoolean());
        JsonToString.put("bookingdates",BookingDates);
        JsonToString.put("additionalneeds","Breakfast");

        System.out.println(JsonToString.toString());

    }
}

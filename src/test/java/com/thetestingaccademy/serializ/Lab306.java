package com.thetestingaccademy.serializ;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab306 {
    @Test
    public void jsonSchemaValidation(){

        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/3")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema6.json")));

    }
}

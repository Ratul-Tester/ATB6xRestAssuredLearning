package com.thetestingaccademy.testng;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab263 {
    @Description("TC 1")
    @Test
    public void setRequest1() {
        System.out.println("TC1");
    }

    @Description("TC 2")
    @Test
    public void setRequest2() {
        System.out.println("TC2");
    }

    @Description("TC 3")
    @Test
    public void setRequest3() {
        System.out.println("TC3");
    }
}

package com.thetestingaccademy.testng;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class L265 {

    @Description("TC# Soft Assert Example")
    @Test
    public void softAssert(){
        // Assertion ---> Comparing
        // for example
        // Expected Status Code 200 = Actual Status Code 200
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(200,201,"Not Equal");
        sa.assertEquals(200,200,"Not Equal");
        sa.assertEquals("Ratul","ratul","Not Equal");
        System.out.println("End of the Statement");
        sa.assertAll();


//        Assert.assertEquals(201,201,"No Match");
//        Assert.assertEquals("Ratul","ratul","No Match");
//        Assert.assertEquals(200,200,"No Match");
//        Assert.assertEquals(401,400,"No Match");
//        System.out.println("End of the Statement");

    }
}

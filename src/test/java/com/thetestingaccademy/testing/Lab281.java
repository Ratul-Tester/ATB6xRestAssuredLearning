package com.thetestingaccademy.testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab281 {


    @DataProvider
    public static Object[][] parameters() {
        return new Object[][]{
                new Object[]{"admin","admin"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"}
        };

    }

    @Test(dataProvider = "parameters")
    public void testParameters(String username, String password){
        System.out.println("The username is "+username+" and the password is "+password);
    }
}

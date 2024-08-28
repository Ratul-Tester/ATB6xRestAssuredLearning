package com.thetestingaccademy.ex_ra01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab279 {

    @DataProvider
    public Object[][] invokeData() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password123"}
        };
    }

    @Test(dataProvider = "invokeData")
    public void testAuthToken(String username, String password) {
        System.out.println("The username is :" + username + " and password is :" + password);

    }
}

package com.thetestingaccademy.ex_ra01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab280 {

    @DataProvider
    public Object[][] Credentials() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password123"}
        };
    }

    @Test(dataProvider = "Credentials")
    public void testDemoCredentials(String username, String password) {
        System.out.println("The username is " + username + " and password is" + password);
    }
}

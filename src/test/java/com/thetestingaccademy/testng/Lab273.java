package com.thetestingaccademy.testng;

import org.testng.annotations.Test;

public class Lab273 {

    @Test
    public void bgetToken(){
        System.out.println("Token is generated");
    }

    @Test
    public void cgetBookingId(){
        System.out.println("Booking ID is created");
    }

    @Test(dependsOnMethods = {"bgetToken", "cgetBookingId"})
    public void aputMethod(){
        System.out.println("Modified and done");
    }
}

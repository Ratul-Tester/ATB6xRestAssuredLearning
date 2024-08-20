package com.thetestingaccademy.testng;

import org.testng.annotations.Test;

public class Lab274 {

    @Test(groups = {"init"}, priority = 1)
    public  void getToken(){
        System.out.println("Token is generated");
    }

    @Test(groups = {"init"}, priority = 2)
    public  void getBookingID(){
        System.out.println("Booking ID is created");
    }

    @Test(dependsOnGroups = "init")
    public  void fullUpdate(){
        System.out.println("Fully Updated");
    }
}

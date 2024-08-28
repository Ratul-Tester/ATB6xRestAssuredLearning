package com.thetestingaccademy.Ilistner;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class Lab284 {

    @Test(groups = "Test")
    public void test1(){
        System.out.println("Test 1");
        Assert.assertTrue(true);
    }

    @Test(groups = "Test")
    public void test2(){
        System.out.println("Test 2");
        Assert.assertTrue(true);
    }

    @AfterSuite
    //(dependsOnGroups = "Test")
    public void sendEmail(){
        System.out.println("Sending Email");
        Assert.assertFalse(false);
    }
}

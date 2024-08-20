package com.thetestingaccademy.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab275 {

    @Parameters("browser")
    @Test(groups = "Browser")
    public void testDemoBrowserStarting(String Browser){
        System.out.println("The Browser selected is :"+Browser);

        switch (Browser){
            case "Mozila":
                System.out.println("And now will open Mozila");
                break;

            case "Chrome":
                System.out.println("And now will open Chrome");
                break;

            case "Firefox":
                System.out.println("And now will open Firefox");
                break;

            default:
                System.out.println("Unable to understand the command");
        }

    }
}

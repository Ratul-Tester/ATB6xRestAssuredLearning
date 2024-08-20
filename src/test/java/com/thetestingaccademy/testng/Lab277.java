package com.thetestingaccademy.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab277 {

    @Parameters("Browser")
    @Test(groups = "Browser")
    public void testDemoEdgeBrowser(String Browser){
        System.out.println("The Browser selected is :"+Browser);

        switch (Browser){
            case "chrome":
                System.out.println("And chrome will open");
                break;

            case "Edge":
                System.out.println("And Edge will open");
                break;

            default:
                System.out.println("didn't understand");
        }

    }
}

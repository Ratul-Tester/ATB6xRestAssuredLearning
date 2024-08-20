package com.thetestingaccademy.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab276 {

    @Parameters("browser")
    @Test(groups = "Browser")
    public void testDemoBrowser(String browser){
        System.out.println("Selected browser is: "+browser);

        switch (browser){
            case "chrome":
                System.out.println("Chrome browser is opening");
                break;

            case "firefox":
                System.out.println("firefox browser is opening");
                break;

            default:
                System.out.println("Couldn't understanding the browser");
        }
    }
}

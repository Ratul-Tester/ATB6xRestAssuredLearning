package com.thetestingaccademy.ex_ra01;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab278 {

    @Parameters("Browser")
    @Test(groups = "Browser")
    public void testDemoIExplorerBrowser(String Browser){
        System.out.println("The Selected Browser is :"+Browser);

        switch (Browser){
            case "chrome":
                System.out.println("Starting chrome browser");
                break;

            case "IEexplorer":
                System.out.println("Starting IE explorer browser");
                break;

            default:
                System.out.println("Couldn't understand the command");
        }
    }
}

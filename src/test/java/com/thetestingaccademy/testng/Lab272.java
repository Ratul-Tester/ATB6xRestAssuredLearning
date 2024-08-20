package com.thetestingaccademy.testng;

import org.testng.annotations.Test;

public class Lab272 {

    @Test(groups = "Sanity")
    public  void sanityRun(){
        System.out.println("Sanity run case");
    }

    @Test(groups = "QA Environment")
    public  void qualityRun(){
        System.out.println("Quality run case");
    }

    @Test(groups = {"Sanity", "Smoke"})
    public  void saniRun(){
        System.out.println("Sani run case");
    }

    @Test(groups = "Regression")
    public  void regRun(){
        System.out.println("Regression run case");
    }

    @Test(groups = "Sanity")
    public  void sanitiRun(){
        System.out.println("Saniti run case");
    }

    @Test(groups = "Smoke")
    public  void smokeRun(){
        System.out.println("Smoke run case");
    }

    @Test(groups = "QA Environment")
    public  void qaRun(){
        System.out.println("QA Environment run case");
    }
}

package com.thetestingaccademy.testng;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestTrial<integer> {

    public void addition(int a, int b){
        System.out.println("The sum of integer is " + (a+b));
    }
    public void subtraction(int a, int b){
        System.out.println("The subtraction of integer is " + (a-b));
    }
    public void multiplication(int a, int b){
        System.out.println("The multiplication of integer is " + (a*b));
    }
    public void division(int a, int b){
        System.out.println("The division of integer is " + (a/b));
    }
    @Description("Math Calculation")
    @Test
    public void calculation(){
       addition(10,5);
       subtraction(10,5);
       multiplication(10,5);
       division(10,5);

    }
}

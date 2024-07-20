package com.thetestingaccademy.testing;

import io.qameta.allure.Description;
import org.testng.annotations.Test;



public class supermath {

    @Description("Addition of Numbers")
    @Test
    public supermath addMath(int a, int b) {
        System.out.println("Addition is " + (a + b));
        return this;
    }

    @Description("Subtraction of Numbers")
    @Test
    public supermath subMath(int a, int b) {
        System.out.println("Subtraction is " + (a - b));
        return this;
    }

    @Description("Multiplication of Numbers")
    @Test
    public supermath mulMath(int a, int b) {
        System.out.println("Multiplication is " + (a * b));
        return this;
    }

    @Description("Division of Numbers")
    @Test
    public supermath divMath(int a, int b) {
        System.out.println("Division is " + (a / b));
        return this;
    }

    @Description("Arithmetics or Mathematics")
    @Test(enabled = true)
    public void calcu() {

        supermath sm = new supermath();
        sm.addMath(5, 3);
        sm.subMath(5, 3);
        sm.mulMath(5, 3);
        sm.divMath(5, 3);
    }
}

package com.thetestingaccademy.ex_ra01;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class L266 {

    @Description("TC# Hard Assert Example")
    @Test
    public void hardAssert() {
        Assert.assertEquals(201, 201, "No Match");
        Assert.assertEquals("Ratul", "ratul", "No Match");
        Assert.assertEquals(200, 200, "No Match");
        Assert.assertEquals(401, 400, "No Match");
        System.out.println("End of the Statement");
    }
}

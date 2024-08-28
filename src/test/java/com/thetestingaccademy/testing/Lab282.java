package com.thetestingaccademy.testing;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab282 {

    @Test
    public void testFakerDemo(){
        Faker faker = new Faker();
        String username = faker.name().username();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        Long phonenumber = faker.number().randomNumber(10,true);
        String password = faker.internet().password();

        System.out.println(username);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(phonenumber);
        System.out.println(password);
    }
}

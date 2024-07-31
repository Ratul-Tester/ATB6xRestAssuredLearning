package com.thetestingaccademy.ex_ra01;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Reverse {

    public void ReverseString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the value of a:");
        int a = sc.nextInt();
        System.out.println("The value of a is :"+ a);
    }

    public static void main(String[] args){
        Reverse r = new Reverse();
        r.ReverseString();
    }
}

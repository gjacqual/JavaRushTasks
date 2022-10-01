package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int cans = console.nextInt();
        int people = console.nextInt();
        double res = (double) cans / people;
        System.out.println(res);
    }
}
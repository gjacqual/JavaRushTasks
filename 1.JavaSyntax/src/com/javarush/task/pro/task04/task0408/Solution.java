package com.javarush.task.pro.task04.task0408;

import java.util.Scanner;

/*
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
       int max =  -2147483648;
       while (console.hasNextInt()) {
           int x = console.nextInt();
           if ( x > max && (x % 2 == 0)) {
               max = x;
           }
       }
        System.out.println(max);

    }
}
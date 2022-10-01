package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        while (console.hasNextInt()) {
            int x = console.nextInt();
            if (x < min) {
                second = min;
                min = x;
            }
            if (x != min && x < second) {
                second = x;
            }
        }
        System.out.println(second);
    }
}
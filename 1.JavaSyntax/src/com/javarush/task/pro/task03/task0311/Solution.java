package com.javarush.task.pro.task03.task0311;

import java.util.Locale;
import java.util.Scanner;

/* 
Высокая точность
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        double first = console.nextDouble();
        double second = console.nextDouble();

        if (Math.abs(second - first) < 0.000001) {
            System.out.println("числа равны");
        } else {
            System.out.println("числа не равны");
        }
    }
}

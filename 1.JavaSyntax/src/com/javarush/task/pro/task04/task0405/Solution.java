package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int h = 1;
        while (h <= 10) {
            int w = 1;
            while (w <= 20) {
                if (h > 1 && h < 10) {
                    if (w > 1 && w < 20) {
                        System.out.print(" ");
                    } else {
                        System.out.print("Б");
                    }
                } else {
                    System.out.print("Б");
                }
                w++;
            }
            System.out.println();
            h++;
        }

    }
}
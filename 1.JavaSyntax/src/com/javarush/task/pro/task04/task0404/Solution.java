package com.javarush.task.pro.task04.task0404;

/* 
Заполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        int j;
        while (i <= 5) {
            j = 1;
            while (j <= 10) {
                System.out.print("Q");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}